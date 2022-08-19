package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notebook")
@Component
public class NoteBookController {

    @GetMapping(value="/test")
    public ResponseEntity<User> getUser(){
//        User user = userService.retrieveUser("Mike");

        return null;
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);
    }


}
