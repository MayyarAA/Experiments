package com.mayyar.mayyarEffectiveJava.utils.Logger;

public interface LoggerBase {

    public void log(String value);

    public void logWBreak(String value);

    public void warn(String value);

    public void error(String value);

    public void warn(String value, String warningMessage);

    public void error(String value, String errorMessage);

    public void logRunTimeMetrics(String caller, String timeValue);

    public void logRunTimeMetrics(String caller, long runTime);

    public void start(String className);

    public void end(String className);
}
