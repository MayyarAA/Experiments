package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Note;
import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import com.google.gson.Gson;
@Component
@Getter
@Setter
public class Note extends BaseObject implements Serializable {
    private String value;
    private String ownerId;
    private String pageId;
    public Note(){
    }
    public Note(String name, String value, String ownerId, String pageId){
        super(name);
        setValue(value);
        setOwnerId(ownerId);
        setPageId(pageId);
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
