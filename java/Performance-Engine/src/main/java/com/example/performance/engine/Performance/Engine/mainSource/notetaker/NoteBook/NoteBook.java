package com.example.performance.engine.Performance.Engine.mainSource.notetaker.NoteBook;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.ObjectHolder;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Page.Page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

public class NoteBook extends BaseObject implements Serializable, ObjectHolder {
    String description;
    private HashMap<String, Page> pageNameMap = new HashMap<>();
    private HashMap<UUID, Page> pageIdMap = new HashMap<>();
    UUID ownerId;
    public NoteBook(){

    }

    public NoteBook(String name){

    }
    public NoteBook(String name, String description){
        setDescription(description);
    }

    public NoteBook(String name, UUID ownerId, UUID id){
        super(name, id);
        this.ownerId= ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public BaseObject getById(int id) {

        return pageIdMap.get(id);
    }

    @Override
    public BaseObject getByName(String name) {
        return pageNameMap.get(name);
    }

    @Override
    public void addBaseObjectToMap(String baseObjectName) {

    }

    @Override
    public void removeById(int id) {
        removeFull(getById(id));
    }

    @Override
    public void removeByName(String name) {
        removeFull(getByName(name));
    }

    @Override
    public void removeFull(BaseObject baseObject) {
        pageIdMap.remove(baseObject.getCustomId());
        pageNameMap.remove(baseObject.getName());
    }
}
