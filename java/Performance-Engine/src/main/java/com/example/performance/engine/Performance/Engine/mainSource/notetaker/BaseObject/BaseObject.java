package com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class BaseObject implements Serializable {
    private UUID id;
    private String date;
    public BaseObject(){
        setId(UUID.randomUUID());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        setDate(dtf.format(now));
    }
    public String getDate() {
        return date;
    }

    public UUID getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
