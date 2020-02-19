package practicaFinal;

import java.util.Arrays;

public class AgenteEspionaje extends Agentes {
	private String[] pisos;

	public AgenteEspionaje(String nombre, int edad, String direccion, double salario) {
		super(nombre, edad, direccion, salario);
		this.pisos = IoDatos.leerPisos();
	}

	@Override
	public String toString() {
		String libreriaPisos = "";

		for (String p : pisos) {
			if (p != null) {
				libreriaPisos += p + ",";
			}
		}

		return "Agente Espionaje: \n" + super.toString() +"\n pisos: "+libreriaPisos;
	}

}
