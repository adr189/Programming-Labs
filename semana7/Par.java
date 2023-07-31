/**
 * Classe cujas instancias representam pares de elementos ordenados
 * 
 * @author Alexandre Rodrigues 54472
 */
public class Par<K, F> {
	private K primeiro;
	private F segundo;

	/**
	 * Construtor
	 * 
	 * @param primeiro O primeiro elemento
	 * @param segundo  O segundo elemento
	 */
	public Par(K primeiro, F segundo) {
		this.primeiro = primeiro;
		this.segundo = segundo;
	}

	/**
	 * O primeiro elemento deste par
	 */
	public K primeiro() {
		return primeiro;
	}

	/**
	 * O segundo elemento deste par
	 */
	public F segundo() {
		return segundo;
	}

	/**
	 * Representacao textual deste par
	 */
	@Override
	public String toString() {
		return "[ " + primeiro.toString() + " " + segundo.toString() + "] ";
	}

	/**
	 * Este par eh igual a outro?
	 * 
	 * @param obj O outro objeto
	 * @return true se este objeto eh igual a obj
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Par)) {
			return false;
		}

		@SuppressWarnings("unchecked")
		Par<K, F> other = (Par<K, F>) obj;
		return equalPar(other);
	}

	private boolean equalPar(Par<K, F> other) {
		return equalK(primeiro, other) && equalF(segundo, other);

	}

	private boolean equalK(K itemK, Par<K, F> other) {
		if (itemK == null)
			return other.primeiro() == null;
		return itemK.equals(other.primeiro());
	}

	private boolean equalF(F itemF, Par<K, F> other) {
		if (itemF == null)
			return other.segundo() == null;
		return itemF.equals(other.segundo());
	}
}
