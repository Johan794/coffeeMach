package alarma;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zeroc.Ice.Communicator;

import modelo.AlarmaMaquina;
import modelo.ConexionBD;
import modelo.ManejadorDatos;

public class AlarmasManager {

    private Communicator comunicator;

    private Map<String,List<String>> alarmasMap;

    public AlarmasManager(Communicator communicator) {
        this.comunicator = communicator;
        this.alarmasMap = new java.util.HashMap<>();
    }

    public String alarmaMaquina(int idAlarma, int idMaquina, Date fechainicial) {
        ConexionBD cbd = new ConexionBD(comunicator);
        cbd.conectarBaseDatos();
        ManejadorDatos md = new ManejadorDatos();
        md.setConexion(cbd.getConnection());

        String alarma = md.darNombreAlarma(idAlarma);
        String operador = md.darOperador(idMaquina);

        if (alarma != null && operador != null) {
            AlarmaMaquina aM = new AlarmaMaquina(idAlarma, idMaquina,
                    fechainicial);
            md.registrarAlarma(aM);
            cbd.cerrarConexion();
            return "Fallo de máquina: " + alarma + " - Atención por:"
                    + operador;
        }
        cbd.cerrarConexion();
        return null;
    }
    public String reliableAlarm(int idAlarma, int idMaquina, Date fechainicial){
        alarmasMap.put(String.valueOf(idMaquina),List.of(String.valueOf(idAlarma),fechainicial.toString()));
        return "Fallo de máquina: " + idAlarma + " - Atención por:" + idMaquina;
    }

    public void desactivarAlarma(int idAlarma, int idMaquina, Date fechaFinal) {
        ConexionBD cbd = new ConexionBD(comunicator);
        cbd.conectarBaseDatos();
        ManejadorDatos md = new ManejadorDatos();
        md.setConexion(cbd.getConnection());
        md.desactivarAlarma(idMaquina, idAlarma, fechaFinal);
        cbd.cerrarConexion();
    }

}
