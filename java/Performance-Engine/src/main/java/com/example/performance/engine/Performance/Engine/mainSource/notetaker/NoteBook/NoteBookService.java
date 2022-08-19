package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class NoteBookService {
    NoteBookRepository noteBookRepository;
    public NoteBookService(NoteBookRepository noteBookRepository){
        this.noteBookRepository = noteBookRepository;
    }
    public NoteBook getNoteBookById(String notebookid){
//        Optional<NoteBookEntity> noteBookEntity = noteBookRepository.findById(new ObjectId(notebookid));
        Optional<NoteBookEntity> noteBookEntity = noteBookRepository.findById(notebookid);
//        Optional<NoteBookEntity> noteBookEntity = noteBookRepository.findOne(new NoteBookEntity(notebookid));
        if(!noteBookEntity.isPresent()) return null;
        return mapNoteBookEntityToModel(noteBookEntity.get());
    }

    public List<NoteBook> getAllNoteBooksOwnedByUserId(String userId){
        List<NoteBook> res = new ArrayList<>();
        List<NoteBookEntity> listOfNoteBooks = noteBookRepository.findAllNoteBooksByOwnerId(userId);
        if(listOfNoteBooks.isEmpty()) return res;
        for(NoteBookEntity noteBookEntity: listOfNoteBooks){
            res.add(mapNoteBookEntityToModel(noteBookEntity));
        }
        return res;
    }

    public List<NoteBook> getAllNoteBooksByNoteBookName(String noteBookName){
        List<NoteBook> res = new ArrayList<>();
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").is(noteBookName));
//        MongoTemplate mongoTemplate = new MongoTemplate();
//        mongoTemplate.find(query, NoteBookEntity.class);
        List<NoteBookEntity> noteBookEntityList = noteBookRepository.findAllNoteBooksByName(noteBookName);
        for(NoteBookEntity noteBookEntity: noteBookEntityList){
            res.add(mapNoteBookEntityToModel(noteBookEntity));
        }
        return res;
    }
    private NoteBook mapNoteBookEntityToModel(NoteBookEntity noteBookEntity){
        NoteBook res  = new NoteBook();
        res.setOwnerId(noteBookEntity.getOwnerId());
        res.setCustomId(noteBookEntity.getCustomId());
        res.setName(noteBookEntity.getName());
        return res;
    }
}
