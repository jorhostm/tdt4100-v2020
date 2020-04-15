package encapsulation;

public class Card {
	
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

	public static void main(String[] args) {
		Card c = new Card('D',1);
		System.out.println(c);
	}

}
