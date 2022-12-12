package com.mayyar.mayyarEffectiveJava.utils.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerImpl implements LoggerBase {
    private static final String WARN_KEY = "WARNING";
    private static final String ERROR_KEY = "ERROR";
    private static final String CUSTOM_LOGGING_BREAK =
            "----------------------------------------------------------------------";

    public static void test() {
        System.out.println("ptining ");
    }

    public void log(String value) {
        System.out.println(String.format("Time: %s || value: %s", date(), value));
    }

    public void logWBreak(String value) {
        System.out.println(CUSTOM_LOGGING_BREAK);
        log(value);
    }

    public void warn(String value) {
        System.out.println(String.format("Time: %s || %s || value: %s", date(), WARN_KEY, value));
    }

    public void error(String value) {
        System.out.println(String.format("Time: %s || %s || value: %s", date(), ERROR_KEY, value));
    }

    public void warn(final String value, final String warningMessage) {
        System.out.println(String.format("Time: %s || %s: %s || value: %s", date(), WARN_KEY, warningMessage, value));
    }

    public void error(final String value, final String errorMessage) {
        System.out.println(String.format("Time: %s || %s: %s || value: %s", date(), ERROR_KEY, errorMessage, value));
    }

    public void logRunTimeMetrics(String caller, String timeValue) {
        log(String.format("RunTime of %s: %s", caller, timeValue));
    }

    public void logRunTimeMetrics(String caller, long timeValue) {
        log(String.format("RunTime of %s: %s", caller, timeValue));
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
