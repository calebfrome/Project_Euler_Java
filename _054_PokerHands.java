import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class _054_PokerHands {
	
	static Player player1 = new Player();
	static Player player2 = new Player();
	static sortType sort;
	
	public static void main(String[] args) throws FileNotFoundException {
		int p1Wins = 0;
		Scanner file = new Scanner(new File("file_054.txt"));
		String hands;
		
		for(int hand = 0; hand<1000; hand++) {
			hands = file.nextLine();
			player1.setHand(hands.substring(0,14).split(" "));
			player2.setHand(hands.substring(15).split(" "));
			if(p1WinsHand())
				p1Wins++;
		}
		System.out.println("Player 1 won " + p1Wins + " hands.");
		file.close();
	}
	
	public static boolean p1WinsHand() {
		if(player1._ht.ordinal() > player2._ht.ordinal()) {
			return true;
		}
		if(player1._ht.ordinal() < player2._ht.ordinal()) {
			return false;
		}
		
		//At this point, hands are sorted by used, then by rank
		//If the two players have identical hand types, just compare from the 0th card on down.
		int nth_card = 0;
		int rank1 = 0;
		int rank2 = 0;
		do {
			rank1 = player1.getUnusedCardRank(nth_card);
			rank2 = player2.getUnusedCardRank(nth_card++);
		} while(rank1 == rank2);
		return rank1 > rank2;		
	}
	
	public static void setSortType(sortType st) {
		sort = st;
	}
	
	public static sortType getSortType() {
		return sort;
	}
}

class Player {
	
	int[] unusedCards = {4,3,1,2,0,0,0,1,0,0};
	Card[] _hand;
	handType _ht;
	
	public Player() {
		_hand = new Card[5];
		_ht = handType.HighCard;
	}
	
	void setHand(String[] hand) {
		for(int i=0; i<5; i++) {
			_hand[i] = new Card(hand[i].substring(0, 1), hand[i].substring(1, 2));
			_hand[i].setUsed(false);
		}
		calcHandType();
	}
	
	
	void calcHandType() {
		sortHand(sortType.Rank);
		int highRank = _hand[4].getRank();
		if((_hand[0].getSuit() == "S" &&
		    _hand[1].getSuit() == "S" &&
		    _hand[2].getSuit() == "S" &&
		    _hand[3].getSuit() == "S" &&
		    _hand[4].getSuit() == "S") ||
			(_hand[0].getSuit() == "D" &&
		    _hand[1].getSuit() == "D" &&
		    _hand[2].getSuit() == "D" &&
		    _hand[3].getSuit() == "D" &&
		    _hand[4].getSuit() == "D") ||
			(_hand[0].getSuit() == "C" &&
		    _hand[1].getSuit() == "C" &&
		    _hand[2].getSuit() == "C" &&
		    _hand[3].getSuit() == "C" &&
		    _hand[4].getSuit() == "C") ||
			(_hand[0].getSuit() == "H" &&
		    _hand[1].getSuit() == "H" &&
		    _hand[2].getSuit() == "H" &&
		    _hand[3].getSuit() == "H" &&
		    _hand[4].getSuit() == "H")) {
			
			if(_hand[3].getRank() == highRank-1 &&
				_hand[2].getRank() == highRank-2 &&
				_hand[1].getRank() == highRank-3 &&
				_hand[0].getRank() == highRank-4) {
				if(highRank == 14) {
					_ht = handType.RoyalFlush;
				}
				else _ht = handType.StraightFlush;
			}
			else {
				_ht = handType.Flush;
			}
			for(Card c: _hand) {
				c.setUsed(true);
			}
		}
		else if(_hand[0].getRank() == _hand[3].getRank()) {
			_ht = handType.FourOfAKind;
			for(int c=0; c<=3; c++) {
				_hand[c].setUsed(true);
			}
		}
		else if (_hand[1].getRank() == _hand[4].getRank()) {
			_ht = handType.FourOfAKind;
			for(int c=1; c<=4; c++) {
				_hand[c].setUsed(true);
			}
		}
		else if((_hand[0].getRank() == _hand[1].getRank()) && (_hand[2].getRank() == _hand[4].getRank())) {
			_ht = handType.FullHouse;
			for(Card c: _hand) {
				c.setUsed(true);
			}
		}
		else if((_hand[3].getRank() == highRank-1 &&
				_hand[2].getRank() == highRank-2 &&
				_hand[1].getRank() == highRank-3 &&
				_hand[0].getRank() == highRank-4) ||
				(_hand[0].getRank() == 14 &&
				_hand[1].getRank() == 2 &&
				_hand[2].getRank() == 3 &&
				_hand[3].getRank() == 4 &&
				_hand[4].getRank() == 5)) {
			_ht = handType.Straight;
			for(Card c: _hand) {
				c.setUsed(true);
			}
		}
		else if((_hand[0].getRank() == _hand[1].getRank()) && (_hand[1].getRank() == _hand[2].getRank())) {
			_ht = handType.ThreeOfAKind;
			for(int i=0; i<=2; i++) {
				_hand[i].setUsed(true);
			}
		}
		else if((_hand[1].getRank() == _hand[2].getRank()) && (_hand[2].getRank() == _hand[3].getRank())) {
			_ht = handType.ThreeOfAKind;
			for(int i=1; i<=3; i++) {
				_hand[i].setUsed(true);
			}
		}
		else if((_hand[2].getRank() == _hand[3].getRank()) && (_hand[3].getRank() == _hand[4].getRank())) {
			_ht = handType.ThreeOfAKind;
			for(int i=2; i<=4; i++) {
				_hand[i].setUsed(true);
			}
		}
		else if((_hand[0].getRank() == _hand[1].getRank()) && (_hand[2].getRank() == _hand[3].getRank())) {
			_ht = handType.TwoPair;
			for(int i=0; i<=3; i++) {
				_hand[i].setUsed(true);
			}
		}
		else if((_hand[0].getRank() == _hand[1].getRank()) && (_hand[3].getRank() == _hand[4].getRank())) {
			_ht = handType.TwoPair;
			for(Card c: _hand) {
				c.setUsed(true);
			}
			_hand[2].setUsed(false);
		}
		else if((_hand[1].getRank() == _hand[2].getRank()) && (_hand[3].getRank() == _hand[4].getRank())) {
			_ht = handType.TwoPair;
			for(int i=1; i<=4; i++) {
				_hand[i].setUsed(true);
			}
		}
		else if(_hand[0].getRank() == _hand[1].getRank()) {
			_ht = handType.Pair;
			_hand[0].setUsed(true);
			_hand[1].setUsed(true);
		}
		else if(_hand[1].getRank() == _hand[2].getRank()) {
			_ht = handType.Pair;
			_hand[1].setUsed(true);
			_hand[2].setUsed(true);
		}
		else if(_hand[2].getRank() == _hand[3].getRank()) {
			_ht = handType.Pair;
			_hand[2].setUsed(true);
			_hand[3].setUsed(true);
		}
		else if(_hand[3].getRank() == _hand[4].getRank()) {
			_ht = handType.Pair;
			_hand[3].setUsed(true);
			_hand[4].setUsed(true);
		}
		else {
			_ht = handType.HighCard;
			_hand[4].setUsed(true);
		}		
		//must sort hand with used cards at the front
		sortHand(sortType.RankInv);
		sortHand(sortType.Used);
	}
	
