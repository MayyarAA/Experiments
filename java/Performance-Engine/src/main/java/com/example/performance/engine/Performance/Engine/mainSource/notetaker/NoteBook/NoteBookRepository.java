package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.PageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface NoteBookRepository extends MongoRepository<NoteBookEntity,String> {
    @Query("{name: ?0}")
    NoteBookEntity findItemByName(String name);
    @Query(value="{id: ?0}")
    NoteBookEntity findByNotebookId(String id);
    public long count();
    @Query(value="{ownerId: ?0}")
    List<NoteBookEntity> findAllByOwnerId(String ownerId);

//    @Query("{name: '?0'}")
//    List<NoteBookEntity> findAllNoteBooksByName(String name);
}
