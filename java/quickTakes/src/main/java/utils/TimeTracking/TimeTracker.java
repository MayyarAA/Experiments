package utils.TimeTracking;

public interface TimeTracker {
     long startTimer();

     long calcRunTime(final long startTime, final long endTime);
     long calcRunTime(final String className);

     void addTimer(final String className);
     long callRunTimeDiff(String firstCallKey, String secondCallKey);

     String startTimeSave();
}
