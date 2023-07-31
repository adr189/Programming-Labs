package main;

import java.util.Arrays;

/**
 * 
 * @author Alexandre Rodrigues 54472
 *
 */
public class Recursive {
	
	/**
	 * Calcula e devolve a potência cuja base é x e o expoente é n
	 * @param x
	 * @param n
	 * @return
	 * @requires {n >= 0}
	 */
	public static double potencia(double x, int n) {
		if (n == 0)
			return 1;
		return x * potencia(x,n-1);
	}

	/**
	 * Calcula e devolve o número de vezes que o caráter c aparece em s
	 * @param s
	 * @param c
	 * @return
	 * @requires {s != null}
	 */
	public static int quantosChars(String s, char c) {
		if (s.isEmpty())
			return 0;
		if (s.charAt(0) == c)
			return 1 + quantosChars(s.substring(1),c);
		return quantosChars(s.substring(1),c);
	}
	
	/**
	 * Retorna true se k ocorre em v
	 * @param v
	 * @param k
	 * @return
	 */
	public static boolean pertence(int[] v, int k) {
		if (v.length == 0)
			return false;
		if (k == v[0])	
			return true;
		else 
			return pertence(Arrays.copyOfRange(v, 1, v.length), k);	
	}
	
	/**
	 * Calcula e devolve o número de orelhas aparentes que se vêem numa fila com n coelhos
	 * @param n
	 * @return
	 * @requires {n > 0}
	 */
	public static int numeroOrelhas (int n) {
		if (n == 0)
			return 0;
		if (n % 2 == 0)
			return 2 + numeroOrelhas(n-1);
		else 
			return 3 + numeroOrelhas(n-1);
	}
	
	/**
	 * Calcula e devolve a soma dos algarismos de n
	 * @param n
	 * @return
	 * @requires {n >= 0}
	 */
	public static int somaAlgarismos(int n) {
		if (n < 10)
			return n;
		return (n % 10) + somaAlgarismos(n/10); 
	}
	
	/**
	 * Calcula e devolve o produto de p e q
	 * @param p
	 * @param q
	 * @return
	 */
	public static int produto(int p, int q) {
		if (p == 0 || q == 0)
			return 0;
		if(p < 0 && q > 0)
			return -1 * (produto(-p, q));
	    if(p > 0 && q < 0)
	    	return -1 * (produto(p, -q));
	    if(p < 0 && q < 0)
	    	return produto(-p, -q);
		return p + produto(p, q-1);
	}
}
