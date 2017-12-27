package colorines;

/*Gozalo Andrés, Roberto*/
/*Calleja Alonso, Samuel*/



public class Tablero {
	int fila = 10;
	int columna = 6;
	int fich;
	String[][] tablero = new String[fila][columna];

	public Tablero() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* Este método dibujará nuestra matriz */
	public void dibujarTablero() {
		System.out.println("Pinto el tablero");
		int i, j;

		for (i = 0; i < tablero.length; i++) { // número de filas
			for (j = 0; j < tablero[i].length; j++) { // número de
														// columnas de
														// cada fila
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();

		}
	}

	/* Este método escribirá los guiones en la matriz */
	public void Inicializar() {
		int i, j;

		for (i = 0; i < fila; i++) {
			for (j = 0; j < columna; j++) {
				tablero[i][j] = "-";
			}

		}
	}

	
	/* Este método valida la introducción de datos por parte del usuario */
	public  boolean valida(String col) {
		String[] arrayNumVal = { "0", "1", "2", "3", "4", "5", "6" };
		for (int i = 0; i < arrayNumVal.length; i++) { // número de filas
			if (arrayNumVal[i].compareTo(col) == 0) {
				return true;
			}
		}
		return false;
	}

	/* Este método devolverá true si la columna ya está completa */
	public boolean esColumnaCompleta(String col) {

		int colAux = Integer.parseInt(col);
		// Valida que la columna no está llena
		if (tablero[0][colAux - 1].compareTo("-") != 0)
			return true;
		else
			return false;
	}

	/* Este método devuelve un valor si la fila puede ser eliminada */
	public int ObtFilaEliminable() {
		int filAux = fila - 1;
		while (filAux >= 0) {
			boolean filDescartada = false;
			int colAux = columna - 1;
			String val = tablero[filAux][colAux];
			while (!filDescartada && colAux >= 0) {
				if (tablero[filAux][colAux].compareTo("-") == 0) {
					return -1;
					// parar=true;
				} else {
					if (tablero[filAux][colAux].compareTo(val) != 0) {
						filDescartada = true;
						
					}
				}
				colAux = colAux - 1;
			}
			if (!filDescartada) {
				return filAux;
			}

			filAux = filAux - 1;
		}
		return 10;
	}

	
	/* Éste método suprime la fila y rellena la de arriba del todo con guiones */
	public void suprimirFila(int fil) {
		// Desplaza las filas una posición hacia abajo
		for (int i = fil; i > 0; i--) {
			for (int j = 0; j < columna; j++) {
				tablero[i][j] = tablero[i - 1][j];

			}

		}
		// Rellena la última fila con "-"
		for (int j = 0; j < columna; j++) {
			tablero[0][j] = "-";

		}

	}

	
	/*
	 * Este método insertará, en nuestra matriz, la ficha que hemos generado
	 * aleatoriamente
	 */
	public void insertaFicha(String col, int fich) {
		int colAux = Integer.parseInt(col);
		int i;
		boolean encontrado = false;
		for (i = 10; i > 0; i--) {
			if (tablero[i - 1][colAux - 1].compareTo("-") == 0 && !encontrado) {
				tablero[i - 1][colAux - 1] = Integer.toString(fich);
				if (i < 10) {
					transformaFicha(i - 1, colAux - 1);
				}
				encontrado = true;
			}
		}

	}

	/*
	 * Este método es el encargado de las transformaciones de la ficha
	 * introducida y la que se encuentra justo debajo
	 */
	public void transformaFicha(int fil, int col) {
		int fichN = Integer.parseInt(tablero[fil][col]);
		int fichA = Integer.parseInt(tablero[fil + 1][col]);
		// Rojo + Amarillo = Naranja (1+2=3)
		if ((fichN == 1 && fichA == 2) || (fichA == 1 && fichN == 2)) {
			tablero[fil][col] = "3";
			tablero[fil + 1][col] = "3";
		} // Rojo + Azul = Morado (1+4=5)
		else if ((fichN == 1 && fichA == 4) || (fichA == 1 && fichN == 4)) {
			tablero[fil][col] = "5";
			tablero[fil + 1][col] = "5";
		}// Amarillo + Azul = Verde (2+4=6)
		else if ((fichN == 2 && fichA == 4) || (fichA == 2 && fichN == 4)) {
			tablero[fil][col] = "6";
			tablero[fil + 1][col] = "6";
		} // Naranja + Morado = Rojo (3+5=1)
		else if ((fichN == 3 && fichA == 5) || (fichA == 3 && fichN == 5)) {
			tablero[fil][col] = "1";
			tablero[fil + 1][col] = "1";
		} // Naranja + Verde = Amarillo (3+6=2)
		else if ((fichN == 3 && fichA == 6) || (fichA == 3 && fichN == 6)) {
			tablero[fil][col] = "2";
			tablero[fil + 1][col] = "2";
		}// Morado + Verde = Azul (5+6=4)
		else if ((fichN == 5 && fichA == 6) || (fichA == 5 && fichN == 6)) {
			tablero[fil][col] = "4";
			tablero[fil + 1][col] = "4";
		}
	}

}