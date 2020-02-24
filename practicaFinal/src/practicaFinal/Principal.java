package practicaFinal;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class Principal {
	/*
	 * @autor: Raúl Manuta
	 * @Version: 1.0;
	 *
	 */
/*
 * este método se encarga de iniciar el programa y mostrar el menu con sus opciones
 */
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int opc = 0;
		Menu menu = new Menu();
		Agentes[] vAgentes = new Agentes[20];
		String nombre = "", direccion = "", piso = "";
		int edad = 0, años = 0, contadorMuertes = 0;
		double salario = 0;
		

		do {

			switch (opc = menu.pintaMenu()) {

			case 1:
				for (int i = 0; i < vAgentes.length; i++) {
					if (vAgentes[i] != null) {
						System.out.println(vAgentes[i]);
					}
				}
				break;
			case 2:
				IoDatos.comprobarSueldo(vAgentes);
				break;
			case 3:
				IoDatos.guardarDatosPisos();
				break;
			case 4:
				IoDatos.guardarNuevaArma();
				break;
			case 5:
				leer = new Scanner(System.in);
				System.out.println("Dime el nombre del agente");
				nombre = leer.nextLine();

				leer = new Scanner(System.in);
				System.out.println("Dime la edad del agente");
				edad = leer.nextInt();

				leer = new Scanner(System.in);
				System.out.println("Dime la direccion del agente");
				direccion = leer.nextLine();

				leer = new Scanner(System.in);
				System.out.println("Dime el salario del agente");
				salario = leer.nextInt();

				do {
					switch (opc = menu.MenuDarAltaAgente()) {

					case 1:

						System.out.println("Años de servicio");
						años = leer.nextInt();
						SuperIntendente sp = new SuperIntendente(nombre, edad, direccion, salario, años);
						for (int i = 0; i < vAgentes.length; i++) {
							if (vAgentes[i] == null) {
								vAgentes[i] = sp;
								break;
							}
						}

						break;

					case 2:

						System.out.println("Bajas confirmadas");
						contadorMuertes = leer.nextInt();
						Agente007 ag7 = new Agente007(nombre, edad, direccion, salario, contadorMuertes);
						for (int i = 0; i < vAgentes.length; i++) {
							if (vAgentes[i] == null) {
								vAgentes[i] = ag7;
								break;
							}
						}

						break;

					case 3:

						AgenteEspionaje age = new AgenteEspionaje(nombre, edad, direccion, salario);
						for (int i = 0; i < vAgentes.length; i++) {
							if (vAgentes[i] == null) {
								vAgentes[i] = age;
								break;
							}
						}
						
						break;

					}
				} while (opc != 4);
				break;
			case 6:
				IoDatos.encriptarArmas();
				IoDatos.encriptarPisos();
				break;
			case 7:
				IoDatos.desencriptarArmas();
				break;
			case 8:
				System.out.println("Has salido del programa");
				break;

			}
		} while (opc != 8);
	}

}
