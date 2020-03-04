package practicaFinal;

import java.util.Scanner;
/*creacion de la clase superintentendente y sus atributos*/
public class SuperIntendente extends Agentes {
	private int años;

	public SuperIntendente(String nombre, int edad, String direccion, double salario, int años) {
		super(nombre, edad, direccion, salario);
		this.años = años;
	}

	@Override
	public String toString() {
		return "****************************\n" + "Superintendente: \n" + super.toString() + "\naños de servicio: "
				+ años + "\n****************************";
	}

}
