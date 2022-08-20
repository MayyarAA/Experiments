package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

    @Document
    @Component
public abstract class BaseObject implements Serializable {
    private String dbId;
    private UUID customId;
    private String date;
    private String name;
    public BaseObject(String name, String date, UUID id){
        setName(name);
        setCustomId(UUID.randomUUID());
        setDate(date);
    }
    public BaseObject(UUID id){
        setCustomId(id);
    }
    public BaseObject(String name, UUID id){
        setName(name);
        setCustomId(id);
    }

        public void setDbId(String dbId) {
            this.dbId = dbId;
        }

        public String getDbId() {
            return dbId;
        }

        public BaseObject(String name){
        setName(name);
        setCustomId(UUID.randomUUID());
        createAndSetTime();
    }
    public BaseObject(){
        setCustomId(UUID.randomUUID());
        createAndSetTime();
    }
    public String getDate() {
        return date;
    }
    public String getName(){return  name;}
    public UUID getCustomId() {
        return customId;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setCustomId(UUID customId) {
        this.customId = customId;
    }
    public void setName(String name){this.name = name;}
    private void createAndSetTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        setDate(dtf.format(now));
    }

    public boolean isEmpty(){
        if(customId == null ) return true;
        return false;
    }

}
