import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe cujas instancias representam pacotes de elementos de um qualquer tipo.
 * Tem uma capacidade maxima.
 * 
 * @author Alexandre Rodrigues 54472
 * @param <E> O tipo dos elementos
 */
public class Pacote<E> implements Iterable<E> {
	// numero maximo de elementos que pode conter
	private int capacidade;
	// numero de elementos que realmente contem
	private int capacidadeOcupada;
	// os elementos contidos neste pacote
	private ArrayList<E> elementos;

	/**
	 * Construtor
	 * 
	 * @param capacidade Dimensao maxima que o novo pacote pode ter
	 * @requires capacidade > 0
	 */
	public Pacote(int capacidade) {
		this.capacidade = capacidade;
		this.capacidadeOcupada = 0;
		this.elementos = new ArrayList<>(capacidade);
	}

	/**
	 * O numero maximo de elementos que este pacote pode ter
	 */
	public int capacidadeMaxima() {
		return this.capacidade;
	}

	/**
	 * A capacidade jah utilizada deste pacote
	 */
	public int capacidadeOcupada() {
		return this.capacidadeOcupada;
	}

	/**
	 * O pacote jah tem o numero maximo de elementos permitido?
	 * 
	 * @return true se o pacote ja tiver atingido o num maximo de elementos; false
	 *         c.c.
	 */
	public boolean estaCheio() {
		return this.capacidadeOcupada == this.capacidade;
	}

	/**
	 * Empacota um item se o pacote nao estiver cheio.
	 * 
	 * @param elemento O elemento a ser empacotado
	 * @requires !estaCheio()
	 */
	public void empacota(E elemento) {
		if (!estaCheio()) {
			elementos.add(elemento);
			capacidadeOcupada++;
		}
	}

	/**
	 * Representacao textual dos elementos deste pacote
	 */
	@Override
	public String toString() {
		return elementos.toString();
	}

	/**
	 * Um iterador que permite aceder a todos os elementos presentes neste pacote
	 */
	public Iterator<E> iterator() {
		return new PacoteIterator();
	}

	/*
	 * Classe privada que define o iterador da classe Pacote
	 */
	private class PacoteIterator implements Iterator<E> {
		
		private int index;
		
		private PacoteIterator() {
			this.index = -1;
		}
		
		public boolean hasNext() {
			return this.index < elementos.size()-1;
		}
		
		public E next() {
			E result = null;
			if (hasNext()) {
				this.index++;
				return elementos.get(this.index);
			}
			return result;
		}

	}
}
