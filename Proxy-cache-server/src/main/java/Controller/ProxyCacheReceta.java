package Controller;

import servicios.*;
import java.util.List;
import com.zeroc.Ice.Current;
public class ProxyCacheReceta implements RecetaService{
    private RecetaServicePrx recetaServicePrx; 
    private List<String[]> cache; 

    public ProxyCacheReceta(){
        this.cache = null;
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
        if(cache.length == null){
            this.cache =  recetaServicePrx.consultarProductos(); 
            System.out.println("Se usa el proxy cache")   
        }
        return cache;    
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
       return;
    }

    @Override
    public String registrarIngrediente(String nombre, Current current) {
        
        
    }

    public void setRecetaServicePrx(RecetaServicePrx recetaServicePrx) {
		this.recetaServicePrx = recetaServicePrx;
	}




    
}
