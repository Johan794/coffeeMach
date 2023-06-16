import com.zeroc.Ice.*;
import Controller.*;

import java.lang.Exception;
import java.net.Inet4Address;
import java.util.*;

import publisher.*;
import publisherSubscriber.*;
import servicios.*;
public class ProxyCacheServer {

    public static void main(String[] args) {
    List<String> extPar = new ArrayList<>();
    try (Communicator communicator = Util.initialize(args, "proxyCache.cfg", extPar)) {

        ObjectAdapter adapter = communicator.createObjectAdapter("ProxyCache");

      RecetaServicePrx recetaServicePrx = RecetaServicePrx.checkedCast(
          communicator.propertyToProxy("recetas")).ice_twoway();



        PublisherImp publisherImp = new PublisherImp(); //clase publisher que se expone 

        ObjectPrx proxyPublisher = adapter.add(publisherImp,Util.stringToIdentity("ProxyCachePublisher"));

        PublisherPrx proxyCachePublisher = PublisherPrx.checkedCast(proxyPublisher);

        PublisherPrx server = PublisherPrx.checkedCast(
            communicator.propertyToProxy("recetasPublisher")).ice_twoway(); //Obtiene el proxy del server

        ProxyCacheReceta proxyCache = new ProxyCacheReceta();  //Clase de proxycache
        ProxyObserver proxyObserver = new ProxyObserver(proxyCachePublisher); //Se crea la clase que observa

        ObjectPrx proxy = adapter.add(proxyObserver,Util.stringToIdentity("ProxyObserver")); //Se obtiene el proxy del observador

        proxyCache.setRecetaServicePrx(recetaServicePrx);

        adapter.add(proxyCache,Util.stringToIdentity("ProxyCacheRecetas"));
        adapter.activate();

        try{
            String hostname = Inet4Address.getLocalHost().getHostName(); //Se obtiene el hostname
            ObserverPrx client = ObserverPrx.uncheckedCast(proxy); //Se castea el proxy a ObserverPrx

            server.addSubscriber(client, hostname); //Se agrega el cliente al server

        }catch (Exception e){
            e.printStackTrace();
        }
        communicator.waitForShutdown();
        
    } 

}
}
