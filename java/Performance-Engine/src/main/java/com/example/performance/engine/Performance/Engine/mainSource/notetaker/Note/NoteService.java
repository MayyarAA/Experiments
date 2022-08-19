package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.User.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import javax.management.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Component
public class NoteService implements Serializable {
    private NoteRepository noteRepository;
    @Autowired
    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    void saveNoteToDataStore(Note note){
        NoteEntity noteEntity = modelToEntityMapping(note);
        noteRepository.save(noteEntity);
        note.setDbId(noteEntity.getId().toString());
    }
    Note retrieveNoteById(String noteId){
        Optional<NoteEntity> noteEntity = noteRepository.findById(noteId);
        if(noteEntity.isEmpty()) return null;
        return entityToModelMapping(noteEntity.get());
    }
    Note entityToModelMapping(NoteEntity noteEntity){
        return new Note(noteEntity.getName(),noteEntity.getValue(),noteEntity.getOwnerId(),noteEntity.getPageId());
    }
    NoteEntity modelToEntityMapping(Note note){
        return new NoteEntity(note.getName(), note.getValue(),note.getOwnerId(), note.getPageId());
    }

    public Note retrieveNote(String name) {
//        NoteEntity noteEntity = noteRepository.findItemByName(name);
        List<NoteEntity> noteEntityList = noteRepository.findAllItemsByName(name);

//        List<NoteEntity> noteEntityList = noteRepository.findOne(Criteria.where("_id").is(name));
        return entityToModelMapping(null);
    }
}
