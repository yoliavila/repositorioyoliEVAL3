package entidades;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;


public class Responsable {
	
	private String telefono;
	private LocalTime HorarioIni;
	private LocalTime HorarioFin;
	private long id;
	
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public Responsable() {
	}
	
	
	public Responsable(String telefono , LocalTime HorarioIni , LocalTime HorarioFin , long id) {
		this.telefono = telefono;
		this.HorarioIni = HorarioIni;
		this.HorarioFin = HorarioFin;
		this.id=id;
		
	}
	
	public Responsable(Responsable entResponsable){
        
        this.telefono=entResponsable.telefono;
        this.HorarioIni=entResponsable.HorarioIni;
        this.HorarioFin=entResponsable.HorarioFin;
        this.id=entResponsable.id;

    }
	public LocalTime getHorarioIni() {
		return HorarioIni;
	}
	public void setHorarioIni(LocalTime horarioIni) {
		HorarioIni = horarioIni;
	}
	public LocalTime getHorarioFin() {
		return HorarioFin;
	}
	public void setHorarioFin(LocalTime horarioFin) {
		HorarioFin = horarioFin;
	}
	
	public static Responsable nuevoResponsable() {
		Responsable ret = null;
		long id = -1;
		String telefono = "";
		Scanner in;
		boolean valido = false;
		do {
		System.out.println("Introduzca el id del nuevo Responsable:");
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
		System.out.println("Introduzca el telefono");
		telefono = in.nextLine();
		valido = Validaciones.validarTelefono(telefono);
		if (!valido)
		System.out.println("ERROR: El valor introducido para el telefono no es válido.");
		} while (!valido);
		valido = false;
		System.out.println("Introduzca el tiempo del horario inicial");
		LocalTime time = Utilidades.leerHora();
		System.out.println("Introduzca el tiempo del horario final");
		LocalTime time2 = Utilidades.leerHora();

		ret = new Responsable();

		return ret;



		}
	
	
	
	public String data(Responsable persona) {
	return "" + this.getId() + persona.getId() + "|" + this.getTelefono()+ "|"
	+ this.getHorarioIni() + "|" + this.getHorarioFin();
	}
	@Override
	public String toString() {
		return "Responsable [telefono=" + telefono + ", HorarioIni=" + HorarioIni + ", HorarioFin=" + HorarioFin
				+ ", id=" + id + "]";
	}

	

	
}
