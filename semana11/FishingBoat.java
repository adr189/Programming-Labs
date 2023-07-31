import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A fishing boat should have a FishingBucket to store the fish caught during
 * the fishing trip, as well as be able to decide where to go, or decide to fish
 * at any given point.
 * 
 * @author Alexandre Rodrigues 54472
 *
 */
public class FishingBoat implements FishingBoatInterface {

	private  Set<Pair> fishLocations;
	private Pair boatLocation;
	private FishBucket bucket;

	/**
	 * Constructor
	 * @param fishLocations	the locations for the fish
	 * @param boatLocation the boat location
	 */
	public FishingBoat(Set<Pair> fishLocations, Pair boatLocation) {
		this.boatLocation = boatLocation;
		this.fishLocations = new HashSet<Pair>(fishLocations);
		bucket = new FishBucket();
	}

	/**
	 * Returns the bucket on the boat
	 * 
	 * @return the bucket on the boat
	 */
	@Override
	public FishBucket getBucket() {
		return bucket;
	}

	private int manhattanDistance(Pair a, Pair b) {
		return Math.abs(a.getX()-b.getX())+Math.abs(a.getY()-b.getY());
	}
	/**
	 * Decides which action to do at a certain moment. The action could be to move
	 * UP, DOWN, LEFT or RIGHT, to FISH, or to end your trip.
	 * 
	 * @return the next action the boat decides to make
	 */
	@Override
	public BoatAction nextMove() {
		if (fishLocations.isEmpty()) {
			return BoatAction.END_TRIP;		//if there is no fish, the trip ends
		}
		Pair closest = null;
		int dist = 0;
		Iterator<Pair> it = fishLocations.iterator();		//creates an iterator for the fish locations
		if (it.hasNext()) {
			Pair first = it.next();		//the next fish in the iterator is the first one to be searched
			closest = first;
			dist = manhattanDistance(first, boatLocation);
		}	
		while (it.hasNext()) {
			Pair other = it.next();		//the next fish in the iterator is the next one to be searched
			int dist2 = manhattanDistance(other, boatLocation);
			if (dist > dist2) {
				closest = other;		//if other fish is closer to the boat location the closest fish equals the other fish
				dist = dist2;
			}
		}
		if (boatLocation.getX() < closest.getX()) {
			return BoatAction.RIGHT;	//the boat goes right if the x coordinate for the boat location is smaller than the x for the closest fish
		} 
		else if (boatLocation.getX() > closest.getX()) {
			return BoatAction.LEFT;		//the boat goes left if the x coordinate for the boat location is bigger than the x for the closest fish
		}
		else if (boatLocation.getY() > closest.getY()) {
			return BoatAction.UP;		//the boat goes up if the y coordinate for the boat location is bigger than the y for the closest fish
		}
		else if (boatLocation.getY() < closest.getY()) {
			return BoatAction.DOWN;		//the boat goes down if the y coordinate for the boat location is smaller than the y for the closest fish
		}
		else {
			fishLocations.remove(closest);
			return BoatAction.FISH;		//the closest fish is caught
		}
	}

	/**
	 * Adds a fish to the bucket on the boat
	 * 
	 * @param f the fish to be added to the bucket
	 */
	@Override
	public void addFish(Fish f) {
		bucket.addFish(f);
	}
}
