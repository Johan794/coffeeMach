import com.zeroc.Ice.*;
import Controller.*;

import java.util.*;
import servicios.*;
public class ProxyCacheServer {

    public static void main(String[] args) {
    List<String> extPar = new ArrayList<>();
    try (Communicator communicator = Util.initialize(args, "proxyCache.cfg", extPar)) {

        ObjectAdapter adapter = communicator.createObjectAdapter("ProxyCache");

      RecetaServicePrx recetaServicePrx = RecetaServicePrx.checkedCast(
          communicator.propertyToProxy("recetas")).ice_twoway();

        ProxyCacheReceta proxyCache = new ProxyCacheReceta();  
        proxyCache.setRecetaServicePrx(recetaServicePrx);
        adapter.add(proxyCache,Util.stringToIdentity("ProxyCacheRecetas"));
        adapter.activate();
        communicator.waitForShutdown();
        
    } 

}
}
