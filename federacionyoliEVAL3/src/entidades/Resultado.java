package entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Resultado {
	private long id;
	private Oro oro; // idOro
	private Plata plata; // idPlata
	private Bronce bronce; // idBronce

	// datos para el cierre del resultado
	private boolean definitivo = false;
	private LocalDateTime fechahora;
	private Participante[] podio = new Participante[3];
	// podio[0] -> primer puesto
	// podio[1] -> segundo puesto
	// podio[2] -> tercer puesto

	public Resultado(long id, Oro oro, Plata plata, Bronce bronce) {
		super();
		this.id = id;
		this.oro = oro;
		this.plata = plata;
		this.bronce = bronce;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Oro getPrimero() {
		return oro;
	}

	public void setPrimero(Oro primero) {
		this.oro = primero;
	}

	public Plata getSegundo() {
		return plata;
	}

	public void setSegundo(Plata segundo) {
		this.plata = segundo;
	}

	public Bronce getTercero() {
		return bronce;
	}

	public void setTercero(Bronce tercero) {
		this.bronce = tercero;
	}

	public boolean isDefinitivo() {
		return definitivo;
	}

	private void setDefinitivo(boolean definitivo) {
		this.definitivo = definitivo;
	}

	public LocalDateTime getFechahora() {
		return fechahora;
	}

	private void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public Participante[] getPodio() {
		return podio;
	}

	public void setPodio(Participante[] podio) {
		this.podio = podio;
	}

	/**
	 * Funcion que establece el resultado como definitivo y la fecha/hora a la
	 * actual junto con el podio obtenido
	 */
	public void cerrarResultado(Participante[] podioobtenido, Oro o, Plata p, Bronce b) {
		this.podio = podioobtenido;
		this.oro = o;
		this.plata = p;
		this.bronce = b;
		this.setDefinitivo(true);
		this.setFechahora(LocalDateTime.now());
	}

	public void cerrarResultado(Participante[] podioobtenido) {
		this.podio = podioobtenido;
		this.setDefinitivo(true);
		this.setFechahora(LocalDateTime.now());
	}

	public void cerrarResultado(Participante primero, Participante segundo, Participante tercero) {
		Participante[] podioobtenido = { primero, segundo, tercero };
		this.podio = podioobtenido;
		this.setDefinitivo(true);
		this.setFechahora(LocalDateTime.now());
	}

	public void cerrarResultado(Participante primero, Participante segundo, Participante tercero,
			LocalDateTime fechahora) {
		Participante[] podioobtenido = { primero, segundo, tercero };
		this.podio = podioobtenido;
		this.setDefinitivo(true);
		this.setFechahora(fechahora);
	}
	private static void exportar(Resultado[] informe) {
		String path = "informe.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				for (Resultado m : informe) {
					buffer.println(m.data());
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "Resultado de la prueba [id=" + id + ", oro=" + oro + ", plata=" + plata + ", bronce=" + bronce + ", definitivo="
				+ definitivo + ", fechahora=" + fechahora + ", podio=" + Arrays.toString(podio) + "]";
	}
//	Resultado de la prueba <idPrueba> “<nombrePrueba>” celebrada el pasado
//	<fecha(dd/MM/aaaa)> en <lugar>.
//	Primer puesto para <nombreAtleta_1> (<NIFNIEAtleta_1>), con un tiempo de
//	<tiempo1(hh:mm:ss,cc)>. Se le otorga el oro <idOro> de pureza <purezaOro>%.
//	Segundo puesto para <nombreAtleta_2> (<NIFNIEAtleta_2>), con un tiempo de
//	<tiempo2(hh:mm:ss,cc)>. Se le otorga la plata <idPlata> de pureza
//	<purezaPlata>%.
//	Tercer puesto para <nombreAtleta_3> (<NIFNIEAtleta_3>), con un tiempo de
//	<tiempo3(hh:mm:ss,cc)>. Se le otorga el bronce <idBronce> de pureza
//	<purezaBronce>%.
//	Resultado <idResultado> cerrado a las <hh:mm:ss> del día <dd/MM/yyyy>.
}
