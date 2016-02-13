package edu.greenriver.it.cards;
//12345678901234567890123456789012345678901234567890123456789012345678901234567890

/**
 * 
 * @author Neal Noble
 *
 */
public class BlackJackCard extends PlayingCard
{
	
	/**
	 * 
	 * @param _suit is either Diamonds, Clubs, Spades, Hearts
	 * @param _rank is Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	 */
	public BlackJackCard(Suit _suit, Rank _rank ) 
	{

		super(0, 0, 0);
		this.rank = _rank;
		this.suit = _suit;
		
		if (this.rank == Rank.Ace)
		{
			cardValue = 1;
		}
		else
		if (this.rank == Rank.Ten || this.rank == Rank.Jack || this.rank == Rank.Queen || this.rank == Rank.King)
		{
			this.cardValue  = 10;
		}
		else
		{
			this.cardValue = rank.ordinal()+1;
		}
		
		
		// this is broken and currently not used. Each card should have a
		// unique value between 1-52 or 0-51
		//this.cardNumber = (_suit.ordinal()*13) + (_rank.ordinal() +1);

	}

	private Suit suit;
	private Rank rank;
	public int cardNumber;
	public int cardValue;

	/**
	 * 
	 * @return the value of card
	 */
	public int getValue() 
	{
		return cardValue;
	}
	
	/**
	 * 
	 * @return the rank of card
	 */
	public Rank getRank() 
	{
		return rank;
	}
	
	/**
	 * 
	 * @param rank is enum Rank
	 */
	public void setRank(Rank rank) 
	{
		this.rank = rank;
	}
	
	/**
	 * 
	 * @return the suit of card
	 */
	public Suit getSuit() 
	{
		return suit;
	}
	
	/**
	 * 
	 * @param suit enum Suit
	 */
	public void setSuit(Suit suit) 
	{
		this.suit = suit;
	}

	/**
	 * returns card Suit, Rank, and card visibility
	 */
	@Override
	public String toString() 
	{
		if (this.visibility == CardVisibility.EVERYONE)
			return "Card [" + rank + " of " + suit + "]";
		if (this.visibility == CardVisibility.FACE_DOWN)
			return "Card [Face down]";
		return "Card [" + rank + " of " + suit + "]";
	}
	
}


