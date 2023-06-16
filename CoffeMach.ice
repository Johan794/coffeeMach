
module servicios{

    sequence<string> StringArr;
    ["java:type:java.util.ArrayList<String>"] 
    sequence<string> StringSeq;
    ["java:serializable:java.util.Date"]
    sequence<byte> Date;

    dictionary<string,int> MapStrInt;


    interface ServicioComLogistica{

      StringSeq asignacionMaquina(int codigoOperador);
	    StringSeq asignacionMaquinasDesabastecidas(int codigoOperador);
	    bool inicioSesion(int codigoOperador, string password);
    }

    interface ServicioAbastecimiento {
	   void abastecer(int codMaquina, int tipoAlarma);
     void notifyAlarmRecived(string mensaje, int codMaquina,string idAlarma);
    }

    enum Moneda{
      CIEN, DOCIENTOS, QUINIENTOS
    }

    interface AlarmaService{
      void recibirNotificacionEscasezIngredientes(ServicioAbastecimiento* serverProxy,string iDing, int idMaq,string idAlarma);
      void recibirNotificacionInsuficienciaMoneda(ServicioAbastecimiento* serverProxy,Moneda moneda, int idMaq,string idAlarma);
      void recibirNotificacionEscasezSuministro(ServicioAbastecimiento* serverProxy,string idSumin, int idMaq,string idAlarma);
      void recibirNotificacionAbastesimiento(ServicioAbastecimiento* serverProxy,int idMaq, string idInsumo, int cantidad,string idAlarma);
      void recibirNotificacionMalFuncionamiento(ServicioAbastecimiento* serverProxy,int idMaq, string descri,string idAlarma);

    }

    interface VentaService{
      void registrarVenta(int codMaq, StringArr ventas);
    }

    interface RecetaService{
      StringArr consultarIngredientes();
	    StringArr consultarRecetas();
      StringArr consultarProductos();
      void definirProducto(string nombre, int precio, MapStrInt ingredientes);

	    void borrarReceta(int cod);
	    void definirRecetaIngrediente(int idReceta, int idIngrediente,int valor);
	    string registrarReceta(string nombre, int precio);
	    string registrarIngrediente(string nombre);
    }

}