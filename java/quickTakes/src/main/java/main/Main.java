package main;

import utils.Logger.BaseLogger;
import utils.Logger.MainLogger;

public class Main {
    public static void main(String[] args){
        MainLogger mainLogger = (MainLogger) new BaseLogger();
        mainLogger.log("startings");
        mainLogger.log("sassasas");
    }
}
