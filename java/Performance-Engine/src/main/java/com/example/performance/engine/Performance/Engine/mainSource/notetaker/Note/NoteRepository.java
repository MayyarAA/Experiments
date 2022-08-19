package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.*;
public interface NoteRepository extends MongoRepository<NoteEntity,String> {
    @Query("{name: ?0}")
    NoteEntity findItemByName(String name);
    @Query("{name: ?0}")
    List<NoteEntity> findAllItemsByName(String name);
    public long count();
}
