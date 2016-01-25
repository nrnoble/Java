package edu.greenriver.it.cards;
//12345678901234567890123456789012345678901234567890123456789012345678901234567890

public class BlackJackCard extends PlayingCard
{
	

	public BlackJackCard(int _color, int _width, int _height, Suit _suit, Rank _rank ) 
	{
		super(_color, _width, _height);
		this.rank = _rank;
		this.suit = _suit;
	}

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

	
	public int getValue() 
	{
		return cardValue;
	}
	
	public Rank getRank() 
	{
		return rank;
	}
	public void setRank(Rank rank) 
	{
		this.rank = rank;
	}
	
	public Suit getSuit() 
	{
		return suit;
	}
	
	public void setSuit(Suit suit) 
	{
		this.suit = suit;
	}


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


