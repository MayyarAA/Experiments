package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/noteinput")
public class NoteTakerControllerV1 {
    Logger logger = LoggerFactory.getLogger("temp");

    @GetMapping(path ="healthcheck")
    public String healthCheck(){
        return "Note Input is up & active";
    }
    @PostMapping(path="note/simple")
    public ResponseEntity<String> simpleNotePost(HttpEntity<String> httpEntity){
        String json = httpEntity.getBody();
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(json);
    }

}
