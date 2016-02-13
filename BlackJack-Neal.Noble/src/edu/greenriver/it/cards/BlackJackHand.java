package edu.greenriver.it.cards;

/**
 * Defines a BlackJack Hand
 * @author Neal Noble
 *
 */
public class BlackJackHand extends Hand
{

	public BlackJackHand(String _playerName)
	{
		super(_playerName);
	}
	
	@Override
	protected void calculateHandValue()
	{

	}

	@Override
	public void removeCard(BlackJackCard card)
	{
		
		
	}

	/**
	 * Displays cards with with their current visibility settings per card 
	 */
	@Override
	public void displayCards()
	{
		displayCards(CardVisibility.CURRENT_VISIBLITY);

	}
	
	/**
	 * This allows the visibility for entire hand to be changed
	 * such as flipping over all cards face up so that everyone can see 
	 * the cards.
	 * @param _visiablity Enum CardVisibility
	 */
	public void displayCards(CardVisibility _visiablity)
	{
		for (BlackJackCard card: this.cards)
		{
			if (_visiablity == CardVisibility.EVERYONE)
			{
				card.visibility = CardVisibility.EVERYONE;
			}
			
			System.out.println(this.playerName + " " + card.toString());
		}
	}
	
	/**
	 *  Displays in console the total value of the combined cards in hand
	 */
	@Override
	public void displayHandValue()
	{
		System.out.println(this.playerName + " Total: " + this.getHandValue());
		
	}
	
}
