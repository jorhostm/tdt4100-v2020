package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CardDeck {

	private List<Card> deck = new ArrayList<>();

	public CardDeck(int n) {
		if(n < 0 || n > 13) throw new IllegalArgumentException("Invalid number of cards: "+n);
		char[] suits = {'S','H','D','C'};
		
		for(char c : suits) {
			
			for(int j = 1; j <= n; j++) {
				
				deck.add(new Card(c, j));
			}
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
			deck.set(i, tmp.get(inc));
			inc++;
		}
		for(int i = 1; i < tmp.size(); i+=2) {
			deck.set(i, tmp.get(inc));
			inc++;
		}
	}

	public static void main(String[] args) {
		CardDeck deck = new CardDeck(13);
		System.out.println(deck.hasCard(c -> c.getSuit()=='S' && c.getFace() == 12));
		System.out.println(deck.getCardCount(c -> c.getSuit() == 'H'));
		System.out.println(deck.getCards(c -> c.getFace()== 1));

	}

	public boolean hasCard(Predicate<Card> p) {
		return deck.stream().anyMatch(p);
	}

	public int getCardCount(Predicate<Card> p ) {
		return deck.stream().filter(p).collect(Collectors.toList()).size();
	}

	public List<Card> getCards(Predicate<Card> p) {
		return deck.stream().filter(p).collect(Collectors.toList());
	}

}
