import com.zeroc.Ice.*;

import McControlador.ControladorMQ;

import java.lang.Exception;
import java.net.Inet4Address;
import java.util.*;

import publisherSubscriber.ObserverPrx;
import publisherSubscriber.PublisherPrx;
import servicios.*;

public class CoffeeMach {
  public static void main(String[] args) {
    List<String> extPar = new ArrayList<>();
    try (Communicator communicator = Util.initialize(args, "coffeMach.cfg", extPar)) {

      AlarmaServicePrx alarmaS = AlarmaServicePrx.checkedCast(
          communicator.propertyToProxy("alarmas")).ice_twoway();
      VentaServicePrx ventas = VentaServicePrx.checkedCast(
          communicator.propertyToProxy("ventas")).ice_twoway();
      RecetaServicePrx recetaServicePrx = RecetaServicePrx.checkedCast(
          communicator.propertyToProxy("proxyCacheRecetas")).ice_twoway();

      PublisherPrx proxyCachePublisher = PublisherPrx.checkedCast(
          communicator.propertyToProxy("proxyCacheRecetas")).ice_twoway();

      ObjectAdapter adapter = communicator.createObjectAdapter("CoffeMach");
      ControladorMQ service = new ControladorMQ(proxyCachePublisher);

      ObjectPrx proxy = adapter.add(service, Util.stringToIdentity("controladorMQ"));
      service.setAlarmaService(alarmaS);
      service.setVentas(ventas);
      service.setRecetaServicePrx(recetaServicePrx);

      service.run();
      adapter.add((ServicioAbastecimiento) service, Util.stringToIdentity("abastecer"));
      adapter.activate();
      try{
        String hostname = Inet4Address.getLocalHost().getHostName();
        ObserverPrx client = ObserverPrx.uncheckedCast(proxy);

        proxyCachePublisher.addSubscriber(client, hostname);

      }catch (Exception e){
        e.printStackTrace();
      }

      communicator.waitForShutdown();
    }
  }
}
