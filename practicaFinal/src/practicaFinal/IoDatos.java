package practicaFinal;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * @autor Raúl Manauta Jarque
 * @version 1.0
 */
public class IoDatos {

	public IoDatos() {
	}

	public static void guardarDatosPisos() {
		File fichero = new File("datos/pisos.txt");
		FileWriter fw = null;
		PrintWriter pw = null;
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fw = new FileWriter(fichero, true);
			pw = new PrintWriter(fw);
			Scanner leer = new Scanner(System.in);
			System.out.println("Dime el piso a guardar");
			String piso = leer.nextLine();
			pw.println(piso);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				pw.close();

				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static String[] leerPisos() {

		File fichero = new File("datos/pisos.txt");
		String[] vPisos = new String[20];

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Scanner leer = new Scanner(fichero);

			while (leer.hasNextLine()) {
				// String linea = leer.nextLine();
				for (int i = 0; i < vPisos.length; i++) {
					if (vPisos[i] == null) {
						vPisos[i] = leer.nextLine();
						break;
					}
				}
			}

			for (int j = 0; leer.hasNext(); j++) {
				vPisos[j] = leer.nextLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Lectura del fichero realizada");
		}

		return vPisos;

	}

	public static void guardarNuevaArma() {
		File fichero = new File("datos/armas.txt");
		FileWriter fw = null;
		PrintWriter pw = null;

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fw = new FileWriter(fichero, true);
			pw = new PrintWriter(fw);
			Scanner leer = new Scanner(System.in);
			System.out.println("Arma nueva a guardar");
			String arma = leer.nextLine();
			pw.println(arma);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				pw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static String[] lecturaFicheroArmas() {
		String[] vArmas = new String[20];
		File fichero = new File("datos/armas.txt");

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Scanner leer = new Scanner(fichero);

			while (leer.hasNextLine()) {
				for (int i = 0; i < vArmas.length; i++) {
					if (vArmas[i] == null) {
						vArmas[i] = leer.nextLine();
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return vArmas;
	}
/*
 * introduces un sueldo y te muestra los agentes que tienen mas de ese sueldo 
 */
 
	public static void comprobarSueldo(Agentes[] vAgentes) {

		Scanner leer = new Scanner(System.in);

		double sueldo = 0;

		System.out.println("dime el sueldo a buscar");
		sueldo = leer.nextDouble();

		for (int i = 0; i < vAgentes.length; i++) {
			if (vAgentes[i] != null && vAgentes[i].getSalario() > sueldo) {
				System.out.println(vAgentes[i]);
			}

		}
	}

	public static Agentes[] leerAgentesFicheros() {
		File fichero = new File("datos/agentes.dat");
		FileInputStream fi = null;
		ObjectInputStream leer = null;
		Agentes[] vAgentes = new Agentes[20];
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fi = new FileInputStream(fichero);
			leer = new ObjectInputStream(fi);

			for (int i = 0; i < vAgentes.length; i++) {
				if (vAgentes[i] == null) {
					vAgentes[i] = (Agentes) leer.readObject();

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				fi.close();
				leer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vAgentes;
	}

	public static void escribirAgentesFichero(Agentes[] vAgentes) {

		File fichero = new File("datos/agentes.dat");
		FileOutputStream fout = null;
		ObjectOutputStream escribir = null;

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fout = new FileOutputStream(fichero);
			escribir = new ObjectOutputStream(fout);
			for (int i = 0; i < vAgentes.length; i++) {
				if (vAgentes[i] != null) {
					escribir.writeObject(vAgentes[i]);
					break;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
/*
 * crea ficheros binarios en los que no se puede leer el contenido
 */
	public static void encriptarArmas() {
		File fichero = new File("datos/armas.txt");
		File ficheroEncriptado = new File("datos/armas.dat");
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		String[] vArmas = new String[20];

		if (!ficheroEncriptado.exists()) {
			try {
				ficheroEncriptado.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			// Leer texto scanner
			Scanner leer = new Scanner(fichero);
			while (leer.hasNextLine()) {
				for (int i = 0; i < vArmas.length; i++) {
					if (vArmas[i] == null) {
						vArmas[i] = leer.nextLine();
						break;
					}
				}
			}
			leer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		// Guardar el vector a fichero binario

		try {
			fout = new FileOutputStream(ficheroEncriptado);
			out = new ObjectOutputStream(fout);

			for (int i = 0; i < vArmas.length; i++) {
				if (vArmas[i] != null) {
					out.writeObject(vArmas[i]);

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fichero.exists()) {

			System.out.println("El fichero se ha borrado.");
			fichero.delete();

		}
	}
	/*
	 * borra los fichero encriptados y crea los ficheros en los que se puede leer el contenido
	 */
	public static void desencriptarArmas() {
		File fichero = new File("datos/armas.txt");
		File ficheroencriptado = new File("datos/armas.dat");
		FileInputStream fiou = null;
		ObjectInputStream oi = null;
		String[] vArmas = new String[20];
		FileWriter fw = null;
		PrintWriter pw = null;
		if (!ficheroencriptado.exists()) {
			try {
				ficheroencriptado.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fiou = new FileInputStream(ficheroencriptado);
			oi = new ObjectInputStream(fiou);

			for (int i = 0; i < vArmas.length; i++) {
				if (vArmas[i] == null) {
					vArmas[i] = (String) oi.readObject();
					break;
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Scanner leer = new Scanner(fichero);
			fw = new FileWriter(fichero);
			pw = new PrintWriter(fw);
			for (int i = 0; i < vArmas.length; i++) {
				if (vArmas[i] != null) {
					pw.println(vArmas);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ficheroencriptado.exists()) {

			ficheroencriptado.delete();
			System.out.println("El fichero desencriptado");

		}

	}
	
	public static void encriptarPisos() {
		File fichero = new File("datos/pisos.txt");
		File ficheroEncriptado = new File("datos/pisos.dat");
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		String[] vPisos = new String[20];

		if (!ficheroEncriptado.exists()) {
			try {
				ficheroEncriptado.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			// Leer texto scanner
			Scanner leer = new Scanner(fichero);
			while (leer.hasNextLine()) {
				for (int i = 0; i < vPisos.length; i++) {
					if (vPisos[i] == null) {
						vPisos[i] = leer.nextLine();
						break;
					}
				}
			}
			leer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		// Guardar el vector a fichero binario

		try {
			fout = new FileOutputStream(ficheroEncriptado);
			out = new ObjectOutputStream(fout);

			for (int i = 0; i < vPisos.length; i++) {
				if (vPisos[i] != null) {
					out.writeObject(vPisos[i]);

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fichero.exists()) {

			System.out.println("El fichero se ha borrado.");
			fichero.delete();

		}
	}
	
	
	public static void desencriptarPisos() {
		File fichero = new File("datos/pisos.txt");
		File ficheroencriptado = new File("datos/pisos.dat");
		FileInputStream fiou = null;
		ObjectInputStream oi = null;
		String[] vPisos = new String[20];
		FileWriter fw = null;
		PrintWriter pw = null;
		
		if (!ficheroencriptado.exists()) {
			try {
				ficheroencriptado.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			fiou = new FileInputStream(ficheroencriptado);
			oi = new ObjectInputStream(fiou);

			for (int i = 0; i < vPisos.length; i++) {
				if (vPisos[i] == null) {
					vPisos[i] = (String) oi.readObject();
					break;
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Scanner leer = new Scanner(fichero);
			fw = new FileWriter(fichero);
			pw = new PrintWriter(fw);
			for (int i = 0; i < vPisos.length; i++) {
				if (vPisos[i] != null) {
					pw.println(vPisos);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ficheroencriptado.exists()) {

			ficheroencriptado.delete();
			System.out.println("El fichero desencriptado");

		}

	}
	
	
}
