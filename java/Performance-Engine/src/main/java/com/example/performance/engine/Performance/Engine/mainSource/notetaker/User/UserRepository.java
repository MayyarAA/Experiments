package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User,String> {
    @Query("{name: '?0'}")
    User findByName(String name);
    public long count();
}
//    @Query(value ="{}")
