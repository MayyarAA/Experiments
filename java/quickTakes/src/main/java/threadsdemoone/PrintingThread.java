package threadsdemoone;

import lombok.Builder;
import utils.Logger.LoggerImpl;
import utils.Logger.LoggerBase;

@Builder
public class PrintingThread implements Runnable{
    long runtime;
    @Override
    public void run() {
        LoggerBase mainLogger = new LoggerImpl();
        mainLogger.log(String.format("runtime was: %s", this.runtime));
    }

//    public void printRuntime(long runTime){
//        run
//    }

    public void setRuntime(long runtime){
        this.runtime = runtime;
    }
}
