package ServerControl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.zeroc.Ice.Communicator;

import com.zeroc.Ice.Current;
import modelo.*;
import publisherSubscriber.ObserverPrx;

public class ServerControl implements publisherSubscriber.Publisher {

	private List<Subscriber> observers;
	ArrayList<String> listaAsociada = new ArrayList<String>();
	private Communicator comunicator;

	public ServerControl(Communicator com) {
		this.comunicator = com;
		observers = new ArrayList<>();
		// ConsolaAdministracion cAdmin=new ConsolaAdministracion(this);
		// Thread th=new Thread(cAdmin);
		// th.start();

	}

	public boolean asignarOperador(int idMaquina, int idOperador) {
		if (idMaquina == 0 || idOperador == 0) {
			return false;
		} else {
			ConexionBD cbd = new ConexionBD(comunicator);
			cbd.conectarBaseDatos();
			ManejadorDatos md = new ManejadorDatos();
			md.setConexion(cbd.getConnection());
			md.asignarOperador(idOperador, idMaquina);
			cbd.cerrarConexion();
			return true;
		}
	}

	public List<String> listaAsignaciones(int codigooperador) {
		List<String> lista = new ArrayList<String>();

		ConexionBD cbd = new ConexionBD(comunicator);
		cbd.conectarBaseDatos();
		ManejadorDatos md = new ManejadorDatos();
		md.setConexion(cbd.getConnection());

		List<AsignacionMaquina> asmL = md.listaAsignaciones(codigooperador);

		for (AsignacionMaquina asm : asmL) {
			int idMaq = asm.getMaquina().peticioncodigo();
			String ubicacion = asm.getMaquina().getUbicacion();

			String dato = "" + idMaq + "-" + ubicacion;
			lista.add(dato);
		}
		cbd.cerrarConexion();
		return lista;
	}

	public List<String> listaAsignacionesMDanada(int codigoOperador) {
		ConexionBD cbd = new ConexionBD(comunicator);
		cbd.conectarBaseDatos();
		ManejadorDatos md = new ManejadorDatos();
		md.setConexion(cbd.getConnection());

		List<String> listaAsign = md
				.listaAsignacionMaquinasDanadas(codigoOperador);
		cbd.cerrarConexion();
		return listaAsign;
	}

	public String darCorreoOperador(int codigoOperador) {
		ConexionBD cbd = new ConexionBD(comunicator);
		cbd.conectarBaseDatos();
		ManejadorDatos md = new ManejadorDatos();
		md.setConexion(cbd.getConnection());
		String correo = md.darCorreoOperador(codigoOperador);
		cbd.cerrarConexion();
		return correo;
	}

	public boolean existeOperador(int codigoOperador, String contrasena) {

		if (codigoOperador != 0 && contrasena != null) {
			ConexionBD cbd = new ConexionBD(comunicator);
			cbd.conectarBaseDatos();
			ManejadorDatos md = new ManejadorDatos();
			md.setConexion(cbd.getConnection());
			boolean resultado = md.existeOperador(codigoOperador, contrasena);
			cbd.cerrarConexion();
			return resultado;
		}
		return false;

	}

	@Override
	public void addSubscriber(ObserverPrx observer, String hostname, Current current) {
		if(!isSubscribed(hostname)){
			observers.add(new Subscriber(observer, hostname));
		}
	}

	private boolean isSubscribed(String hostname){
		List<Subscriber> subscribers = observers.stream()
				.filter(subscriber -> subscriber.getHostname().equals(hostname))
				.collect(Collectors.toList());
		return subscribers.size() != 0;
	}

	@Override
	public void removeSubscriber(ObserverPrx observer, String hostname, Current current) {
		if(isSubscribed(hostname)){
			observers.removeIf(subscriber -> subscriber.getHostname().equals(hostname));
		}
	}

	@Override
	public void notifySubscribers(Current current) {
		for(Subscriber observer : observers){
			observer.getClientPrx().update();
		}
	}
}
