import java.util.HashMap;

/**
 * 
 * @author Alexandre Rodrigues 54472
 * Dados os parâmetros de gerador LCG, e uma seed inicial,
 * obtém-se o tamanho do ciclo de números pseudo-aleatórios gerados.
 */
public class LCG {
	private int a;
	private int b;
	private int m;
	private int x0;
	private int atual;
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param m
	 * @param x0
	 */
	public LCG (int a, int b, int m, int x0) {
		this.a = a;
		this.b = b;
		this.m = m;
		this.x0 = x0;
		atual = x0;
	}
	
	/**
	 * Devolve a semente original do gerador.
	 * @return
	 */
	public int getSeed() {
		return x0;
	}

	/**
	 * Gera e devolve o valor seguinte do gerador pesudo-aleatório,
	 * atualizando o estado interno do gerador.
	 * @return
	 */
	public int next() {
		atual = (a*atual+b) % m; //valor seguinte do gerador pesudo-aleatório
		return atual;
	}

	/**
	 * Calcula o tamanho do ciclo de valores gerados pelo LCG.
	 */
	public int cycleLength() {
		HashMap<Integer,Integer> numbers = new HashMap<Integer,Integer>();
		int temp = x0;
		numbers.put(temp, 0);
		for (int i = 1; i <= m; i++) {
			temp = (a*temp+b) % m;
			Integer x = numbers.put(temp,i);
			if (x!= null) {
				return numbers.get(temp)-x;
			}
		}
		return 0;
	}
}
