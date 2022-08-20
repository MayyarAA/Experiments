package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PageService {
    PageRepository pageRepository;
    CustomLogger customLogger;
    @Autowired
    public PageService(PageRepository pagerRepository, CustomLogger customLogger){
        this.pageRepository = pagerRepository;
        this.customLogger = customLogger;
    }
    public void createPage(Page page){
        PageEntity pageEntity = modelToEntityMapping(page);
        pageRepository.save(pageEntity);
        customLogger.info("Successfully Saved page " + pageEntity.getId() + " to notebook " + pageEntity.getNoteBookId());
        page.setDbId(pageEntity.getId());
        page.setOwnerId(pageEntity.getOwnerId());
    }
    public Page getPageById(String id){
        PageEntity pageEntity = pageRepository.findByPageId(id);
        Page newPage  = entityToModelMapping(pageEntity);
        return newPage;
    }

    public List<Page> getPageByName(String name){
        List<PageEntity> pageEntities = pageRepository.findAllByName(name);
        List<Page> pages = new ArrayList<>();
        for(PageEntity pageEntity: pageEntities){
            pages.add(entityToModelMapping(pageEntity));
        }

        return pages;
    }

    private PageEntity modelToEntityMapping(Page page){
        PageEntity pageEntity = new PageEntity(page.getName(), page.getOwnerId(), page.getNoteBookId());
        return pageEntity;
    }
    private Page entityToModelMapping(PageEntity pageEntity){
        if(pageEntity.isNull()) return null;
        Page page = new Page(pageEntity.getId(), pageEntity.getOwnerId(), pageEntity.getOwnerId());
        return page;
    }
}
