 
// https://www.geeksforgeeks.org/comparing-streams-to-loops-in-java/
import java.util.stream.Stream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
 
public class TempTest {
   public static void main(String[] args) {
       System.out.println("Hello");
       Stream<String> stream = Stream.of("11", "22", "33");
       // stream.forEach((s) -> System.out.println(s));
       stream.forEach(System.out::println);
       // orElseTesting();
       testingLoopVStream();
 
   }
 
   public static void orElseTesting() {
       Utils.Logger.start(TempTest.class.getName());
 
       long startTimeOfOrElse = System.nanoTime();
       String objOfOrElse = (String) Optional.of("").orElse(Utils.runLongTimeWaitOperator());
       long endTimeOfOrElse = System.nanoTime();
       Utils.Logger.log(String.format("RunTime of OrElse %s", (endTimeOfOrElse - startTimeOfOrElse)));
 
       long startTimeOfOrElseGet = System.nanoTime();
       String objOfOrElseGet = (String) Optional.of("").orElseGet((() -> Utils.runLongTimeWaitOperator()));
       long endTimeOfOrElseGet = System.nanoTime();
       Utils.Logger.log(String.format("RunTime of OrElseGet %s", (endTimeOfOrElseGet - startTimeOfOrElseGet)));
 
       Utils.Logger.start(TempTest.class.getName());
   }
 
   public static void testingLoopVStream() {
       final String forLoopKey = "forLoop";
       final String streamKey = "stream";
       Integer[] arr = {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9};
       Utils.Logger.start(TempTest.class.getName());
       Utils.RunTimeMetric runTimeMetric = new Utils.RunTimeMetric();
       runTimeMetric.setStartTime(forLoopKey);
       for (int i = 0; i < arr.length; i++) {
           Utils.runLongTimeWaitOperator();
       }
       runTimeMetric.setEndTime(forLoopKey);
      
       runTimeMetric.setStartTime(streamKey);
       List<Integer> list = Arrays.asList(arr);
       list.stream().forEach((val)->{           
           Utils.runLongTimeWaitOperator();           
       });       
       runTimeMetric.setEndTime(streamKey);
       Utils.Logger.logRunTimeMetrics(forLoopKey, runTimeMetric.getRunTime(forLoopKey).toString());
       Utils.Logger.logRunTimeMetrics(streamKey, runTimeMetric.getRunTime(streamKey).toString());
       Utils.Logger.logRunTimeMetrics("diff is ", String.valueOf(runTimeMetric.getRunTime(streamKey) - runTimeMetric.getRunTime(forLoopKey)));
       Utils.Logger.log(TempTest.class.getName());
   }
 
   public static class Utils {
       public static class RunTimeMetric {
           private HashMap<String, PairTime> times;
           public static class PairTime {
               public Long startTime;
               public Long endTime;
 
               public PairTime(Long startTime, Long endTime) {
                   this.startTime = startTime;
                   this.endTime = endTime;
               }
 
               public PairTime setEndTime(Long endTime) {
                   this.endTime = endTime;
                   return this;
               }
           }
           public RunTimeMetric(){
               this.times = new HashMap<>();
           }
 
 
           public void addStartTime(String key, Long startTime) {
               times.put(key, new PairTime(startTime, null));
           }
 
           public void setStartTime(String key) {
               // PairTime pairTime = new PairTime(System.nanoTime(), null);
               times.put(key, new PairTime(System.nanoTime(), null));
               // times.put(key, pairTime);
           }
 
           public void setEndTime(String key, Long endTime) {
               times.put(key, times.get(key).setEndTime(endTime));
           }
 
           public void setEndTime(String key) {
               times.put(key, times.get(key).setEndTime(System.nanoTime()));
           }
 
           public Long getRunTime(String key) {
               return times.get(key).endTime - times.get(key).startTime;
           }
       }
 
       public static class Logger {
 
           public static void log(String value) {
               System.out.println(String.format("Time: %s || value: %s", date(), value));
           }
 
           public static void logRunTimeMetrics(String caller, String timeValue) {
               Utils.Logger.log(String.format("RunTime of %s %s", caller, timeValue));
           }
 
           public static void start(String className) {
               System.out.println(String.format("Time: %s || START of execution: %s", date(), className));
           }
 
           public static void end(String className) {
               System.out.println(String.format("Time: %s || END of execution: %s", date(), className));
           }
       }
 
       public static String date() {
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
           LocalDateTime now = LocalDateTime.now();
           return dtf.format(now);
       }
 
       public static String runLongTimeWaitOperator() {
           try {
               TimeUnit.MILLISECONDS.sleep(55);
               return "null string from runLongTime";
           } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               return "";
           }
       }
   }
}
 


