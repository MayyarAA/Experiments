package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.DataStores.JSONDataStore;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note.Note;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Component
public class UserController {
    @Autowired
    private CustomLogger customLogger;
    @Autowired
    private JSONDataStore jsonDataStore;
    @Autowired
    private UserRepository userRepository;
    @PostMapping(path ="/create")
    public ResponseEntity<User> createUser(HttpEntity<String> httpEntity){
        User user = new User(httpEntity.getBody());
        userRepository.save(user);
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);
    }
}
//        jsonDataStore.writeToJSONFile(user,"User","TestingFile2.json");
