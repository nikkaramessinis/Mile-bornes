package InitProcess;// kati paizei me to is elligible isws auto prp na xrhsimopoihsw g na lysw to katw problima
//dn mporw na pai3w speedlimit ama exei paixtei h right of way  gia to extra tank doulevei 
//kati paixthke me speedlimit paizei na xa hdh provlhmaapopisw kai na mphke kai allo
//ama pezetai provlhma panw sto provlhma isxyei to teleftaio
//ama pezetai safety prp na mhn mporei na paixtei to provlhma 
// 
import CardTypes.Card;

/**
 * Is responsible for making the game work that is,create instances ,set some
 * important rules,determine which turn is this
 * 
 * @author Nick
 * 
 */
public class Controller {
	Player winner;
	Player p1, p2;
	int seira = 1;
/**
	 * Constructor Makes instances of the players and a Deck
	 */
	public Controller() {
		p1 = new Player(" ");
		p2 = new Player(" ");
		View.send(p1, p2);
	
	}
/**
 * when a safety card is played some booleans change
 * 
 * @param player
 * @param k
 */
	void Safety(Player player, int k) {
										
		if (player.Pile.get(k).getName() == "DRIVING_ACE") {
			player.setAccidentPlay(false);
			player.setAccidentsisPlayed(false);
		}
		if (player.Pile.get(k).getName() == "RIGHT_OF_WAY") {
			player.setStopplay(false);
			player.setStopisPlayed(false);
			player.setSpeedlplay(false);
			player.setSpeedlisPlayed(false);
			player.setStartisPlayed(true);
		}
		if (player.Pile.get(k).getName() == "PUNCTURE_OF_PROOF") {
			player.setFlattirePlay(false);
			player.setFlattireisPlayed(false);
		}
		if (player.Pile.get(k).getName() == "EXTRA_TANK") {
			player.setOutofgasPlay(false);
			player.setOutofgasisPlayed(false);
		}

	}
/**
 * when a hazard card is played moves some booleans change 
 * @param player
 * @param k
 * @return 1 if the card can be played or 0 for error message
 */
	int Hazard(Player player, int k) {
		if (seira == 2) {// kanonika pezei o 1 apla kathe fore pou pezetai to
							// deck allazei seira dn ein h pragmatikh seira
							// ti ein to elligible ? prp na valw stop kai kala
							// oti thelei pali roll
			if (p2.isStartisPlayed() == true || p2.isRightofway() == true) {
				if (player.Pile.get(k).getName() == "FLAT_TIRE") {
					if (p2.isFlattirePlay() == true) {
						p2.setFlattireisPlayed(true);
						p2.setStartisPlayed(false);
						p2.setProblem(true);
						return 1;
					}
				} else if (player.Pile.get(k).getName() == "ACCIDENT") {
					if (p2.isAccidentPlay() == true) {
						p2.setAccidentsisPlayed(true);
						p2.setStartisPlayed(false);
						p2.setProblem(true);return 1;
					}
				} else if (player.Pile.get(k).getName() == "OUT_OF_GAS") {
					if (p2.isOutofgasPlay() == true) {
						p2.setOutofgasisPlayed(true);
						p2.setStartisPlayed(false);
						p2.setProblem(true);return 1;}
				} else if (player.Pile.get(k).getName() == "STOP") {
					if (p2.isStopplay() == true) {
						p2.setStopisPlayed(true);
						p2.setStartisPlayed(false);
						p2.setProblem(true);
						return 1;}
				} else if (player.Pile.get(k).getName() == "SPEED_LIMIT") {
					p2.setSpeedlisPlayed(true);
					p2.setStartisPlayed(false);
					p2.setProblem(true);
					p2.setSpeedlisPlayed(true);
					p2.setStartisPlayed(false);
					p2.setProblem(true);													
					return 1;										
				
				} else {
					return 2;
				}
			}
		}
		if (seira == 1) {
			if (p1.isStartisPlayed() == true || p1.isRightofway() == true) {
				if (player.Pile.get(k).getName() == "FLAT_TIRE") {
					if (p1.isFlattirePlay() == true) {
						p1.setFlattireisPlayed(true);
						p1.setStartisPlayed(false);
						p1.setProblem(true);return 1;}
				} else if (player.Pile.get(k).getName() == "ACCIDENT") {
					if (p1.isAccidentPlay() == true) {
						p1.setAccidentsisPlayed(true);
						p1.setStartisPlayed(false);
						p1.setProblem(true);return 1;}
				} else if (player.Pile.get(k).getName() == "OUT_OF_GAS") {
					if (p1.isOutofgasPlay() == true) {
						p1.setOutofgasisPlayed(true);
						p1.setStartisPlayed(false);
						p1.setProblem(true);
						return 1;}
				} else if (player.Pile.get(k).getName() == "STOP") {
					if (p1.isStopplay() == true) {
						p1.setStopisPlayed(true);
						p1.setStartisPlayed(false);
						p1.setProblem(true);
						return 1;}
				} else if (player.Pile.get(k).getName() == "SPEED_LIMIT") {
					if (p1.isSpeedlplay() == true) {
						p1.setSpeedlisPlayed(true);
						p1.setStartisPlayed(false);
						p1.setProblem(true);
						return 1;}
				} else {
					return 2;
				}
			}
		}
		return 2;
	}//anti gia seira ena kai seira 2 svhnw kai vazw opou p1 k p2 pl
	/**
	 * when a distance card is pressed if it can played some booleans change
	 * @param p
	 * @param points
	 * @return 1 if the card can be played and 2 to enable an erro message
	 */

