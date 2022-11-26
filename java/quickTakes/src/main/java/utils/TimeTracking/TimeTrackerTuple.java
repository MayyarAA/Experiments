package utils.TimeTracking;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TimeTrackerTuple {
    final long startTime;
    final long endTime;
    final String key;
}
