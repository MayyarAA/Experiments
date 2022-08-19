package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


public interface NoteBookRepository extends MongoRepository<NoteBookEntity,String> {
}
