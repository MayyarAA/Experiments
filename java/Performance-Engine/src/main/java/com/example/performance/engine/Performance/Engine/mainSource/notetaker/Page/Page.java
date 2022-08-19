package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.ObjectHolder;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note.Note;

import java.io.Serializable;
import java.util.*;

public class Page extends BaseObject implements Serializable, ObjectHolder {

    private HashMap<String, Note> noteNameMap = new HashMap<>();
    private HashMap<UUID, Note> noteIdMap = new HashMap<>();
    public void addNote(Note note){
        noteNameMap.put(note.getName(), note);
        noteIdMap.put(note.getCustomId(), note);
    }
    public int getNumberOfNotes(){
        return noteIdMap.size();
    }
    @Override
    public BaseObject getById(int id){
        return noteIdMap.get(id);
    }

    @Override
    public BaseObject getByName(String name){
        return noteNameMap.get(name);
    }

    @Override
    public void addBaseObjectToMap(String baseObjectName) {

    }

    @Override
    public synchronized void removeByName(String name){
        Note note = noteNameMap.get(name);
        removeFull(note);
    }
    @Override
    public synchronized void removeById(int id){
        Note note = noteIdMap.get(id);
        removeFull(note);
    }

    @Override
     public void removeFull(BaseObject baseObject){
        noteIdMap.remove(baseObject.getCustomId());
        noteNameMap.remove(baseObject.getName());

    }

}

