package com.example.performance.engine.Performance.Engine.mainSource;
import org.slf4j.*;


public class PerfomanceEngineSubClassOne {
    Logger logger = LoggerFactory.getLogger(PerfomanceEngineSubClassOne.class);

    public void start(){
        logger.info("Start of logging w/ slf4j");
        System.out.println("system outtt");
    }
}
