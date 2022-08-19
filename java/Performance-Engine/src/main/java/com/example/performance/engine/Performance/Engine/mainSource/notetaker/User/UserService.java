package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBook;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookEntity;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService {
    private UserRepository userRepository;
    private NoteBookRepository noteBookRepository;
    private CustomLogger customLogger;
    @Autowired
    public UserService(UserRepository userRepository, CustomLogger customLogger,NoteBookRepository noteBookRepository ){
        this.customLogger = customLogger;
        this.userRepository = userRepository;
        this.noteBookRepository = noteBookRepository;
    }
//    @Autowired
//    public UserService(UserRepository userRepository, CustomLogger customLogger){
//        this.customLogger = customLogger;
//        this.userRepository = userRepository;
//    }
    public User saveUserToDataStore(String name){
        User user1 = new User(name);
        UserEntity userEntity = userMappedToUserEntity(user1);
        userRepository.save(userEntity);
        return user1;
    }
    public void saveUserToDataStore(User user){
        UserEntity userEntity = userMappedToUserEntity(user);
        userRepository.save(userEntity);
        customLogger.info(" saveUserToDataStore " + userEntity.getName());

    }
    public NoteBook addLinkBetweenNotebookAndUser(UUID userId, String notebookName){
        NoteBookEntity noteBookEntity = new NoteBookEntity(notebookName, userId);
        //add the notebook to db => set the <notebookId, userId>
        noteBookRepository.save(noteBookEntity);
        NoteBook noteBook2 = new NoteBook(noteBookEntity.getName(),noteBookEntity.getOwnerId());
        return noteBook2;
    }

    public void getAllNoteBooksForUser(User user){
        //go to db, query the notebook table on user.id, return all notebookEntities
    }

    public User retrieveUser(String username){
        if(username == null) return null;
        customLogger.info("looking for user w/ " + username) ;
        UserEntity userEntity = userRepository.findItemByName(username);
        customLogger.info("retrieveUser " + userEntity.getName() + " with id " + userEntity.getId());
        return userEntityMappedToUser(userEntity);
    }
    private  UserEntity userMappedToUserEntity(User user){
        UserEntity userEntity = new UserEntity(user.getName(), user.getDate(), user.getId());
        return userEntity;
    }
    private  User userEntityMappedToUser(UserEntity userEntity){
        if(userEntity==null){

        }
        User user = new User(userEntity.getName(), userEntity.getDate(), userEntity.getId());
        return user;
    }

}
