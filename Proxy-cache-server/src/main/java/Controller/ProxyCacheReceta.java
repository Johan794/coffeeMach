package Controller;

import servicios.*;
import java.util.*;
import com.zeroc.Ice.Current;
public class ProxyCacheReceta implements RecetaService{
    private RecetaServicePrx recetaServicePrx; 
    private Map<String, CacheData<String []>> cache;
    private static final long TIME_TO_LIVE = 900000; // Tiempo de vida de 15 minutos en milisegundos
    private static final String NO_PARAM_QUERY_KEY = "NO_PARAM_QUERY"; //Lave para usar el HashMap y aprovechar sus propiedades

    public ProxyCacheReceta(){
        this.cache = new HashMap<>();
    }

    
    @Override
    public String[] consultarIngredientes(Current current) {
        return recetaServicePrx.consultarIngredientes();    
    }

    @Override
    public String[] consultarRecetas(Current current) {
         return recetaServicePrx.consultarRecetas();    
    }

    @Override
    public String[] consultarProductos(Current current) {
        CacheData<String[]> data = cache.get(NO_PARAM_QUERY_KEY);
        if(data == null || (System.currentTimeMillis() > data.getExpirationTime())){
            System.out.println("MISS ---> getting data from central server");
            cache.remove(NO_PARAM_QUERY_KEY);
            data = new CacheData<String[]>(recetaServicePrx.consultarRecetas(),System.currentTimeMillis() + TIME_TO_LIVE); 
            cache.put(NO_PARAM_QUERY_KEY,data);
        }
        return data.getData();
    }
    

    @Override
    public void definirProducto(String nombre, int precio, Map<String, Integer> ingredientes, Current current) {
        throw new UnsupportedOperationException("Unimplemented method 'definirProducto'");
    }

    @Override
    public void borrarReceta(int cod, Current current) {
        
    }

    @Override
    public void definirRecetaIngrediente(int idReceta, int idIngrediente, int valor, Current current) {

    }

    @Override
    public String registrarReceta(String nombre, int precio, Current current) {
       return "";
    }

    @Override
    public String registrarIngrediente(String nombre, Current current) {
        
        return  "";
        
    }

    public void setRecetaServicePrx(RecetaServicePrx recetaServicePrx) {
		this.recetaServicePrx = recetaServicePrx;
	}




    
}
