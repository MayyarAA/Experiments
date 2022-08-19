package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.BaseObject.BaseObject;
import com.google.gson.Gson;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Scope(value = "singleton")
public class NoteTakerUtils {
    Gson gson = new Gson();
    public  NoteTakerUtils(){

    }
    public String convertToJSON(BaseObject obj){
        return gson.toJson(obj);
    }
    public String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
