
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 
 * @author Alexandre Rodrigues 54472
 *
 */
public class ExercicioExcecoes {

	/**
	 * Ler vetor de inteiros e uma potencia e imprimir os valores das potencias dos
	 * inteiros
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File(args[0]));
			int tamanho = lerTamanhoVetor(sc);
			int[] inteiros = lerInteirosVetor(sc, tamanho);
			double potencia = lerValorPotencia(sc);
			if (potencia < 0)
				throw new IllegalArgumentException("O expoente tem de ser um número positivo!");
			double[] calculados = calculaPotencias(inteiros, potencia);
			imprimirVetor(calculados);	
		}
		catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} 
		catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		catch (FileNotFoundException e) {
			System.out.println("Houve um problema ao abrir o ficheiro de input!");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ler e devolver o tamanho do vetor original
	 * @param sc - o scanner usado para a leitura
	 * @return o tamanho do vetor a ler
	 * @requires sc != null
	 */
	public static int lerTamanhoVetor(Scanner sc) throws InputMismatchException, NumberFormatException {
		int tamanho = 0;
		try {
			tamanho = Integer.parseInt(sc.nextLine());
		}
		catch (NumberFormatException e) {
			throw new NumberFormatException("Ocorreu um erro ao ler o tamanho do vetor!");
		}
		if (tamanho <= 0)
			throw new InputMismatchException("O tamanho do vetor deve ser positivo!");
		return tamanho;
	}

	/**
	 * Ler um dado numero de inteiros e guardar num vetor
	 * 
	 * @param sc      - o scanner usado para a leitura
	 * @param tamanho - o numero de valores a ler
	 * @return o vetor de inteiros obtidos da leitura
	 * @requires sc != null && tamanho > 0
	 */
	public static int[] lerInteirosVetor(Scanner sc, int tamanho) throws InputMismatchException {
		String[] segundaLinha = sc.nextLine().split(" ");
		if (tamanho != segundaLinha.length)
			throw new InputMismatchException("O vetor deve ter o mesmo tamanho espicificado na primeira linha do ficheiro!");
		int[] resultado = new int[segundaLinha.length];
		for (int i = 0; i < segundaLinha.length; i++) {
			try {
				resultado[i] = Integer.parseInt(segundaLinha[i]);
			}
			catch (NumberFormatException e) {
				throw new NumberFormatException("Ocorreu um erro na leitura de um elemento do vetor!");
			}
		}
		return resultado;
	}

	/**
	 * Ler um valor que representa a potencia
	 * 
	 * @param sc - o scanner usado para a leitura
	 * @return o valor obtido da leitura
	 * @requires sc != null
	 */
	public static double lerValorPotencia(Scanner sc) {
		return Double.parseDouble(sc.nextLine());
	}

	/**
	 * Determina as potencias de um vector
	 * 
	 * @param inteiros - o vetor original
	 * @param potencia - a potencia que se pretende calcular do vetor de inteiros
	 * @return o vetor com as potencias de inteiros
	 * @requires inteiros != null && potencia >= 0
	 */
	private static double[] calculaPotencias(int[] inteiros, double potencia) throws ArithmeticException {
		double[] num = new double[inteiros.length];
		for (int i = 0; i < inteiros.length; i++) {
			num[i] = Math.pow(inteiros[i], potencia);
			if (Double.isNaN(num[i]))
				throw new ArithmeticException("Não é possível calcular raízes quadradas de números negativos!");
		}
		return num;
	}

	/**
	 * Imprime os valores de um vetor de doubles
	 * 
	 * @param v - o vetor do qual se quer imprimir os valores
	 */
	private static void imprimirVetor(double[] v) {
		for (double d : v) {
			System.out.println(d);
		}
	}

}
