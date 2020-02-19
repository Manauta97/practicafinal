package practicaFinal;

import java.util.Scanner;

public class SuperIntendente extends Agentes {
	private int a�os;

	public SuperIntendente(String nombre, int edad, String direccion, double salario, int a�os) {
		super(nombre, edad, direccion, salario);
		this.a�os = a�os;
	}

	@Override
	public String toString() {
		return "****************************\n" + "Superintendente: \n" + super.toString() + "\na�os de servicio: "
				+ a�os + "\n****************************";
	}

}
