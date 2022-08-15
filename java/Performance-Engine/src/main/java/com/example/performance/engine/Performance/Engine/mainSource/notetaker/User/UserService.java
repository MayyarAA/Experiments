package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User saveUserToDataStore(String name){
        User user1 = new User(name);
        UserEntity userEntity = userMappedToUserEntity(user1);
        userRepository.save(userEntity);
        return user1;
    }
    public void saveUserToDataStore(User user){
        UserEntity userEntity = userMappedToUserEntity(user);
        userRepository.save(userEntity);

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
    public User retrieveUser(String username){
        UserEntity userEntity = userRepository.findItemByName(username);
        return userEntityMappedToUser(userEntity);
    }
}
