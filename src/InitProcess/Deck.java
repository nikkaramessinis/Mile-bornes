package InitProcess;

import java.util.ArrayList;
import java.util.Collections;

import CardTypes.Card;
import CardTypes.Distance;
import CardTypes.Hazard;
import CardTypes.Remedy;
import CardTypes.Safety;

/**
 * 
 * @author Nick Karamessinis an instance of a Deck makes a starting pile and
 *         shuffles this pile
 */
public class Deck {
	ArrayList<Card> Deck = new ArrayList<Card>(106);

	/**
	 * @param pl1
	 * @param pl2
	 */
	Deck(Player pl1, Player pl2) {
		Safety p6 = new Safety("DRIVING_ACE");
		Safety p7 = new Safety("RIGHT_OF_WAY");
		Safety p8 = new Safety("PUNCTURE_PROOF");
		Safety p9 = new Safety("EXTRA_TANK");
		Deck.add(p6);
		Deck.add(p7);
		Deck.add(p8);
		Deck.add(p9);
		for (int i = 0; i < 10; i++) {
			Distance p1 = new Distance("MILES_25");
			Distance p2 = new Distance("MILES_50");
			Distance p3 = new Distance("MILES_75");
			Deck.add(p1);
			Deck.add(p2);
			Deck.add(p3);
		}
		for (int i = 0; i < 12; i++) {
			Distance p4 = new Distance("MILES_100");
			Deck.add(p4);

		}
		for (int i = 0; i < 4; i++) {
			Distance p5 = new Distance("MILES_200");
			Hazard p14 = new Hazard("SPEED_LIMIT");
			Deck.add(p5);
			Deck.add(p14);
		}
		for (int i = 0; i < 3; i++) {
			Hazard p10 = new Hazard("FLAT_TIRE");
			Hazard p11 = new Hazard("OUT_OF_GAS");
			Hazard p12 = new Hazard("ACCIDENT");
			Deck.add(p10);
			Deck.add(p11);
			Deck.add(p12);
		}
		for (int i = 0; i < 5; i++) {
			Hazard p13 = new Hazard("STOP");
			Deck.add(p13);
		}
		for (int i = 0; i < 6; i++) {
			Remedy p15 = new Remedy("REPAIR");
			Remedy p16 = new Remedy("SPARE_TIRE");
			Remedy p17 = new Remedy("GASOLINE");
			Deck.add(p16);
			Deck.add(p17);
			Deck.add(p15);

		}
		for (int i = 0; i < 14; i++) {
			Remedy p18 = new Remedy("ROLL");
			Deck.add(p18);
		}
		Collections.shuffle(Deck);
		System.out.println(Deck);
		int k = 0;
		int i = 0;
		/**
		 * Gives 6 cards to each player
		 */
		while (k < 6) {
			pl1.Pile.add(Deck.get(i));
			Deck.remove(Deck.get(i));
			k++;
		}
		k = 0;
		while (k < 6) {
			pl2.Pile.add(Deck.get(i));
			Deck.remove(Deck.get(i));
			k++;
		}
		
	}
}
