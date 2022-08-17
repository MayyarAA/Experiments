package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.DataStores.JSONDataStore;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Component
public class UserController {
//    @Autowired
    private CustomLogger customLogger;
//    @Autowired
    private JSONDataStore jsonDataStore;

    private UserService userService;
    @Autowired
    public UserController(UserService userService, CustomLogger customLogger, JSONDataStore jsonDataStore){
        this.userService = userService;
        this.customLogger = customLogger;
        this.jsonDataStore = jsonDataStore;
    }
    @PostMapping(path ="/create")
    public ResponseEntity<User> createUser(@NotNull HttpEntity<User> httpEntity){
//        User user = httpEntity.getBody(httpEntity.getBody().getName());
        User user = new User(httpEntity.getBody().getName());
        userService.saveUserToDataStore(user);
        customLogger.info("Created user " + user.getName() + " with id " + user.getId());
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);
    }

    @GetMapping(value="/get/{name}")
    public ResponseEntity<User> getUser(@PathVariable("name") String name){
        User user = userService.retrieveUser(name);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);
    }
    @GetMapping(value="/test")
    public ResponseEntity<User> getUser(){
        User user = userService.retrieveUser("Mike");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);
    }
}
//        jsonDataStore.writeToJSONFile(user,"User","TestingFile2.json");
