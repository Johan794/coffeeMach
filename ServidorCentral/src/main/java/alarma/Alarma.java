package alarma;

import java.util.Date;

import com.zeroc.Ice.Current;

import servicios.AlarmaService;
import servicios.Moneda;
import servicios.ServicioAbastecimientoPrx;

public class Alarma implements AlarmaService {

    public static final int ALARMA_INGREDIENTE = 1;
    public static final int ALARMA_MONEDA_CIEN = 2;
    public static final int ALARMA_MONEDA_DOS = 3;
    public static final int ALARMA_MONEDA_QUI = 4;
    public static final int ALARMA_SUMINISTRO = 5;
    public static final int ALARMA_MAL_FUNCIONAMIENTO = 6;

    private AlarmasManager manager;

    public Alarma(AlarmasManager manager) {
        this.manager = manager;
    }

    @Override
    public void recibirNotificacionEscasezIngredientes(ServicioAbastecimientoPrx servicioAbastecimientoPrx,String iDing, int idMaq,String idAlarm, Current current) {
        manager.alarmaMaquina(ALARMA_INGREDIENTE, idMaq, new Date());
        servicioAbastecimientoPrx.notifyAlarmRecived("Alarma recibida", idMaq, idAlarm);
    }

    @Override
    public void recibirNotificacionInsuficienciaMoneda(ServicioAbastecimientoPrx servicioAbastecimientoPrx,Moneda moneda, int idMaq,String idAlarm, Current current) {
        switch (moneda) {
            case CIEN:
                manager.alarmaMaquina(ALARMA_MONEDA_CIEN, idMaq, new Date());
                servicioAbastecimientoPrx.notifyAlarmRecived("Alarma recibida", idMaq, idAlarm);
                break;
            case DOCIENTOS:
                manager.alarmaMaquina(ALARMA_MONEDA_DOS, idMaq, new Date());
                servicioAbastecimientoPrx.notifyAlarmRecived("Alarma recibida", idMaq, idAlarm);
                break;
            case QUINIENTOS:
                manager.alarmaMaquina(ALARMA_MONEDA_QUI, idMaq, new Date());
                servicioAbastecimientoPrx.notifyAlarmRecived("Alarma recibida", idMaq, idAlarm);
                break;
            default:
                break;
        }
    }

    @Override
    public void recibirNotificacionEscasezSuministro(ServicioAbastecimientoPrx servicioAbastecimientoPrx,String idSumin, int idMaq,String idAlarm, Current current) {
        // suministro
        manager.alarmaMaquina(ALARMA_SUMINISTRO, idMaq, new Date());
        servicioAbastecimientoPrx.notifyAlarmRecived("Alarma recibida", idMaq, idAlarm);
    }

    @Override
    public void recibirNotificacionAbastesimiento(ServicioAbastecimientoPrx servicioAbastecimientoPrx,int idMaq, String idInsumo, int cantidad,String idAlarm, Current current) {
        // TODO validar el insumo
        servicioAbastecimientoPrx.notifyAlarmRecived("Alarma recibida", idMaq, idAlarm);
        current.adapter.getCommunicator().getDefaultLocator();
        manager.desactivarAlarma(ALARMA_INGREDIENTE, idMaq, new Date());
    }

    @Override
    public void recibirNotificacionMalFuncionamiento(ServicioAbastecimientoPrx servicioAbastecimientoPrx,int idMaq, String descri,String idAlarm, Current current) {
        servicioAbastecimientoPrx.notifyAlarmRecived("Alarma recibida", idMaq, idAlarm);
        manager.alarmaMaquina(ALARMA_MAL_FUNCIONAMIENTO, idMaq, new Date());
    }

}
