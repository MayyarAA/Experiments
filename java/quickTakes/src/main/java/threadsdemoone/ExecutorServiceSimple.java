package threadsdemoone;

import lombok.Builder;
import lombok.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Builder
public class ExecutorServiceSimple {
    @NonNull
    ExecutorService executorService; // Composition over inheritance

    void gracefullyTerminate(){
        if(executorService == null){
            throw new IllegalStateException("executorService should not be null, prior to termination");
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
