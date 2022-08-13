package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import com.google.gson.Gson;
@Component
public class Note extends BaseObject implements Serializable {
    private String value;
    public Note(){
    }
    public Note(String value){
        setValue(value);
    }
    public Note(String name ,String value){
        setName(name);
        setValue(value);
    }
    public void setValue(String value){
        this.value = value;
    }
    public String getValue(){
        return  value;
    }

}
