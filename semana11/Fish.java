/**
 * 
 * @author Alexandre Rodrigues
 *
 */
public class Fish implements FishInterface {
	private double weight;
	private String designation;
	
	/**
	 * Constructor
	 * @param designation the fish designation
	 * @param weight the weight of the fish
	 */
	public Fish(String designation, double weight) {
		this.weight = weight;
		this.designation = designation;
	}

    /**
     * Get the fish designation
     * 
     * @return the fish designation
     */
	@Override
	public String getDesignation() {
		return designation;
	}

    /**
     * Get the fish weight
     * 
     * @return the fish weight
     */
	
	@Override
	public double getWeight() {
		return weight;
	}

    /**
     * Two fish are considered equal when their designation is equal.
     * 
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
    	if (o == this) {
    		return true;
    	}
    	if (!(o instanceof Fish) ) {
    		return false;
    	}
    	Fish f = (Fish) o;
    	return this.getDesignation().equals(f.getDesignation());
    }

    @Override
    public int hashCode() {
		return designation.hashCode();
    }

    @Override
    public String toString() {
    	return designation + " weight: " + weight;
    }
}
