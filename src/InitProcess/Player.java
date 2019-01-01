package InitProcess;



import java.util.ArrayList;

import CardTypes.Card;
/**
 * 
 * @author Nick Karamessinis
 *Postcondition making a Player instance initializing some important booleans 
 *for the game to be set.Also setting miles to 0 and creating an Array-Pile as the players hand
 */
public class Player {
	private String name;
	private boolean problem=false;
	private boolean startisPlayed=false;
	private boolean rightofway=false;
	private boolean flattirePlay = true;//play= h dynatothta na paixtei 
	private boolean flattireisPlayed=false;//isPlayed exei paixtei 
	private boolean outofgasPlay = true;
	private boolean outofgasisPlayed=false;
	private boolean speedlplay = true;
	private boolean speedlisPlayed=false;
	private boolean stopplay = true;
	private boolean stopisPlayed=false;
	private boolean accidentPlay=true;
	private boolean accidentsisPlayed=false;
	ArrayList<Card> Pile = new ArrayList<Card>(7);
	
	public int PointSum=0;
	private int limit200=0;
	/*
	 * Constructor of a player instance
	 */
	public Player(String name){this.setName(name);
	}
	/** 
	 * These are all getters and setters to private types of this class
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isStartisPlayed() {
		return startisPlayed;
	}
	public void setStartisPlayed(boolean startisPlayed) {
		this.startisPlayed = startisPlayed;
	}
	public boolean isRightofway() {
		return rightofway;
	}
	public void setRightofway(boolean rightofway) {
		this.rightofway = rightofway;
	}
	public String toString() {
		return name;

	}
	public boolean isProblem() {
		return problem;
	}
	public void setProblem(boolean problem) {
		this.problem = problem;
	}
	public boolean isFlattirePlay() {
		return flattirePlay;
	}
	public void setFlattirePlay(boolean flattirePlay) {
		this.flattirePlay = flattirePlay;
	}
	public boolean isFlattireisPlayed() {
		return flattireisPlayed;
	}
	public void setFlattireisPlayed(boolean flattireisPlayed) {
		this.flattireisPlayed = flattireisPlayed;
	}
	public boolean isAccidentPlay() {
		return accidentPlay;
	}
	public void setAccidentPlay(boolean accidentPlay) {
		this.accidentPlay = accidentPlay;
	}
	public boolean isStopplay() {
		return stopplay;
	}
	public void setStopplay(boolean stopplay) {
		this.stopplay = stopplay;
	}
	public boolean isSpeedlplay() {
		return speedlplay;
	}
	public void setSpeedlplay(boolean speedlplay) {
		this.speedlplay = speedlplay;
	}
	public boolean isOutofgasPlay() {
		return outofgasPlay;
	}
	public void setOutofgasPlay(boolean outofgasPlay) {
		this.outofgasPlay = outofgasPlay;
	}
	public boolean isAccidentsisPlayed() {
		return accidentsisPlayed;
	}
	public void setAccidentsisPlayed(boolean accidentsisPlayed) {
		this.accidentsisPlayed = accidentsisPlayed;
	}
	public boolean isOutofgasisPlayed() {
		return outofgasisPlayed;
	}
	public void setOutofgasisPlayed(boolean outofgasisPlayed) {
		this.outofgasisPlayed = outofgasisPlayed;
	}
	public boolean isStopisPlayed() {
		return stopisPlayed;
	}
	public void setStopisPlayed(boolean stopisPlayed) {
		this.stopisPlayed = stopisPlayed;
	}
	public boolean isSpeedlisPlayed() {
		return speedlisPlayed;
	}
	public void setSpeedlisPlayed(boolean speedlisPlayed) {
		this.speedlisPlayed = speedlisPlayed;
	}
	public int getLimit200() {
		return limit200;
	}
	public void setLimit200(int limit200) {
		this.limit200 = limit200;
	}
}
