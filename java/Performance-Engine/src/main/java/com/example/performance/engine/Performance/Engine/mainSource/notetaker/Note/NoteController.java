package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.DataStores.JSONDataStore;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.User;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/note")
@Component
public class NoteController {
    private CustomLogger customLogger;
    private JSONDataStore jsonDataStore;
    private NoteService noteService;
    @Autowired
    public NoteController(CustomLogger customLogger, JSONDataStore jsonDataStore, NoteService noteService ){
        this.customLogger = customLogger;
        this.noteService = noteService;
    }
    @PostMapping(path ="/create")
    public ResponseEntity<Note> objectHealth(HttpEntity<Note> httpEntity){
//        Note note = new Note(httpEntity.getBody().getName(), httpEntity.getBody().getValue());
        Note note = httpEntity.getBody();
        noteService.saveNoteToDataStore(note);
        customLogger.info("creating note " + (httpEntity.getBody().getValue()));
//        jsonDataStore.writeToJSONFile(note,"Test" ,"TestingFile2.json");
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(note);
    }

    @RequestMapping(path = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Note> getUserById(@PathVariable("id") String noteId){
        Note note = noteService.retrieveNoteById(noteId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(note);
    }

    @RequestMapping(path = "/get/{name}", method = RequestMethod.GET)
    public ResponseEntity<Note> getUser(@PathVariable("name") String name){
        Note note = noteService.retrieveNote(name);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(note);
    }
}
