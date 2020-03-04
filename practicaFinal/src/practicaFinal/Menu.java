package practicaFinal;

import java.util.Scanner;

public class Menu {

	/*
	 * pinta el menu principal y lee la opcion
	 */
	public static int pintaMenu() {
		Scanner leer = new Scanner(System.in);
		boolean bandera = true;
		int opc = 0;

		do {

			try {
				do {
					leer = new Scanner(System.in);

					System.out.println("****************************************");
					System.out.println("* 1. Ver todos los agentes             *");
					System.out.println("* 2. Ver agentes con mas de X sueldo   *");
					System.out.println("* 3. Dar de alta un nuevo piso         *");
					System.out.println("* 4. Dar de alta una nueva arma        *");
					System.out.println("* 5. Dar de alta un nuevo agente       *");
					System.out.println("* 6. Encriptar la información          *");
					System.out.println("* 7. Desencriptar la información       *");
					System.out.println("* 8. Salir                             *");
					System.out.println("**************************************");
					opc = leer.nextInt();
					bandera = true;

				} while (opc < 1 || opc > 8);

			} catch (NullPointerException e) {
				System.out.println("datos mal introducidos");
				bandera = false;
			} catch (Exception e) {
				System.out.println("datos mal introducidos");
				bandera = false;
			}
		} while (!bandera);

		return opc;
	}

	/*
	 * pinta el menu de creacion de agente y lee la opcion selecionada
	 */
	public static int MenuDarAltaAgente() {
		Scanner leer = new Scanner(System.in);
		boolean bandera = true;
		int opc = 0;

		do {

			try {
				do {
					leer = new Scanner(System.in);

					System.out.println("*********************************");
					System.out.println("* 1. Crear Superintendente      *");
					System.out.println("* 2. Crear Agente007            *");
					System.out.println("* 3. Crear Agente Espionage     *");
					System.out.println("* 4. Volver al Menu principal   *");
					System.out.println("*********************************");
					opc = leer.nextInt();
					bandera = true;

				} while (opc < 1 || opc > 4);

			} catch (NullPointerException e) {
				System.out.println("datos mal introducidos");
				bandera = false;
			} catch (Exception e) {
				System.out.println("datos mal introducidos");
				bandera = false;
			}
		} while (!bandera);

		return opc;

	}

}
