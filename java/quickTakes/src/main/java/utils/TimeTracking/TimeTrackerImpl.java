package utils.TimeTracking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;

@Data
@Builder
@AllArgsConstructor
public class TimeTrackerImpl implements TimeTracker {
    @NonNull
    final HashMap<String, TimeTrackerContainer> timeUnitHashMap;

    public long startTimer() {
        return System.nanoTime();
    }

    public TimeDifference callRunTimeDiff(String firstCallKey, String secondCallKey) {
        if (!timeUnitHashMap.containsKey(firstCallKey) || !timeUnitHashMap.containsKey(secondCallKey)) {
            final String errorMessage = timeUnitHashMap.containsKey(firstCallKey) ?
                    String.format("first call key: %s does not exist", firstCallKey)
                    :
                    String.format("second call key: %s does not exist", secondCallKey);
            throw new IllegalStateException(errorMessage);
        }
        final long rumtTimeDiff = timeUnitHashMap.get(firstCallKey).getRunTime() -
                timeUnitHashMap.get(secondCallKey).getRunTime();
        return TimeDifference
                .builder()
                .timeDiff(rumtTimeDiff)
                .timeDiffPercentage(((double) ((double) rumtTimeDiff /
                        (double) timeUnitHashMap.get(firstCallKey).getRunTime())) * 100)
                .build();
    }


    public long calcRunTime(final long startTime, final long endTime) {
        return endTime - startTime;
    }

    public long calcRunTime(final String className) {
        TimeTrackerContainer timeTrackerTuple = timeUnitHashMap.getOrDefault(className, null);
        if (timeTrackerTuple == null) {
            throw new IllegalStateException(
                    String.format("The key:%s is not presnet in timeUnitDataStore", className));
        }
        if (timeTrackerTuple.getEndTime() == 0) {
            throw new IllegalStateException(
                    String.format("The key:%s was never stopped", className));
        }
        return timeTrackerTuple.getRunTime();
    }

    public void startTimer(final String className) {
        if (timeUnitHashMap.containsKey(className)) {
            throw new IllegalStateException(
                    String.format("%s is already tracking %s", TimeTracker.class.getName(), className));
        }
        timeUnitHashMap.put(className, TimeTrackerContainer
                .builder()
                .startTime(startTimer())
                .key(className)
                .build());
    }

    public void stopTimer(final String className) {
        final long endTime = startTimer();
        if (!timeUnitHashMap.containsKey(className)) {
            throw new IllegalStateException(
                    String.format("% is not tracking %", TimeTracker.class.getName(), className));
        }
        final TimeTrackerContainer timeTrackerTupleOrginal = timeUnitHashMap.get(className);
        final TimeTrackerContainer timeTrackerTuple = copyTimeTrackerTupleDeepNoEndTime(timeTrackerTupleOrginal, endTime);
        System.out.println("starttime" + timeTrackerTuple.getStartTime() + "entime" + timeTrackerTuple.getEndTime()
                + "runTime" + timeTrackerTuple.getRunTime());
        timeUnitHashMap.put(className, timeTrackerTuple);
    }
    private TimeTrackerContainer copyTimeTrackerTupleDeepNoEndTime(final TimeTrackerContainer timeTrackerTupleOrginal, final long endTime) {

        final long runTime = calcRunTime(timeTrackerTupleOrginal.getStartTime(), endTime);
        return TimeTrackerContainer
                .builder()
                .key(timeTrackerTupleOrginal.getKey())
                .startTime(timeTrackerTupleOrginal.getStartTime())
                .endTime(endTime)
                .runTime(runTime)
                .build();
    }
    private TimeTrackerContainer copyTimeTrackerTupleDeep(final TimeTrackerContainer timeTrackerTupleOrginal) {
        final long runTime = calcRunTime(timeTrackerTupleOrginal.getStartTime(), timeTrackerTupleOrginal.getEndTime());
        System.out.println("timeTrackerTupleOrginal.getStartTime() "  + timeTrackerTupleOrginal.getStartTime()
        +" timeTrackerTupleOrginal.getEndTime() " + timeTrackerTupleOrginal.getEndTime()

                + " runtimeitn ndansdkjasnjd " + runTime);

        return TimeTrackerContainer
                .builder()
                .key(timeTrackerTupleOrginal.getKey())
                .startTime(timeTrackerTupleOrginal.getStartTime())
                .endTime(startTimer())
                .runTime(runTime)
                .build();
    }

    public String printAllRuntimes() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TimeUnitHashMap:");
        stringBuilder.append("{");
        stringBuilder.append(" ");
        for (String key : timeUnitHashMap.keySet()) {
            stringBuilder.append(" ");
            stringBuilder.append("{");
            stringBuilder.append(String.format("key: %s , runTime: %s", key, timeUnitHashMap.get(key).getRunTime()));
            stringBuilder.append("}");
            stringBuilder.append(",");
        }
        stringBuilder.append(" ");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
