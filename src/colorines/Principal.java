package colorines;

/*Gozalo Andrés, Roberto*/
/*Calleja Alonso, Samuel*/

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Tablero tablero;
		tablero = new Tablero();
		String entrada;
		boolean aux = true;
		tablero.Inicializar();

		// System.out.println("Bienvenido a Colorines");
		titulo();
		do {
			
			int fich = (int) (Math.random() * (6 - 1 + 1) + 1);// genera
																// aleatoriamente
																// la ficha
			System.out.println("Color de la ficha generada: " + fich);
			Scanner in = new Scanner(System.in);
			System.out.println("¿En qué columna desea colocarla?");// recoge la
																	// columna
																	// en la
																	// que
																	// colocar
																	// la ficha
			entrada = in.next();
			// Validación de datos de entrada
			if (entrada.length() > 1) {
				System.out
						.println("Columna incorrecta, columnas posibles del 1 al 6");
			} else if ((tablero.valida(entrada) == false)) {
				System.out
						.println("Columna incorrecta, columnas posibles del 1 al 6");
			} else if (entrada.compareTo("0") == 0) {
				aux = false;
				System.out.println("El juego ha terminado");

			} else if (tablero.esColumnaCompleta(entrada)) {
				aux = false;
				System.out.println("El juego ha terminado");
			} else {
				tablero.insertaFicha(entrada, fich);
				// tablero.dibujarTablero();
				while (tablero.ObtFilaEliminable() != -1) {
					int filaElimi = tablero.ObtFilaEliminable();
					tablero.suprimirFila(filaElimi);
				}
				tablero.dibujarTablero();
			}

		} while (aux);

	}

	/* Este método sirve para leer del archivo el título del programa */
	public static void titulo() {
		try {
			Scanner title = new Scanner(
					Tablero.class.getResourceAsStream("titulo.txt"));
			String text;
			while (title.hasNextLine()) {
				text = title.nextLine();
				if (text.charAt(0) != '/') {
					System.out.println(text);
				}
			}
			title.close();
			title = null;
			text = null;
		} catch (Exception e) {
		}

	}
}