package McControlador;

import com.zeroc.Ice.Current;

public class ControladorMQObserver implements publisherSubscriber.Observer {

    private ControladorMQ controladorMQ;

    public ControladorMQObserver(ControladorMQ controladorMQ) {
        this.controladorMQ = controladorMQ;
    }

    @Override
	public void update(Current current) {
		controladorMQ.cargarRecetaMaquinas();
	}
}
