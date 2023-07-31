package main;

/**
 * 
 * @author Alexandre Rodrigues 54472
 *
 */
public class ParDeSimbolos {
	
	private String inicio;
			
	private String fim;
	
	/**
	 * Declara os símbolos de abertura e fecho
	 * @param inicio abertura do par de símbolos
	 * @param fim fecho do par de símbolos
	 */
	public ParDeSimbolos(String inicio, String fim) {
		this.inicio = inicio; 
		this.fim = fim;
	}

	/**
	 * Obtém o símbolo de abertura
	 * @return início do par de símbolos
	 */
	public String getInicio() {
		return inicio;
	}

	/**
	 * Obtém o símbolo de fecho
	 * @return fim do par de símbolos
	 */
	public String getFim() {
		return fim;
	}
	
}
