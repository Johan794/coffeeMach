package publisher;

import publisherSubscriber.ObserverPrx;

public class Subscriber {

    private ObserverPrx clientPrx;
    private String hostname;

    public Subscriber(ObserverPrx clientPrx, String hostname){
        this.clientPrx = clientPrx;
        this.hostname = hostname;
    }

    public void setClientPrx(ObserverPrx clientPrx) {
        this.clientPrx = clientPrx;
    }

    public ObserverPrx getClientPrx() {
        return clientPrx;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
