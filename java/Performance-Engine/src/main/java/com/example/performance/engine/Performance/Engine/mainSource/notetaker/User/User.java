package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.ObjectHolder;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBook;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.UUID;

@Document("user")
@Setter@Getter
public class User  extends BaseObject implements Serializable, ObjectHolder {
//    @Indexed(unique=true)
    String email;
    String notebookName;
    HashSet<String> noteBooks;
    public  User(){

    }
    public void addNewNoteBook(String noteBookId){
        if(noteBooks==null||noteBooks.isEmpty()){
            noteBooks = new HashSet<>();
        }
        noteBooks.add(noteBookId);
    }
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
