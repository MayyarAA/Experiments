package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;

import java.io.Serializable;
import java.util.*;

public class Note extends BaseObject implements Serializable {
    private String value;
    public Note(String value){
        setValue(value);
    }
    public void setValue(String value){
        this.value = value;
    }


    public String getValue(){
        return  value;
    }
}
