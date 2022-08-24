package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.Page;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.PageEntity;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Component
public class NoteService implements Serializable {
    private NoteRepository noteRepository;
    private PageRepository pageRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, PageRepository pageRepository) {
        this.noteRepository = noteRepository;
        this.pageRepository = pageRepository;
    }

    void saveNoteToDataStore(Note note) {
        NoteEntity noteEntity = modelToEntityMapping(note);
        noteRepository.save(noteEntity);
        note.setDbId(noteEntity.getId().toString());
    }

    Note retrieveNoteById(String noteId) {
        Optional<NoteEntity> noteEntity = noteRepository.findById(noteId);
        if (noteEntity.isEmpty()) return null;
        return entityToModelMapping(noteEntity.get());
    }

    Note entityToModelMapping(NoteEntity noteEntity) {
        return new Note(noteEntity.getName(), noteEntity.getValue(), noteEntity.getOwnerId(), noteEntity.getPageId());
    }

    NoteEntity modelToEntityMapping(Note note) {
        return new NoteEntity(note.getName(), note.getValue(), note.getOwnerId(), note.getPageId());
    }

    public Note retrieveNote(String name) {
        List<NoteEntity> noteEntityList = noteRepository.findAllItemsByName(name);

        return entityToModelMapping(null);
    }

    public void createAndSavePage(Page page, String noteBookId) {
        page.setNoteBookId(noteBookId);
        PageEntity pageEntity = new PageEntity();
        pageRepository.save(pageEntity);
    }
}
