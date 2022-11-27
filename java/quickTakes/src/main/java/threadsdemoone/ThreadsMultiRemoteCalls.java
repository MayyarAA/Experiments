package threadsdemoone;

import utils.Logger.LoggerBase;
import utils.TimeTracking.TimeDifference;
import utils.TimeTracking.TimeTracker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ThreadsMultiRemoteCalls {
    LoggerBase logger;
    TimeTracker timeTracker;
    RemoteCall remoteCall;

    public void start() {
        makeTenCallsComparison();
    }

    private void makeTenCallsComparison() {
        final String singleThreadedRemoteCall = "singleThreadedRemoteCall";
        final String multiThreadedRemoteCall = "multiThreadedRemoteCall";
        final String multiThreadedRemoteCallWAsync = "multiThreadedRemoteCallWAsync";
        //make remote call 10 times w/ 1 thread
        timeTracker.startTimer(singleThreadedRemoteCall);
        singleThreadedRemoteCall(10);
        timeTracker.stopTimer(singleThreadedRemoteCall);
        //make remote call times w/ 1 thread per a call
        timeTracker.startTimer(multiThreadedRemoteCall);
        multiThreadedRemoteCall(10);
        timeTracker.stopTimer(multiThreadedRemoteCall);

        TimeDifference diff = timeTracker.callRunTimeDiff(singleThreadedRemoteCall, multiThreadedRemoteCall);

        logger.log(String.format(" %s ran this much more/less than %s @ %s ",
                singleThreadedRemoteCall, multiThreadedRemoteCall, diff));


        timeTracker.startTimer(multiThreadedRemoteCallWAsync);
        multiThreadedRemoteCallASync(10);
        timeTracker.stopTimer(multiThreadedRemoteCallWAsync);
//        logger.logRunTimeMetrics(multiThreadedRemoteCallWAsync, timeTracker.calcRunTime(multiThreadedRemoteCallWAsync));
        logger.logWBreak(timeTracker.printAllRuntimes());

    }

    private void multiThreadedRemoteCallASync(final int numOfCalls) {
        ExecutorServiceSimple threadPoolExecutorSimple = ExecutorServiceSimple
                .builder()
                .executorService(new ThreadPoolExecutor(numOfCalls, numOfCalls, 0L,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>()))
                .build();

        List<Callable<String>> runnables = new ArrayList<>();
        for (int i = 0; i < numOfCalls; i++) {
            runnables.add(RemoteCallOne
                    .builder()
                    .runnableName(String.format("%s %s", RemoteCallOne.class.getName(), i))
                    .remoteCall(RemoteCallSimulation.builder().build())
                    .build());
        }
        try {
            threadPoolExecutorSimple.executorService.invokeAll(runnables);
            threadPoolExecutorSimple.gracefullyTerminate();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error from multiThreadedRemoteCallASync", e.getMessage());
        }
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
        Thread printingThread = new Thread(PrintingThread.builder().build(), "PrintingThread1");
        for (int i = 0; i < numOfCalls; i++) {
            threads.get(i).start();
//            printingThread.wait(threads.get(i));
        }
    }

    private void singleThreadedRemoteCall(int numOfCalls) {
        for (int i = 0; i < numOfCalls; i++) {
            remoteCall.makeRemoteCall("SingleMainThreadAlone");
        }
    }

    private void makePrintingThreadWait(final Thread thread) {
//        Thread.currentThread().join(thread);
    }

}
