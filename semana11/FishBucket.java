import java.util.HashMap;

/**
 * A fish bucket is a device used to store fish, which organizes it by fish
 * name. It can store any number of different fish.
 * 
 * @author Alexandre Rodrigues 54472
 *
 */
public class FishBucket implements FishBucketInterface{
	private HashMap<Fish, Double> bucket;


	/**
	 * Constructor
	 */
	public FishBucket() {
		bucket = new HashMap<Fish, Double>();
	}
	/**
	 * Add the fish to the bucket
	 *
	 * @param f the fish to be added to the bucket
	 */
	@Override
	public void addFish(Fish f) {
		double previous = 0.0;
		if (bucket.containsKey(f)) {
			previous = bucket.get(f);
		}
		bucket.put(f, previous + f.getWeight());
	}

	/**
	 * Returns the weight of a fish in the bucket
	 * 
	 * @param f the fish whose weight is to be returned
	 * @return the weight of f in the bucket
	 */
	@Override
	public double getFishWeight(Fish f) {
		if (bucket.containsKey(f)) {
			return bucket.get(f);
		} else {
			return 0;
		}
	}

	/**
	 * Returns the total weight of fish in the bucket
	 * 
	 * @return the total weight of fish in the bucket
	 */
	@Override
	public double totalWeight() {
		double sum = 0;
		for (Fish f: bucket.keySet()) {
			sum += bucket.get(f);
		}
		return sum;
	}


	/**
	 * Removes all fish f from the bucket
	 * 
	 * @param f
	 */
	@Override
	public void removeFish(Fish f) {
		bucket.clear();
	}

	/**
	 * Computes the total value of the bucket given prices per unit of weight
	 * 
	 * @param prices
	 * @return
	 */
	@Override
	public double bucketValue(FishPrices prices) {
		double sum = 0;
		for (Fish f: bucket.keySet()) {
			sum += bucket.get(f) * prices.getFishPrice(f);
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (Fish f: bucket.keySet()) {
			sb.append("\t" + f.getDesignation() + " " + bucket.get(f) + "\n");
		}
		return sb.toString();
	}
}
