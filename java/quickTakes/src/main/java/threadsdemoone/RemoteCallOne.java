package threadsdemoone;

import lombok.Builder;

import java.util.concurrent.Callable;

@Builder
public class RemoteCallOne implements Callable<String> {
    RemoteCall remoteCall;
    final String runnableName;
    @Override
    public String call() throws Exception {
        remoteCall.makeRemoteCall(runnableName);
        return null;
    }
}
