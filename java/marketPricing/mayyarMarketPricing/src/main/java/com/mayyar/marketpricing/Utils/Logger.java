package com.mayyar.marketpricing.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static void log(String value) {
        System.out.println(String.format("Time: %s || value: %s", date(), value));
    }

    public static void logRunTimeMetrics(String caller, String timeValue) {
        Logger.log(String.format("RunTime of %s %s", caller, timeValue));
    }

    public static void start(String className) {
        System.out.println(String.format("Time: %s || START of execution: %s", date(), className));
    }

    public static void end(String className) {
        System.out.println(String.format("Time: %s || END of execution: %s", date(), className));
    }

    public static String date() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
