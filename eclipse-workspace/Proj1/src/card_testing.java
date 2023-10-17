public class card_testing {
	public static void main(String[] args){
		Card c = new Card(1,1);
		Card c2 = new Card(12,c.getSuit());
		System.out.println(c2);
		Deck deck = new Deck();
		
		System.out.println(deck);
		System.out.println(deck.getLen());
		System.out.println(deck.removeTop());
		System.out.println(deck);
		deck.addToTop(c);
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
	}
	   }
