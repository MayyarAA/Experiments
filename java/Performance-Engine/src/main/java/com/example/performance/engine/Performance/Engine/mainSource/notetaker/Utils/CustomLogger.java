package com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomLogger {
    Logger logger = LoggerFactory.getLogger("temp");
    @Autowired
    private NoteTakerUtils noteTakerUtils;
    public void info(String message){
        logger.info("Time: " +" "
                + noteTakerUtils.getCurrentTime()+ " " + message );
    }
//    public void info(String message, 2){
//        logger.info("Time: " +" " + noteTakerUtils.getCurrentTime()+ " " + message );
//    }
}
