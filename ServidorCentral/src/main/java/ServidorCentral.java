
import java.util.ArrayList;
import java.util.List;
import com.zeroc.Ice.*;
import comunicacion.*;
import interfaz.ControladorRecetas;
import publisherSubscriber.PublisherPrx;
import receta.ProductoReceta;
import receta.PublisherImp;
import servicios.*;
import ventas.VentasManager;
import ServerControl.*;
import alarma.Alarma;
import alarma.AlarmasManager;

public class ServidorCentral {

    public static void main(String[] args) {
        List<String> params = new ArrayList<>();
        try (Communicator communicator = Util.initialize(args, "server.cfg", params)) {

            ObjectAdapter adapter = communicator.createObjectAdapter("Server");

            ServerControl control = new ServerControl(communicator);

            ServicioComLogistica log = new ControlComLogistica(control);

            Alarma alarma = new Alarma(new AlarmasManager(communicator));
            PublisherImp publisherImp = new PublisherImp(); //clase publisher que se expone 
            
            ObjectPrx proxy = adapter.add(publisherImp, Util.stringToIdentity("RecetasPublisher"));

            PublisherPrx publisherPrx = PublisherPrx.checkedCast(proxy);

            ProductoReceta recetas = new ProductoReceta();
            recetas.setCommunicator(communicator);
            recetas.setPublisherImp(publisherPrx);

            VentasManager ventas = new VentasManager();
            ventas.setCommunicator(communicator);


            adapter.add(alarma, Util.stringToIdentity("Alarmas"));
            adapter.add(ventas, Util.stringToIdentity("Ventas"));
            adapter.add(log, Util.stringToIdentity("logistica"));
            adapter.add(recetas, Util.stringToIdentity("Recetas"));
            

            ControladorRecetas controladorRecetas = new ControladorRecetas();
            controladorRecetas.setRecetaService(recetas);
            controladorRecetas.run();

            adapter.activate();
            communicator.waitForShutdown();

        }
    }
}
