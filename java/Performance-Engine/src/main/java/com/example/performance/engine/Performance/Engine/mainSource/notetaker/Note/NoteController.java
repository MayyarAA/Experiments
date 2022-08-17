package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.DataStores.JSONDataStore;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/note")
@Component
public class NoteController {
    private CustomLogger customLogger;
    private JSONDataStore jsonDataStore;
    @Autowired
    public NoteController(CustomLogger customLogger, JSONDataStore jsonDataStore){
        this.customLogger = customLogger;
    }
    @PostMapping(path ="/create")
    public ResponseEntity<Note> objectHealth(HttpEntity<Note> httpEntity){
        Note note = new Note(httpEntity.getBody().getName(), httpEntity.getBody().getValue());
        customLogger.info("creating note " + (httpEntity.getBody().getValue()));
//        jsonDataStore.writeToJSONFile(note,"Test" ,"TestingFile2.json");
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(note);
    }
}
