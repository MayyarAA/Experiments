package com.example.performance.engine.Performance.Engine.mainSource.notetaker.User;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.ObjectHolder;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note.Note;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBook;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

@Document("user")
public class User  extends BaseObject implements Serializable, ObjectHolder {
//    @Indexed(unique=true)
    String email;
    public  User(){

    }
    public User(String username, String date, UUID id){
        super(username, date, id);
    }
    public User(String name) {
        super(name);
    }
}