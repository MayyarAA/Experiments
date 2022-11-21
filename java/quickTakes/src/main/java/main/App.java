package main;

import Logger.BaseLogger;
import Logger.MainLogger;
import PerformanceMetrics.TimeTracking.TimeTrackerBase;
import PerformanceMetrics.TimeTracking.TimeTrackerTuple;
import threadsdemoone.RemoteCallSimulation;
import threadsdemoone.ThreadsMultiRemoteCalls;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        MainLogger mainLogger = new BaseLogger();
        mainLogger.log("startings");
        mainLogger.log("sassasas");
        ThreadsMultiRemoteCalls threadsMultiRemoteCalls = ThreadsMultiRemoteCalls
                .builder()
                .logger(new BaseLogger())
                .timeTracker(TimeTrackerBase
                        .builder()
                        .timeUnitHashMap(new HashMap<String, TimeTrackerTuple>())
                        .build())
                .remoteCall(RemoteCallSimulation
                        .builder()
                        .build())
                .build();
        threadsMultiRemoteCalls.start();
    }
}
