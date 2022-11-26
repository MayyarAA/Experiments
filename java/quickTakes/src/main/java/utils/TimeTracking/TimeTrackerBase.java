package utils.TimeTracking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class TimeTrackerBase implements TimeTracker {
    @NonNull
    final HashMap<String, TimeTrackerTuple> timeUnitHashMap;

    public long startTimer() {
        return System.nanoTime();
    }

    public long callRunTimeDiff(String firstCallKey, String secondCallKey){
        if(!timeUnitHashMap.containsKey(firstCallKey) || !timeUnitHashMap.containsKey(secondCallKey)){
            final String errorMessage = timeUnitHashMap.containsKey(firstCallKey) ?
                    String.format("first call key: %s does not exist", firstCallKey)
                    :
                    String.format("second call key: %s does not exist", secondCallKey) ;
            throw new IllegalStateException(errorMessage);
        }
        return calcRunTime(calcRunTime(firstCallKey), calcRunTime(secondCallKey));
    }

    public String startTimeSave() {
        final String key = UUID.randomUUID().toString();
        timeUnitHashMap.put(key, TimeTrackerTuple
                .builder()
                .key(key)
                .startTime(startTimer())
                .build());
        return key;
    }

    public long calcRunTime(final long startTime, final long endTime) {
        return endTime - startTime;
    }

    public long calcRunTime(final String className) {
        if (!timeUnitHashMap.containsKey(className)) {
            throw new IllegalStateException(
                    String.format("The className:%s is not presnet in timeUnitDataStore", className));
        }
        final TimeTrackerTuple timeTrackerTuple = timeUnitHashMap.get(className);
        if (timeTrackerTuple.getEndTime() != 0) {
            return calcRunTime(timeTrackerTuple.getStartTime(), timeTrackerTuple.getEndTime());
        }
        final TimeTrackerTuple timeTrackerTupleSecond = copyTimeTrackerTupleDeep(timeTrackerTuple);
        timeUnitHashMap.put(className, timeTrackerTupleSecond);
        return calcRunTime(timeTrackerTuple.getStartTime(), startTimer());
    }

    public void addTimer(final String className) {
        if (timeUnitHashMap.containsKey(className)) {
            final TimeTrackerTuple timeTrackerTupleOrginal = timeUnitHashMap.get(className);
            final TimeTrackerTuple timeTrackerTuple = copyTimeTrackerTupleDeep(timeTrackerTupleOrginal);
            timeUnitHashMap.put(className, timeTrackerTuple);
        }
        timeUnitHashMap.put(className, TimeTrackerTuple
                .builder()
                .startTime(startTimer())
                .key(className)
                .build());
    }

    private TimeTrackerTuple copyTimeTrackerTupleDeep(final TimeTrackerTuple timeTrackerTupleOrginal) {
        return TimeTrackerTuple
                .builder()
                .key(timeTrackerTupleOrginal.getKey())
                .startTime(timeTrackerTupleOrginal.getStartTime())
                .endTime(startTimer())
                .build();
    }
}
