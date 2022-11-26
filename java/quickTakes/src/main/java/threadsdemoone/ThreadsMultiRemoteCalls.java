package threadsdemoone;

import utils.Logger.BaseLogger;
import utils.Logger.MainLogger;
import utils.TimeTracking.TimeTracker;
import utils.TimeTracking.TimeTrackerBase;
import utils.TimeTracking.TimeTrackerTuple;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ThreadsMultiRemoteCalls {
    MainLogger logger;
    TimeTracker timeTracker;
    RemoteCall remoteCall;
//    public ThreadsMultiRemoteCalls(){
//        this.logger = new BaseLogger();
//        this.timeTracker =  TimeTrackerBase
//                .builder()
//                .timeUnitHashMap(new HashMap<String, TimeTrackerTuple>())
//                .build();
//        this.remoteCall = RemoteCallSimulation.builder().build();
//    }
    public void start() {
        makeTenCallsComparison();
    }

    private void makeTenCallsComparison() {
        final String singleThreadedRemoteCall = "singleThreadedRemoteCall";
        final String multiThreadedRemoteCall = "multiThreadedRemoteCall";
        //make remote call 10 times w/ 1 thread
        timeTracker.addTimer(singleThreadedRemoteCall);
        singleThreadedRemoteCall(10);
        timeTracker.addTimer(singleThreadedRemoteCall);
        //make remote call times w/ 1 thread per a call
        timeTracker.addTimer(multiThreadedRemoteCall);
        multiThreadedRemoteCall(10);
        timeTracker.addTimer(multiThreadedRemoteCall);

//        timeTracker.calcRunTime(singleThreadedRemoteCall);
//        timeTracker.calcRunTime(multiThreadedRemoteCall);
        long diff = timeTracker.callRunTimeDiff(singleThreadedRemoteCall, multiThreadedRemoteCall);
        logger.log(String.format(" diff b/w %s ran this much more/less than %s @ %s",singleThreadedRemoteCall, multiThreadedRemoteCall, diff ));

    }

    private void multiThreadedRemoteCall(final int numOfCalls) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numOfCalls; i++) {
            Thread thread = new Thread(CustomThreadOne
                    .builder()
                    .remoteCall(RemoteCallSimulation.builder().build())
                    .build(),
                    String.format("%s %s", CustomThreadOne.class.getName(), i));
            threads.add(thread);
        }

        for (int i = 0; i < numOfCalls; i++) {
            threads.get(i).start();
        }
    }

    private void singleThreadedRemoteCall(int numOfCalls) {
        for (int i = 0; i < numOfCalls; i++) {
            remoteCall.makeRemoteCall("SingleMainThreadAlone");
        }
    }

}
