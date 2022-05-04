package entidades;



import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Datos;
import utils.Utilidades;
import validaciones.Validaciones;



public class Tiempo implements Comparable<Tiempo> {



private int horas;
private int minutos;
private int segundos;
private int centesimas;



Tiempo() {
}

public Tiempo(int horas, int minutos, int segundos, int centesimas) {
super();
this.horas = horas;
this.minutos = minutos;
this.segundos = segundos;
this.centesimas = centesimas;

}

public int getHoras() {
return horas;
}



public void setHoras(int horas) {
this.horas = horas;
}


public int getMinutos() {
return minutos;
}


public void setMinutos(int minutos) {
this.minutos = minutos;
}


public int getSegundos() {
return segundos;
}


public void setSegundos(int segundos) {
this.segundos = segundos;
}


public int getCentesimas() {
return centesimas;
}



public void setCentesimas(int centesimas) {
this.centesimas = centesimas;
}


public String toString() {
return "" + horas + ": " + minutos + ":" + segundos + ":"
+ centesimas;
}

public static Tiempo nuevoTiempo() {
	Tiempo ret = null;
	int horas = 0;
	int minutos=0;
	int segundos = 0;
	int centesimas = 0;
	Scanner in = null;
	boolean valido = false;
		do {
			System.out.println("Introduzca el nuevo numero de horas:");
			horas = in.nextInt();
			valido = Validaciones.validarHora(horas);
			if (!valido) {
				System.out.println(
						"El valor introducido para las horas no es correcto:");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca el nuevo numero de minutos:");
			minutos = in.nextInt();
			valido = Validaciones.validarMinutos(minutos);
			if (!valido) {
				System.out.println(
						"El valor introducido para los minutos no es correcto:");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;	do {
			System.out.println("Introduzca el nuevo numero de segundos:");
			segundos = in.nextInt();
			valido = Validaciones.validarSegundos(segundos);
			if (!valido) {
				System.out.println(
						"El valor introducido para los segundos no es correcto:");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;	do {
			System.out.println("Introduzca el nuevo numero de centesimas:");
			centesimas = in.nextInt();
			valido = Validaciones.validarCentesimas(centesimas);
			if (!valido) {
				System.out.println(
						"El valor introducido para las centesimas no es correcto:");
				continue;
			} else
				valido = true;
		} while (!valido);
		valido = false;
		return ret;
	}

@Override
public int compareTo(Tiempo o) {
	// TODO Auto-generated method stub
	return 0;
}
}