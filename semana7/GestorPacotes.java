import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe cujas instancias sabem criar pacotes a partir de uma lista de entradas
 * 
 * @author Alexandre Rodrigues 54472
 */
public class GestorPacotes<K, F> {
	// Colecao dos pacotes
	private List<Pacote<Par<K, F>>> pacotes;
	// Capacidade maxima de cada pacote
	private int capacidadePacotes;

	/**
	 * Construtor
	 * 
	 * @param capacidadePacotes Capacidade maxima de cada pacote
	 * @requires capacidadePacotes > 0
	 */
	public GestorPacotes(int capacidadePacotes) {
		this.pacotes = new ArrayList<>();
		this.capacidadePacotes = capacidadePacotes;
	}

	/**
	 * Cria pacotes de entradas a partir de uma lista de entradas Cada entrada eh um
	 * par Cada pacote contem apenas entradas com valores iguais dos seus primeiros
	 * elementos
	 * 
	 * @param entradas A lista com as entradas a empacotar
	 */
	public void criaPacotes(List<Par<K, F>> entradas) {
		while (!entradas.isEmpty()) {
			Pacote<Par<K, F>> pac = new Pacote<Par<K, F>>(capacidadePacotes);
			Par<K, F> par = entradas.get(0);
			pac.empacota(par);
			entradas.remove(0);
			List<Par<K, F>> found = new ArrayList<Par<K, F>>();
			for (Par<K, F> p: entradas) {
				if (pac.estaCheio()) {
					break;
				}
				if (p.primeiro().equals(par.primeiro())) {
					pac.empacota(p);
					found.add(p);
				}
			}
			entradas.removeAll(found);
			pacotes.add(pac);
		}

	}

	/**
	 * O numero total de elementos guardados nos pacotes deste gestor de pacotes
	 */
	public int numeroElementosEmpacotados() {
		int count = 0;
		for (Pacote<Par<K, F>> p: pacotes) {
			count+=p.capacidadeOcupada();
		}
		return count;
	}

	/**
	 * Numero de pacotes deste gestor de pacotes
	 */
	public int numeroPacotes() {
		return pacotes.size();
	}

	/**
	 * Numero de pacotes deste gestor de pacotes que teem um dado primeiro elemento
	 * 
	 * @paramp prim Primeiro elemento a pesquisar
	 * @return Numero de pacotes com primeiro elemento igual a prim
	 * 
	 */
	public int numeroElementosK(K prim) {
		int count = 0;
		for (Pacote<Par<K, F>> p: pacotes) {
			Iterator<Par<K, F>> it = p.iterator();
			while (it.hasNext()) {
				Par<K, F> par = it.next();
				if (par.primeiro().equals(prim)) {
					count++;
				}
			}
		}
		return count-1;
	}

	/**
	 * Lista com os primeiros elementos dos pares cujo segundo elemento tem o valor
	 * dado
	 * 
	 * @param seg Valor do segundo elemento do par a procurar
	 * @return A lista de primeiros elementos dos pares que teem seg como segundo
	 *         elemento
	 */
	public List<K> listaElementosK(F seg) {
		List<K> prim = new ArrayList<K>();
		for (Pacote<Par<K, F>> p: pacotes) {
			Iterator<Par<K, F>> it = p.iterator();
			while (it.hasNext()) {
				Par<K, F> par = it.next();
				if (par.segundo().equals(seg)) {
					prim.add(par.primeiro());
				}
			}
		}
		return prim;
	}

	/**
	 * Representacao textual dos pacotes criados, um por linha
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Pacote<Par<K, F>> pEmp : pacotes) {
			sb.append(pEmp.toString() + "\n");
		}
		return sb.toString();
	}

}
