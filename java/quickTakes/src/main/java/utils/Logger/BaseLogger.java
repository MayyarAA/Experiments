package utils.Logger;

import utils.Logger.MainLogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseLogger implements MainLogger {
    public static void test() {
        System.out.println("ptining ");
    }

    public void log(String value) {
        System.out.println(String.format("Time: %s || value: %s", date(), value));
    }

    public void logRunTimeMetrics(String caller, String timeValue) {
        log(String.format("RunTime of %s %s", caller, timeValue));
    }

    public void start(String className) {
        System.out.println(String.format("Time: %s || START of execution: %s", date(), className));
    }

    public void end(String className) {
        System.out.println(String.format("Time: %s || END of execution: %s", date(), className));
    }

    private String date() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
