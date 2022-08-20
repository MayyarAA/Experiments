package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PageRepository extends MongoRepository<PageEntity,String> {
    public long count();
    @Query(value="{name: ?0}")
    List<PageEntity> findAllByName(String name);
    @Query(value="{ownerId: ?0}")
    List<PageEntity> findAllByOwnerId(String ownerId);
    @Query(value="{id: ?0}")
    PageEntity findAllByPageId(String pageId);

    @Query(value="{noteBookId: ?0}")
    List<PageEntity> findAllByNoteBookId(String noteBookId);
}
