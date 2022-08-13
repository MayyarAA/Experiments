package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

    @Component
public abstract class BaseObject implements Serializable {
    private UUID id;
    private String date;
    private String name;
    public BaseObject(String name){
        setName(name);
        setId(UUID.randomUUID());
        createAndSetTime();
    }
    public BaseObject(){
        setId(UUID.randomUUID());
        createAndSetTime();
    }
    public String getDate() {
        return date;
    }
    public String getName(){return  name;}
    public UUID getId() {
        return id;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name){this.name = name;}
    private void createAndSetTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        setDate(dtf.format(now));
    }

}
