package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBook;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookEntity;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookService;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    private UserRepository userRepository;
    private NoteBookRepository noteBookRepository;
    private CustomLogger customLogger;
    private NoteBookService noteBookService;
    @Autowired
    public UserService(UserRepository userRepository, CustomLogger customLogger, NoteBookRepository noteBookRepository, NoteBookService noteBookService ){
        this.customLogger = customLogger;
        this.userRepository = userRepository;
        this.noteBookRepository = noteBookRepository;
        this.noteBookService = noteBookService;
    }

    public User saveUserToDataStore(String name){
        User user1 = new User(name);
        UserEntity userEntity = userMappedToUserEntity(user1);
        userRepository.save(userEntity);
        return user1;
    }
    public User retrieveUserById(String id){
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isEmpty()) return null;
        return userEntityMappedToUser(userEntity.get());
    }
    public void saveUserToDataStore(User user){
        UserEntity userEntity = userMappedToUserEntity(user);
        userRepository.save(userEntity);
        user.setDbId(userEntity.getId().toString());
        customLogger.info(" saveUserToDataStore " + userEntity.getName());

    }
    public NoteBook addLinkBetweenNotebookAndUser(User user, String notebookName){
        NoteBook noteBook = noteBookService.createNoteBook(user, notebookName);
        //TO:DO append user obj w/ new notebookId
        return noteBook;
    }

    public void getAllNoteBooksForUser(String userId){
        //go to db, query the notebook table on user.id, return all notebookEntities
        noteBookRepository.findAllByOwnerId(userId);
    }

    public User retrieveUser(String username){
        if(username == null) return null;
        customLogger.info("looking for user w/ " + username) ;
        UserEntity userEntity = userRepository.findItemByName(username);
        customLogger.info("retrieveUser " + userEntity.getName() + " with id " + userEntity.getCustomId());
        return userEntityMappedToUser(userEntity);
    }

    private  UserEntity userMappedToUserEntity(User user){
        UserEntity userEntity = new UserEntity(user.getName(), user.getDate(), user.getCustomId());
        return userEntity;
    }
    private  User userEntityMappedToUser(UserEntity userEntity){
        if(userEntity==null){

        }
        User user = new User(userEntity.getName(), userEntity.getDate(), userEntity.getCustomId());
        user.setDbId(userEntity.getId().toString());
        return user;
    }

}
