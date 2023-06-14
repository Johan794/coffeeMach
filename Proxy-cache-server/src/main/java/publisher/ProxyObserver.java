package publisher;
import publisherSubscriber.*;
import com.zeroc.Ice.Current;
public class ProxyObserver  implements publisherSubscriber.Observer{
    private PublisherPrx publisherImp;
    
    public ProxyObserver(PublisherPrx publisherImp){
        this.publisherImp = publisherImp;

    }

    @Override
    public void update(Current current) {
        publisherImp.notifySubscribers();
    }
}
