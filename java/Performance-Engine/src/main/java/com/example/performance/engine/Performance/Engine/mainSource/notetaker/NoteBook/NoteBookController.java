package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.RequestObjects.AddAdminRequest;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.RequestObjects.PageLinkRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notebook")
@Component
public class NoteBookController {
    NoteBookService noteBookService;

    @Autowired
    public NoteBookController(NoteBookService noteBookService) {
        this.noteBookService = noteBookService;
    }

    @RequestMapping(path = "/get/{notebookid}", method = RequestMethod.GET)
    public ResponseEntity<NoteBook> getNotebookById(@PathVariable("notebookid") String notebookid) {
        NoteBook noteBook = noteBookService.getNoteBookById(notebookid);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(noteBook);
    }

    @RequestMapping(path = "/ownerId/{ownerId}", method = RequestMethod.GET)
    public ResponseEntity<List<NoteBook>> getAllNoteBooksForUser(@PathVariable("ownerId") String ownerId) {
        List<NoteBook> noteBooks = noteBookService.getAllNoteBooksOwnedByUserId(ownerId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(noteBooks);
    }

    @RequestMapping(path = "/name/{notebookname}", method = RequestMethod.GET)
    public ResponseEntity<NoteBook> getAllNoteBooksWithTheSameName(@PathVariable("notebookname") String notebookname) {
        NoteBook noteBooks = noteBookService.getAllNoteBooksByNoteBookName(notebookname);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(noteBooks);
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public ResponseEntity<Integer> testNoteBookController() {
        int count = noteBookService.countOfAllNotBooks();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(count);
    }

    @PostMapping(path = "/page/link")
    public ResponseEntity<Object> linkPageToNoteBook(@NotNull @RequestBody PageLinkRequest pageLinkRequest) throws Exception {
        try {
            NoteBook noteBook = noteBookService.linkPageToNoteBook(pageLinkRequest.getNoteBookId(), pageLinkRequest.getPage());
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(noteBook);

        } catch (Exception e) {
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(e.getMessage());
        }
    }

    @PostMapping(path = "/admin/add")
    public ResponseEntity<Object> addNewAdminToExistingNoteBook(@NotNull @RequestBody AddAdminRequest addAdminRequest) throws Exception {
        try {
            NoteBook noteBook = noteBookService.addAdmin(addAdminRequest.getPotentialNewAdminId(), addAdminRequest.getRequestCreaterUserId(), addAdminRequest.getNoteBookId());
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(noteBook);
        } catch (Exception e) {
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(e.getMessage());
        }
    }


}
