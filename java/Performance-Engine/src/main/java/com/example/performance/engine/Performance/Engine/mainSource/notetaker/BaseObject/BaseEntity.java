package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.NoteTakerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class BaseEntity {
    @Autowired
    NoteTakerUtils noteTakerUtils;
    @Indexed(unique=true)
    private UUID id;
    private String date;
    private String name;
    public BaseEntity(String name, String date, UUID id){
        setName(name);
        setId(id);
        setDate(date);
    }
    public BaseEntity(String name){
        setName(name);
        setId(UUID.randomUUID());
        if(this.date!=null) setDate(noteTakerUtils.getCurrentTime());
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
