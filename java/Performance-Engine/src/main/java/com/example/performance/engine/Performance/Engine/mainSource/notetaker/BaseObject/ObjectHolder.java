package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note.Note;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook.NoteBook;

import java.util.HashMap;

public interface ObjectHolder {
     HashMap<String, BaseObject> noteBookNameMap = new HashMap<>();
     HashMap<Integer, BaseObject> noteBookIdMap = new HashMap<>();
    public default BaseObject getById(int id){
        return noteBookIdMap.get(id);
    }
    public default BaseObject getByName(String name){
        return noteBookNameMap.get(name);
    }
    public default void removeById(int id){
        removeFull(getById(id));
    }
    public  default void removeByName(String name){
        removeFull(getByName(name));
    }
    public  default void removeFull(BaseObject baseObject){
        noteBookIdMap.remove(baseObject.getId());
        noteBookNameMap.remove(baseObject.getName());
    }
}
