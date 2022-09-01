package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.DataStores.JSONDataStore;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
class NotesInPageRequestObject implements Serializable {
    String id;
    List<String> notes;
    String pageId;
    String userId;
}

@RestController
@RequestMapping("/api/v1/page")
@Component
public class PageController {
    private CustomLogger customLogger;
    private JSONDataStore jsonDataStore;

    private PageService pageService;

    @Autowired
    public PageController(PageService pageService, CustomLogger customLogger, JSONDataStore jsonDataStore) {
        this.pageService = pageService;
        this.customLogger = customLogger;
        this.jsonDataStore = jsonDataStore;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Page> createPage(@NotNull HttpEntity<Page> httpEntity) {
        Page page = httpEntity.getBody();
        pageService.createPage(page);
        customLogger.info("Created page " + page.getName() + " with id " + page.getDbId());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(page);
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Page> getPageById(@PathVariable("id") String id) {
        Page page = pageService.getPageById(id);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(page);
    }


    @PostMapping(path = "/link/notes")
//    public ResponseEntity<Object> linkNotesToPage(@RequestBody List<String> notes, @RequestBody String pageId, @RequestBody String userId) throws Exception {
    public ResponseEntity<Object> linkNotesToPage(@RequestBody NotesInPageRequestObject notesInPageRequestObject) throws Exception {
        try {

            Page page = pageService.linkNotesToPage(notesInPageRequestObject.getNotes(), notesInPageRequestObject.getPageId(), notesInPageRequestObject.getUserId());
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(page);
        } catch (Exception e) {
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(e);
        }
    }

    @RequestMapping(path = "/get/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Page>> getPageByName(@PathVariable("name") String name) {
        List<Page> pages = pageService.getPageByName(name);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(pages);
    }


}
