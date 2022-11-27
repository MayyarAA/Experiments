package utils.TimeTracking;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeTrackerContainer implements Comparable<TimeTrackerContainer> {
    private final long startTime;
    private final long endTime;
    private long runTime;
    final String key;

    public long getRunTime(){
        if(runTime != 0)
            return  runTime;

        if(endTime <= 0)
            throw new IllegalStateException("endTime should not be negative");

        if(startTime <= 0)
            throw new IllegalStateException("startTime should not be negative");

        runTime = endTime - startTime;

        if(runTime<0)
            throw new IllegalStateException("Runtime should not be negative");

        return runTime;
    }

    //ascending order
    @Override
    public int compareTo(TimeTrackerContainer ttc2) {
        if(this  == null && ttc2 == null)
            return 0;
        if(this == null)
            return -1;
        if(ttc2 == null)
            return 1;
//        System.out.println("heere " + this.getKey());
        return Long.compare(this.getRunTime(), ttc2.getRunTime());
//        return Long.compare(ttc2.getRunTime(), this.getRunTime());
    }
}
