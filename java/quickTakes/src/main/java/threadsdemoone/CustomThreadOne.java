package threadsdemoone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomThreadOne implements Runnable{
    RemoteCall remoteCall;
    public void run(){
        remoteCall.makeRemoteCall(Thread.currentThread().getName());
    }



}
