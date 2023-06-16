module publisherSubscriber {

    interface Observer {
        void update();
    }


    interface Publisher {
        void addSubscriber(Observer* observer,string hostname);
        void removeSubscriber(Observer* observer,string hostname);
        void notifySubscribers();
    }
}