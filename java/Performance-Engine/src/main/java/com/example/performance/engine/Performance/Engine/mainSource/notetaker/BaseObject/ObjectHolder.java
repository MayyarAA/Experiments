package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import java.util.HashMap;
import java.util.UUID;

public interface ObjectHolder {
    HashMap<String, BaseObject> noteBookNameMap = new HashMap<>();
    HashMap<UUID, BaseObject> noteBookIdMap = new HashMap<>();
    public default BaseObject getById(int id){
        return noteBookIdMap.get(id);
    }
    public default BaseObject getByName(String name){
        return noteBookNameMap.get(name);
    }
    public void addBaseObjectToMap(String baseObjectName);
    public default void removeById(int id){
        removeFull(getById(id));
    }
    public  default void removeByName(String name){
        removeFull(getByName(name));
    }
    public  default void removeFull(BaseObject baseObject){
        noteBookIdMap.remove(baseObject.getCustomId());
        noteBookNameMap.remove(baseObject.getName());
    }
}
