package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

	private List<Card> deck = new ArrayList<>();

	public CardDeck(int n) {
		if(n < 0 || n > 13) throw new IllegalArgumentException("Invalid number of cards: "+n);
		char[] suits = {'S','H','D','C'};
		
		for(char c : suits) {
			
			for(int j = 1; j <= n; j++) {
				
				deck.add(new Card(c, j));
				System.out.println(deck.get(deck.size() - 1).toString());
			}
			System.out.println("//");
		}
	}

	public int getCardCount() {
		
		return deck.size();
	}

	public Card getCard(int n) {
		if(n < 0 || n > deck.size()-1) throw new IllegalArgumentException("Invalid index: "+n);
		return deck.get(n);
	}
	
	public void shufflePerfectly() {
		List<Card> tmp = new ArrayList<>(deck);
		int inc = 0;
		for(int i = 0; i < tmp.size(); i+=2) {
			System.out.println("Adding "+tmp.get(inc)+ " to index "+i);
			deck.set(i, tmp.get(inc));
			inc++;
		}
		for(int i = 1; i < tmp.size(); i+=2) {
			System.out.println("Adding "+tmp.get(inc)+ " to index "+i);
			deck.set(i, tmp.get(inc));
			inc++;
		}
	}

	public static void main(String[] args) {
		CardDeck deck = new CardDeck(2);
		System.out.println("Number of Cards: "+deck.getCardCount());
		deck.shufflePerfectly();
		for(int i = 0; i < deck.getCardCount(); i++) {
			System.out.println(deck.getCard(i));
		}
	}

}
