package publisher;

import com.zeroc.Ice.Current;
import publisherSubscriber.ObserverPrx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PublisherImp implements publisherSubscriber.Publisher {
    private List<Subscriber> observers;

    public PublisherImp(){
        observers = new ArrayList<>();
    }

    @Override
    public void addSubscriber(ObserverPrx observer, String hostname, Current current) {
        if(!isSubscribed(hostname)){
            observers.add(new Subscriber(observer, hostname));
        }
    }

    private boolean isSubscribed(String hostname){
        List<Subscriber> subscribers = observers.stream()
                .filter(subscriber -> subscriber.getHostname().equals(hostname))
                .collect(Collectors.toList());
        return subscribers.size() != 0;
    }

    @Override
    public void removeSubscriber(ObserverPrx observer, String hostname, Current current) {
        if(isSubscribed(hostname)){
            observers.removeIf(subscriber -> subscriber.getHostname().equals(hostname));
        }
    }

    @Override
    public void notifySubscribers(Current current) {
        for(Subscriber observer : observers){
            new Thread(() -> {
                try {
                    observer.getClientPrx().update();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
