package practicaFinal;

import java.util.Arrays;
import java.util.Iterator;

public class Agente007 extends Agentes {
	private int contadorMuertes;
	private String[] armas;

	public Agente007(String nombre, int edad, String direccion, double salario, int contadorMuertes) {
		super(nombre, edad, direccion, salario);
		this.contadorMuertes = contadorMuertes;
		this.armas = IoDatos.lecturaFicheroArmas();
	}

	@Override
	public String toString() {
		String armaguedon = "";
		// recorrer vector y sacar en cada posicion el arma dentro del fichero
		for (String s : armas) {
			if (s != null) {
				armaguedon += s + ",";
			}
		}

		return "Agente 007: \n" + super.toString() + "\nmuertes: " + contadorMuertes + "\n" + "armas: " + armaguedon;

	}

}
