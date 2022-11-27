package main;

import utils.Logger.LoggerImpl;
import utils.Logger.LoggerBase;
import utils.TimeTracking.TimeTrackerImpl;
import utils.TimeTracking.TimeTrackerContainer;
import threadsdemoone.RemoteCallSimulation;
import threadsdemoone.ThreadsMultiRemoteCalls;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        LoggerBase mainLogger = new LoggerImpl();
        mainLogger.log("Starting the app");
        TimeTrackerContainer timeTrackerContainer = TimeTrackerContainer
                .builder()
                .startTime(42)
                .endTime(56)
                .build();
        mainLogger.logWBreak(timeTrackerContainer.toString() + " sss " + timeTrackerContainer.getRunTime() );
        ThreadsMultiRemoteCalls threadsMultiRemoteCalls = ThreadsMultiRemoteCalls
                .builder()
                .logger(new LoggerImpl())
                .timeTracker(TimeTrackerImpl
                        .builder()
                        .timeUnitHashMap(new HashMap<String, TimeTrackerContainer>())
                        .build())
                .remoteCall(RemoteCallSimulation
                        .builder()
                        .build())
                .build();
        threadsMultiRemoteCalls.start();
//        mainLogger.log("End of the app");
    }
}
