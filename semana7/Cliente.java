/**
 * Classe cujas instancias representam clientes muito simples.
 * 
 * @author Alexandre Rodrigues 54472
 */
public class Cliente {
	private String idCliente;

	/**
	 * Construtor
	 * 
	 * @param idCliente Identificador do cliente
	 * @requires idCliente != null
	 */
	public Cliente(String idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * O identificador do cliente
	 */
	public String idCliente() {
		return idCliente;
	}

	/**
	 * Representacao textual deste cliente
	 */
	@Override
	public String toString() {
		return "[ idCliente " + idCliente + "] ";
	}

	/**
	 * Este cliente eh igual a outro?
	 * 
	 * @param obj O outro objeto
	 * @return true se este objeto eh igual a obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} 
		if (!(obj instanceof Cliente)) {
			return false;
		}
		if (((Cliente)obj).idCliente == this.idCliente) {
			return true;
		}
		return false;
	}
}
