package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserRepository;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class NoteBookService {
    private NoteBookRepository noteBookRepository;
    private CustomLogger customLogger;
    @Autowired
    public NoteBookService( CustomLogger customLogger, NoteBookRepository noteBookRepository ){
        this.customLogger = customLogger;
        this.noteBookRepository = noteBookRepository;

    }
    public int countOfAllNotBooks(){
        return noteBookRepository.findAll().size();
    }
    public NoteBook getNoteBookById(String notebookid){
        Optional<NoteBookEntity> noteBookEntity = noteBookRepository.findById(notebookid);
//        Optional<NoteBookEntity> noteBookEntity = noteBookRepository.findOne(new NoteBookEntity(notebookid));
        if(!noteBookEntity.isPresent()) return null;
        return mapNoteBookEntityToModel(noteBookEntity.get());
    }

    public List<NoteBook> getAllNoteBooksOwnedByUserId(String userId){
        List<NoteBook> res = new ArrayList<>();
        List<NoteBookEntity> listOfNoteBooks = noteBookRepository.findAllByOwnerId(userId);
        if(listOfNoteBooks.isEmpty()) return res;
        for(NoteBookEntity noteBookEntity: listOfNoteBooks){
            res.add(mapNoteBookEntityToModel(noteBookEntity));
        }
        return res;
    }

    public NoteBook getAllNoteBooksByNoteBookName(String noteBookName){
        List<NoteBook> res = new ArrayList<>();
//        Query query = new Query();
//        query.addCriteria(Criteria.where("name").is(noteBookName));
//        MongoTemplate mongoTemplate = new MongoTemplate();
//        mongoTemplate.find(query, NoteBookEntity.class);
        if(noteBookRepository == null) return null;
        NoteBookEntity noteBookEntityList = noteBookRepository.findItemByName(noteBookName);
        return mapNoteBookEntityToModel(noteBookEntityList);
    }
    public NoteBook mapNoteBookEntityToModel(NoteBookEntity noteBookEntity){
        NoteBook res  = new NoteBook();
        res.setOwnerId(noteBookEntity.getOwnerId());
        res.setCustomId(noteBookEntity.getCustomId());
        res.setName(noteBookEntity.getName());
        return res;
    }
//    public NoteBook entityMapToModel(NoteBookEntity noteBookEntity){

//    }
}
