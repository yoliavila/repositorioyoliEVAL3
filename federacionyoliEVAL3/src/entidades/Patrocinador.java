package entidades;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Patrocinador implements Comparable<Patrocinador> {
	private long id;
	private String nombre;
	private String web;
	private double dotacion;

	private Responsable Resp;





public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}



public double getDotacion() {
	return dotacion;
}


public void setDotacion(double dotacion) {
	this.dotacion = dotacion;
}

public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}

public Patrocinador() {
}


public Patrocinador(String nombre , String URL , double dotacion , long id) {
	this.nombre = nombre;
	this.web = web;
	this.dotacion = dotacion;
	this.id = id;

	
}

public Patrocinador(Patrocinador entPatrocinador){
    
    this.nombre=entPatrocinador.nombre;
    this.web=entPatrocinador.web;
    this.dotacion=entPatrocinador.dotacion;
    this.id=entPatrocinador.id;

}

    


	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}

	
	
	public static Patrocinador nuevoPatrocinador() {
		Patrocinador ret = null;
		long id = -1;
		String nombre = "";
		String web = "";
		double dotacion = 0.0;



		Scanner in;
		boolean valido = false;
		do {
		System.out.println("Introduzca el id del nuevo Patrocinador:");
		in = new Scanner(System.in);
		id = in.nextInt();
		if (id > 0)
		valido = true;
		else
		System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);



		valido = false;
		do {
		in = new Scanner(System.in);
		System.out.println("Introduzca el telefono de empresa del nuevo Patrocinador");
		nombre = in.nextLine();
		valido = Validaciones.validarNombre(nombre);
		if (!valido)
		System.out.println("ERROR: El valor introducido para el nombre no es válido.");
		} while (!valido);



		valido = false;
		do {
		in = new Scanner(System.in);
		System.out.println("Introduzca la dirección del nuevo Patrocinador:");
		web = in.next();
		valido = Validaciones.validarweb(web);
		if (!valido)
		System.out.println("ERROR: El valor introducido para la dirección no es válido.");
		} while (!valido);
		valido = false;
		do {
		System.out.println("Introduzca un valor decimal (xx.xx)");
		in = new Scanner(System.in, "ISO-8859-1");
		try {
		dotacion = in.nextDouble();
		valido = true;
		} catch (InputMismatchException ime) {
		System.out.println("Formato introducido incorrecto.");
		valido = false;
		}
		} while (!valido);



		ret = new Patrocinador();
		return ret;
		}

	public String data() {
		String ret = "";
		ret += "" + this.getId() + "|" + this.Resp.getId() + "|" + this.getNombre() +
		"|" + this.getWeb() + "|" + this.getDotacion();
		return ret;
		}
	
	public int compareTo(Patrocinador p) {
		int compararDotacion = (int) (this.getDotacion() - (p.getDotacion()));
		int franja1 = this.getResponsable().getHorarioIni().compareTo(this.getResponsable().getHorarioFin());
		int franja2 = p.getResponsable().getHorarioIni().compareTo(p.getResponsable().getHorarioFin());
		int compararFranjas = franja1 - franja2;
		int compararId = (int) (this.idPatrocinador() - p.idPatrocinador());
		if (compararDotacion == 0) {



		return compararFranjas;
		} else {
		if (compararFranjas == 0) {
		return compararId;
		}
		return compararDotacion;
		}



		}


	private int idPatrocinador() {
		// TODO Auto-generated method stub
		return 0;
	}


	private Responsable getResponsable() {
		// TODO Auto-generated method stub
		return null;
	}

	}



