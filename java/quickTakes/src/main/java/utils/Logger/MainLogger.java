package utils.Logger;

public interface MainLogger {

    public void log(String value);

    public void logRunTimeMetrics(String caller, String timeValue);

    public void start(String className);

    public void end(String className);
}
