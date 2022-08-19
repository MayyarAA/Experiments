package com.example.performance.engine.Performance.Engine.notetakerTests.UserServiceTests;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.User;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserEntity;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserService;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.NoteTakerUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {
    UserRepository userRepository;
    NoteBookRepository noteBookRepository;
    UserService userService;
    String username= "Tome";
    User user = new User(username);
    UserEntity userEntity = new UserEntity(username);
    @BeforeEach
    public  void setUp(){
        userRepository = mock(UserRepository.class);
        noteBookRepository = mock(NoteBookRepository.class);
        userService = new UserService(userRepository, new CustomLogger(new NoteTakerUtils()), noteBookRepository);
//        userEntity = mock(UserEntity.class);
    }
    @Test
    public void retrieveUserTest(){
        //arrange
        when(userRepository.findItemByName(username)).thenReturn(userEntity);
        //act
        User user2 = userService.retrieveUser(username);
        //assert
        Assertions.assertEquals(user2.getName(), new User(username).getName());
    }
    @Test
    public void saveUserToDataStoreTests(){
        //arrange

        //act
        userService.saveUserToDataStore(user);

        //assert
        verify(userRepository,times(1)).save(any());
    }
}
