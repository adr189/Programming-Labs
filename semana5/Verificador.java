package main;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author Alexandre Rodrigues 54472
 *
 */
public class Verificador {

	private static ArrayList<ParDeSimbolos> listadeSimbolos = new ArrayList<ParDeSimbolos>(); 
	private static ArrayList<String> listadeExpressoes = new ArrayList<String>();
	private static Stack<String> aberturas = new Stack<String>();
	
	/**
	 * Lê os símbolos
	 * @param fileName Nome do ficheiro
	 */
	private static void readSymbols(String fileName) {
		 File ficheiro = new File(fileName); //cria um ficheiro
		 try (Scanner sc = new Scanner(ficheiro)){
			 while (sc.hasNextLine()) {
				 String[] linhaDividida = sc.nextLine().split(" "); //separa os elementos das expressões por espaços
				 listadeSimbolos.add(new ParDeSimbolos(linhaDividida[0], linhaDividida[1])); //adiciona à lista de símbolos um parênteses de abertura e outro de fecho	 
			 }
		 } catch (Exception e) {
			 System.out.println("Há um problema ao ler o ficheiro de símbolos!");
		 }
	}
	
	/**
	 * Lê as expressões
	 * @param fileName Nome do ficheiro
	 */
	private static void readExpressions(String fileName) {
		File ficheiro = new File(fileName);
		 try (Scanner sc = new Scanner(ficheiro)){
			 while (sc.hasNextLine()) {
				 String linha = sc.nextLine();
				 listadeExpressoes.add(linha);	 
			 }
		 } catch (Exception e) {
			 System.out.println("Há um problema ao ler o ficheiro de expressões!");
		 }	
	}
	
	/**
	 * Verifica as expressões
	 * @param exp Expressão
	 * @return
	 */
	private static String checkExpressions(String exp) {
		String[] elementos = exp.split(" "); //separa os elementos das expressões por espaços
		for (int i = 0; i < elementos.length; i++) {
			for (ParDeSimbolos par: listadeSimbolos) {
				if (par.getInicio().equals(elementos[i])) {
					aberturas.add(elementos[i]);
				}
				else if(par.getFim().equals(elementos[i])) {
					if (aberturas.isEmpty()) {
						return exp + " ==> encontrei " + elementos[i] + " extemporâneo"; //o resultado da expressão verificada tem um erro: aparece um símbolo a mais
					}
					else if(!aberturas.peek().equals(par.getInicio())) {
						for (ParDeSimbolos par1: listadeSimbolos) {
							if (aberturas.peek().equals(par1.getInicio())) {
								return  exp +  " ==> esperava " + par1.getFim() + " encontrei " + elementos[i]; //o resultado da expressão verificada tem um erro: um dos símbolos é diferente daquele que era esperado
							}
						}
					}
					aberturas.pop();
				}
			}
		}
		return exp + " ==> ok"; //o resultado da expressão verificada não tem erros
	}
	
	/**
	 * Escreve um output 
	 * @param out
	 * @param fileName Nome do ficheiro
	 */
	private static void writeOutput(String out, String fileName) {
		File output = new File(fileName); //cria um terceiro ficheiro de output
		try (PrintWriter pw = new PrintWriter(output)) {
			pw.write(out);
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * Implementa todos os mecanismos de verificação
	 * @param args
	 */
	public static void main(String[] args) {
		readSymbols(args[0]);
		readExpressions(args[1]);
		StringBuilder sb = new StringBuilder();
		for (String exp: listadeExpressoes) {
			sb.append(checkExpressions(exp) + "\n");
			aberturas.removeAllElements();
		}
		writeOutput(sb.toString(), args[2]);
	}

}
