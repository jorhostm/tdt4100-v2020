package interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import app.App;

public class Card implements Comparable<Card>{

	private char suit;
	private int face;

	public Card(char suit, int face) {
		if(!(suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C')) throw new IllegalArgumentException("Invalid suit: "+suit);
		if(face < 1 || face > 13) throw new IllegalArgumentException("Invalid face: "+face);
		this.suit = suit;
		this.face = face;
	}

	public char getSuit() {
		return suit;
	}

	public int getFace() {
		return face;
	}

	public String toString() {
		return  Character.toString(suit) + Integer.toString(face);
	}

	@Override
	public int compareTo(Card o) {
		int suit1 = 0;
		int suit2 = 0;
		char[] suits = {'C','D','H','S'};
		for(int i = 0; i<suits.length;i++) {
			if(suit == suits[i]) 
				suit1 = i;
			if(o.getSuit() == suits[i])
				suit2 = i;
		}
		if(suit1==suit2) 
			return face-o.getFace();
		return suit1-suit2;
	}
	public static void main(String[] args) {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card('S', 1));
		cards.add(new Card('S', 6));
		cards.add(new Card('D', 8));
		cards.add(new Card('H', 5));
		cards.add(new Card('C', 5));
		cards.add(new Card('D', 13));
		cards.add(new Card('C', 4));
		Collections.sort(cards);
		for(Card c : cards)
			System.out.println(c);
		
	}
}
