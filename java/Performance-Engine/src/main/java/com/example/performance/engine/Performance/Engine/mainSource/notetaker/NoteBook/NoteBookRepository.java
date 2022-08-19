package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;


public interface NoteBookRepository extends MongoRepository<NoteBookEntity,String> {
    @Query("{name: '?0'}")
    NoteBookEntity findItemByOwnerId(String name);
    public long count();
    @Query("{ownerId: '?0'}")
    List<NoteBookEntity> findAllNoteBooksByOwnerId(String ownerId);
    @Query("{name: '?0'}")
    List<NoteBookEntity> findAllNoteBooksByName(String name);
}
