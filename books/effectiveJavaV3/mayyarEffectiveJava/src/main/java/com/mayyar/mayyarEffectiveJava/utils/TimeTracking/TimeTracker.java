package com.mayyar.mayyarEffectiveJava.utils.TimeTracking;

public interface TimeTracker {
     long startTimer();

     long calcRunTime(final long startTime, final long endTime);
     long calcRunTime(final String className);

     void startTimer(final String className);

     void stopTimer(final String className);
     TimeDifference callRunTimeDiff(String firstCallKey, String secondCallKey);

     String printAllRuntimes();

     String printAllRunTimesSorted();
}
