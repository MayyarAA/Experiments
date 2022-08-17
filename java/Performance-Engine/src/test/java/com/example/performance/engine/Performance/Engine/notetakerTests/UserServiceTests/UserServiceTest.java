package com.example.performance.engine.Performance.Engine.notetakerTests.UserServiceTests;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.User;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    User user = new User("Tome");
    @Test
    public void saveUserToDataStoreTests(){

//        userService.saveUserToDataStore(user);
    }
}
