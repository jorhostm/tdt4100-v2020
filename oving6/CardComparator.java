package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardComparator implements Comparator<Card> {
	boolean aceHighest;
	char triumphSuit;
	
	public CardComparator(boolean aceHighest, char triumphSuit) {
		this.aceHighest = aceHighest;
		this.triumphSuit = triumphSuit;
	}

	@Override
	public int compare(Card c1, Card c2) {
		int face1 = (aceHighest && c1.getFace() == 1 ) ? 14 : c1.getFace();
		int face2 = (aceHighest && c2.getFace() == 1 ) ? 14 : c2.getFace();
		int suit1 = 0;
		int suit2 = 0;
		char[] suits = {'C','D','H','S',triumphSuit};
		for(int i = 0; i<suits.length;i++) {
			if(c1.getSuit() == suits[i]) 
				suit1 = i;
			if(c2.getSuit() == suits[i])
				suit2 = i;
		}
		if(suit1==suit2) 
			return face1-face2;
		return suit1-suit2;
	}
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card('S', 1));
		cards.add(new Card('S', 6));
		cards.add(new Card('D', 1));
		cards.add(new Card('H', 5));
		cards.add(new Card('C', 5));
		cards.add(new Card('D', 13));
		cards.add(new Card('C', 4));
		Collections.sort(cards, new CardComparator(false,' '));
		for(Card c : cards)
			System.out.println(c);
		
	}
}
