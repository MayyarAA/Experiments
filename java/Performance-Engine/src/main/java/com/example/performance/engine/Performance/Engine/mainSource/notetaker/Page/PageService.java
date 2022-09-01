package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Secuirty.NoteTakerAuthorizationService;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PageService {
    PageRepository pageRepository;
    CustomLogger customLogger;
    NoteTakerAuthorizationService noteTakerAuthorizationService;

    @Autowired
    public PageService(PageRepository pagerRepository, CustomLogger customLogger, NoteTakerAuthorizationService noteTakerAuthorizationService) {
        this.pageRepository = pagerRepository;
        this.customLogger = customLogger;
        this.noteTakerAuthorizationService = noteTakerAuthorizationService;
    }

    public void createPage(Page page) {
        PageEntity pageEntity = modelToEntityMapping(page);
        pageRepository.save(pageEntity);
        customLogger.info("Successfully Saved page " + pageEntity.getId() + " to notebook " + pageEntity.getNoteBookId());
        page.setDbId(pageEntity.getId());
        page.setOwnerId(pageEntity.getOwnerId());
    }

    public Page getPageById(String id) {
        PageEntity pageEntity = pageRepository.findByPageId(id);
        Page newPage = entityToModelMapping(pageEntity);
        return newPage;
    }

    public List<Page> getPageByName(String name) {
        List<PageEntity> pageEntities = pageRepository.findAllByName(name);
        List<Page> pages = new ArrayList<>();
        for (PageEntity pageEntity : pageEntities) {
            pages.add(entityToModelMapping(pageEntity));
        }

        return pages;
    }

    private PageEntity modelToEntityMapping(Page page) {
        PageEntity pageEntity = new PageEntity(page.getName(), page.getOwnerId(), page.getNoteBookId());
        pageEntity.setNotes(page.getNotes());
        pageEntity.setId(page.getDbId());
        pageEntity.setNoteBookId(page.getNoteBookId());
        return pageEntity;
    }

    private Page entityToModelMapping(PageEntity pageEntity) {
        if (pageEntity.isNull()) return null;
        Page page = new Page(pageEntity.getId(), pageEntity.getOwnerId(), pageEntity.getNoteBookId());
        page.setDbId(pageEntity.getId());
        page.setNoteBookId(pageEntity.getNoteBookId());
        page.setNotes(page.getNotes());
        return page;
    }

    public String createAndSavePage(Page page, String noteBookId) {
        PageEntity pageEntity = modelToEntityMapping(page);
        pageRepository.save(pageEntity);
        return pageEntity.getId();
    }

    public Page linkNotesToPage(List<String> notes, String pageId, String userId) throws Exception {
        //get pageEntity
        PageEntity pageEntity = pageRepository.findByPageId(pageId);
        Page page = entityToModelMapping(pageEntity);
        if (pageEntity.isNull()) throw new Exception("Error page does not exits");
        //check if userId is editor or owner
        if (!noteTakerAuthorizationService.isAllowedToAddNoteToPage(userId, null))
            throw new Exception("User not authorized to add note to page");
        //add notes
        addNotesToPage(notes, page);
        //add page back to db
        PageEntity pageEntity1 = modelToEntityMapping(page);
        pageRepository.save(pageEntity1);
        return page;
    }

    private void addNotesToPage(List<String> notes, Page page) {
        for (String note : notes) {

            page.addNote(note);
        }
    }
}
