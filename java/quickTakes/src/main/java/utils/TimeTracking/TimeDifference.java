package utils.TimeTracking;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Builder
@Value
@ToString
public class TimeDifference {
    final long timeDiff;

    final double timeDiffPercentage;
}