	int Distance(Player p, int points) {
		int status;
		if(p.isAccidentsisPlayed() ||p.isFlattireisPlayed() ||
				p.isOutofgasisPlayed() ||p.isStopisPlayed()){return 2;}else{
		if (p.isStartisPlayed() == true || p.isRightofway() == true) {if(points==0){return 2;}
			if(points==200){int temp=p.getLimit200();temp++;p.setLimit200(temp);}
			  if(p.isSpeedlisPlayed() == true){if (points>50){return 2;}}

			if ((p.PointSum + points) < 1000) {
				p.PointSum += points;
				status = 0;
			} else if ((p.PointSum + points) == 1000) {
				status = 1;
				winner = p;
			} else {
				status = 2;
			}
			return status;

		} else {
			return 2;
		}}
	}

	/**When Remedy cards are pressed this function checks if they can be played and change some
	 * booleans
	 * @param player
	 * @param k
	 */
	int Remedy(Player player, int k) {
		int status = 0;
		if((player.isStopisPlayed()||player.isSpeedlisPlayed()) && player.Pile.get(k).getName() == "ROLL" ){player.setStartisPlayed(true);
		player.setStopisPlayed(false);
		status = 1;player.setProblem(true);}
		if (player.isProblem()==false && player.Pile.get(k).getName() == "ROLL" ) {
			player.setStartisPlayed(true);
			player.setStopisPlayed(false);
			status = 1;
		}
		if (player.isFlattireisPlayed() == true
				&& player.Pile.get(k).getName() == "SPARE_TIRE") {
			player.setFlattireisPlayed(false);
			status = 1;
			player.setProblem(false);
		}
		if (player.isOutofgasisPlayed()
				&& player.Pile.get(k).getName() == "GASOLINE") {
			player.setOutofgasisPlayed(false);
			status = 1;
			player.setProblem(false);
		}
		if (player.isSpeedlisPlayed()
				&& player.Pile.get(k).getName() == "END_OF_LIMIT") {
			player.setSpeedlisPlayed(false);
			status = 1;
			player.setProblem(false);
		}
		if (player.isAccidentsisPlayed()
				&& player.Pile.get(k).getName() == "REPAIRS") {
			player.setAccidentsisPlayed(false);
			status = 1;
			player.setProblem(false);
		}
		return status;
	}

	/**
	 * getting the points from the name of the card
	 * @param c
	 * pre:the card must be a distance one
	 * @return points of the card given
	 */
	

	int points(Card c) {
		if (c.getName() == "MILES_50")
			{return 50;}
		else if (c.getName() == "MILES_100")
			{return 100;}
		else if (c.getName() == "MILES_75")
			{return 75;}
		else if (c.getName() == "MILES_200"){
			return 200;}
		
		
		else{
			return 25;}
		
	}

	
}
