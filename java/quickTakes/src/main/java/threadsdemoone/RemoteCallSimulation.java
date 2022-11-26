package threadsdemoone;

import utils.Logger.MainLogger;
import utils.Logger.BaseLogger;
import lombok.Builder;

@Builder
public class RemoteCallSimulation implements RemoteCall {
    public void makeRemoteCall(String callerName){
        MainLogger logger = new BaseLogger();
        logger.log(String.format("caller: %s started remote call", callerName));
        try {
            Thread.sleep(250L);
        } catch (final Exception e) {
            logger.log("Error during remote call");
            e.printStackTrace();
        }
        logger.log(String.format("caller: %s finished remote call", callerName));
    }
    public void makeRemoteCall() {
        MainLogger logger = new BaseLogger();
        logger.log("remote call started");
        try {
            Thread.sleep(250L);
        } catch (final Exception e) {
            logger.log("Error during remote call");
            e.printStackTrace();
        }
        logger.log("remote call ended");
    }
}
