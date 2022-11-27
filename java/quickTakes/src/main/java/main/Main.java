package main;

import utils.Logger.LoggerImpl;
import utils.Logger.LoggerBase;

public class Main {
    public static void main(String[] args){
        LoggerBase mainLogger = (LoggerBase) new LoggerImpl();
        mainLogger.log("startings");
        mainLogger.log("sassasas");
    }
}
