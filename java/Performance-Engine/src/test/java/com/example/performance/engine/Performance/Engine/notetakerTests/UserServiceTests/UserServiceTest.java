package com.example.performance.engine.Performance.Engine.notetakerTests.UserServiceTests;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.User;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserEntity;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {
    UserRepository userRepository = mock(UserRepository.class);
    UserService userService = new UserService(userRepository);
    String username= "Tome";
    User user = new User(username);
    UserEntity userEntity = new UserEntity(username);
    @Test
    public void retrieveUserTest(){
        when(userRepository.findItemByName(username)).thenReturn(userEntity);
        User user2 = userService.retrieveUser(username);
        Assertions.assertEquals(user2.getName(), new User(username).getName());
    }
    @Test
    public void saveUserToDataStoreTests(){
//        userService.saveUserToDataStore(user);
    }
}