	//get the nth-highest card not used in the highest hand type
	int getUnusedCardRank(int n) {
		return _hand[_ht.ordinal() + n].getRank();
	}
	
	void sortHand(sortType sort) {
		_54_PokerHands.setSortType(sort);
		Arrays.sort(_hand);
	}
}

class Card implements Comparable<Card> {
	
	int _rank;
	String _suit;
	boolean _used;
	
	public Card(int rank, String suit) {
		_rank = rank;
		_suit = suit;
	}
	
	public Card(String rank, String suit) {
		_suit = suit;
		switch(rank) {
		case "A":
			_rank = 14;
			break;
		case "K":
			_rank = 13;
			break;
		case "Q":
			_rank = 12;
			break;
		case "J":
			_rank = 11;
			break;
		case "T":
			_rank = 10;
			break;
		default:
			_rank = Integer.valueOf(rank);
			break;
		}
	}
	
	Integer getRank() {
		return _rank;
	}
	
	String getSuit() {
		return _suit;
	}
	
	void setUsed(boolean used) {
		_used = used;
	}
	
	Boolean isUsed() {
		return _used;
	}
	
	@Override
	public int compareTo(Card c) {
		if(_54_PokerHands.getSortType() == sortType.Rank)
			return getRank().compareTo(c.getRank());
		if(_54_PokerHands.getSortType() == sortType.RankInv)
			return -1*getRank().compareTo(c.getRank());
		if(_54_PokerHands.getSortType() == sortType.Suit)
			return getSuit().compareTo(c.getSuit());
		if(_54_PokerHands.getSortType() == sortType.Used)
			return c.isUsed().compareTo(isUsed());
		//will never get here
		return 0;
	}
}

enum handType {
	HighCard,
	Pair,
	TwoPair,
	ThreeOfAKind,
	Straight,
	Flush,
	FullHouse,
	FourOfAKind,
	StraightFlush,
	RoyalFlush
};

enum sortType {
	Rank,
	RankInv,
	Suit,
	Used
}
