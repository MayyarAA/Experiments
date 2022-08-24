package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.Page;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.PageService;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Secuirty.NoteTakerAuthorizationService;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.User;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.ErrorCodes;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.ErrorCodesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
public class NoteBookService {
    private NoteTakerAuthorizationService noteTakerAuthorizationService;
    private NoteBookRepository noteBookRepository;
    private CustomLogger customLogger;
    private PageService pageService;

    @Autowired
    public NoteBookService(CustomLogger customLogger, NoteBookRepository noteBookRepository, NoteTakerAuthorizationService noteTakerAuthorizationService, PageService pageService) {
        this.customLogger = customLogger;
        this.noteBookRepository = noteBookRepository;
        this.noteTakerAuthorizationService = noteTakerAuthorizationService;
        this.pageService = pageService;

    }

    public int countOfAllNotBooks() {
        return noteBookRepository.findAll().size();
    }

    public NoteBook getNoteBookById(String notebookid) {
        Optional<NoteBookEntity> noteBookEntity = noteBookRepository.findById(notebookid);
        if (!noteBookEntity.isPresent()) return null;
        return entityToModel(noteBookEntity.get());
    }

    public List<NoteBook> getAllNoteBooksOwnedByUserId(String userId) {
        List<NoteBook> res = new ArrayList<>();
        List<NoteBookEntity> listOfNoteBooks = noteBookRepository.findAllByOwnerId(userId);
        if (listOfNoteBooks.isEmpty()) return res;
        for (NoteBookEntity noteBookEntity : listOfNoteBooks) {
            res.add(entityToModel(noteBookEntity));
        }
        return res;
    }

    public NoteBook getAllNoteBooksByNoteBookName(String noteBookName) {
        if (noteBookRepository == null) return null;
        NoteBookEntity noteBookEntityList = noteBookRepository.findItemByName(noteBookName);
        return entityToModel(noteBookEntityList);
    }

    public NoteBook entityToModel(NoteBookEntity noteBookEntity) {
        NoteBook res = new NoteBook();
        res.setOwnerId(noteBookEntity.getOwnerId());
        res.setDbId(noteBookEntity.getId());
        res.setCustomId(noteBookEntity.getCustomId());
        res.setName(noteBookEntity.getName());
        res.setAdmins(noteBookEntity.getAdmins());
        res.setViewers(noteBookEntity.getViewers());
        res.setNotes(noteBookEntity.getPages());
        return res;
    }

    public NoteBookEntity modelToEntity(NoteBook noteBook) {
        NoteBookEntity noteBookEntity = new NoteBookEntity(noteBook.getName(), noteBook.getDbId(), noteBook.getOwnerId(), noteBook.getAdmins(), noteBook.getViewers());
        return noteBookEntity;
    }

    public NoteBook addAdmin(String potentialAdminId, String currentAdminMakingRequest, String noteBookId) throws Exception {
        NoteBookEntity noteBookEntity = noteBookRepository.findByNotebookId(noteBookId);
        NoteBook noteBook = entityToModel(noteBookEntity);
        if (noteTakerAuthorizationService.isAllowedToAddNewAdmin(potentialAdminId, currentAdminMakingRequest, noteBook)) {
            noteBook.addAdmin(potentialAdminId);
            return updateNoteBook(noteBook);
        }
        throw new Exception(ErrorCodes.getErrorCodes().get(ErrorCodesEnum.ERROR_USER_NOT_AUTHORIZED_TO_ADD_NEW_ADMIN));
    }

    public NoteBook updateNoteBook(NoteBook noteBook) {
        NoteBookEntity noteBookEntity = modelToEntity(noteBook);
//        noteBookRepository.delete(noteBookEntity);
        noteBookRepository.save(noteBookEntity);
        return entityToModel(noteBookEntity);
    }

    public NoteBook createNoteBook(User user, String notebookName) {
        NoteBook noteBook = new NoteBook(notebookName, user.getDbId(), true);
        NoteBookEntity noteBookEntity = modelToEntity(noteBook);
        noteBookRepository.save(noteBookEntity);
        noteBook.setDbId(noteBookEntity.getId());
        return noteBook;
    }

    public NoteBook linkPageToNoteBook(String noteBookId, Page page) throws Exception {
        NoteBookEntity noteBookEntity = noteBookRepository.findByNotebookId(noteBookId);
        if (noteBookEntity.isNull()) {
            throw new Exception("Note book does not exists");
        }
        page.setOwnerId(noteBookEntity.getOwnerId());
        page.setNoteBookId(noteBookEntity.getId());
        String pageId = pageService.createAndSavePage(page, noteBookEntity.getId());
        if (noteBookEntity.getPages() == null) {
            HashSet<String> pages = new HashSet<>();
            pages.add(pageId);
            noteBookEntity.setPages(pages);
        } else {
            noteBookEntity.getPages().add(page.getDbId());
        }
        noteBookRepository.save(noteBookEntity);


        NoteBook noteBook = entityToModel(noteBookEntity);
        return noteBook;
    }
}
