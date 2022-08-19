package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.ObjectHolder;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBook;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document("user")
public class User  extends BaseObject implements Serializable, ObjectHolder {
//    @Indexed(unique=true)
    String email;
    String notebookName;
    public  User(){

    }
//    public void
    public User(UUID userId, String notebookName){
        super(userId);
        this.notebookName= notebookName;
        addBaseObjectToMap(notebookName);

    }
    public User(String username, String date, UUID id){
        super(username, date, id);
    }
    public User(String name) {
        super(name);
    }

    public String getNotebookName() {
        return notebookName;
    }

    @Override
    public void addBaseObjectToMap(String baseObjectName) {
        NoteBook noteBook = new NoteBook(baseObjectName);
        noteBookNameMap.put(baseObjectName, noteBook);
        noteBookIdMap.put(noteBook.getCustomId(), noteBook);
    }
}
