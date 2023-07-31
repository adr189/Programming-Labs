import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Alexandre Rodrigues 54472
 */
public class Sudoku {


	/**
	 * Lê o fileIn, faz validação e devolve mensagem
	 * @param fileIn
	 * @return
	 */

	public static String verificaQuadrado(String fileIn) {
		String [][] matrix = new String [9][]; //o quadrado é 9x9
		try {
			File in = new File(fileIn);
			Scanner myReader = new Scanner(in);
			int counter = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String [] lista = data.split(" ");
				matrix[counter] = lista;
				counter++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro com o ficheiro de input.");
			e.printStackTrace();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!(verificaLinhas(i,j,matrix) && verificaColunas(i,j,matrix) && verificaRegioes(i,j,matrix))) {
					StringBuilder sb = new StringBuilder();
					sb.append("O puzzle seguinte está errado:\n");
					String separadorLinhas = "+-----+-----+-----+\n";
					for (int e = 0; e < 9; e++) {
						if (e % 3 == 0) {
							sb.append(separadorLinhas); // imprime um seperador de linhas de 3 em 3 linhas
						}
						for (int d = 0; d < 9; d++) {
							if (d % 3 == 0) {
								sb.append("|");  // imprime uma barra vertical para separar os elementos de uma mesma linha pertencentes a regiões diferentes
							}
							sb.append(matrix[e][d]);
							if ((d + 1) % 3 != 0) {
								sb.append(" "); // imprime um espaço entre cada número pertencente a uma mesma linha de uma mesma região
							}
						}
						sb.append("|\n");
					}
					sb.append(separadorLinhas);
					return sb.toString();
				}
			}
		}
		return "O puzzle respeita as regras do Sudoku.\n";
	}

	/**
	 * Verifica as linhas
	 * @param x
	 * @param y
	 * @param matrix
	 * @return
	 */
	public static boolean verificaLinhas(int x, int y, String[][] matrix) {
		for (int i = 0; i < 9; i++) {
			if (i != y)
				if (matrix[x][i].equals(matrix[x][y]))
					return false;
		}
		return true;
	}

	/**
	 * Verifica as colunas
	 * @param x
	 * @param y
	 * @param matrix
	 * @return
	 */
	public static boolean verificaColunas(int x, int y, String[][] matrix) {
		for (int i = 0; i < 9; i++) {
			if (i != x)
				if (matrix[i][y].equals(matrix[x][y]))
					return false;
		}
		return true;
	}

	/**
	 * Verifica as regiões
	 * @param x
	 * @param y
	 * @param matrix
	 * @return
	 */
	public static boolean verificaRegioes(int x, int y, String[][] matrix) {
		int a = x/3;
		int b = y/3;
		for (int i = 3*a; i < 3*(a+1); i++) {
			for (int j = 3*b; j < 3*(b+1); j++) {
				if (i != x && j != y)
					if (matrix[i][j].equals(matrix[x][y]))
						return false;
			}
		}
		return true;
	}

}
