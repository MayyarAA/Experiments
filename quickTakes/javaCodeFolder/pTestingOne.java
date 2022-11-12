 
//https://www.baeldung.com/java-optional-or-else-vs-or-else-get
import java.util.stream.Stream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
 
public class TempTest {
   public static void main(String[] args) {
       System.out.println("Hello");
       Stream<String> stream = Stream.of("11", "22", "33");
       // stream.forEach((s) -> System.out.println(s));
       stream.forEach(System.out::println);
       orElseTesting();
 
   }
 
   public static void orElseTesting() {
       Utils.logger("start of execution");
 
       long startTimeOfOrElse = System.nanoTime();
       String objOfOrElse = (String) Optional.of("").orElse(Utils.runLongTimeHelper());
       long endTimeOfOrElse = System.nanoTime();
       Utils.logger(String.format("RunTime of OrElse %s", (endTimeOfOrElse - startTimeOfOrElse)));
 
       long startTimeOfOrElseGet = System.nanoTime();       
       String objOfOrElseGet = (String) Optional.of("").orElseGet((() -> Utils.runLongTimeHelper()));
       long endTimeOfOrElseGet = System.nanoTime();
       Utils.logger(String.format("RunTime of OrElseGet %s", (endTimeOfOrElseGet - startTimeOfOrElseGet)));
 
       Utils.logger("end of execution");
   }   
  
   public static class Utils{
       public static void logger(String value) {
           System.out.println(String.format("Time: %s || value: %s", date(), value));
       }
  
       public static String date() {
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
           LocalDateTime now = LocalDateTime.now();
           return dtf.format(now);
       }
  
       public static String runLongTimeHelper() {
           try {
               TimeUnit.SECONDS.sleep(5);
               return "null string from runLongTime";
           } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               return "";
           }
       }
   }
}
 




