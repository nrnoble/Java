package edu.greenriver.it.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for creating a hand of cards in any card game
 * @author Neal
 *
 */
public abstract class Hand
{
	public List <BlackJackCard> cards = new ArrayList<BlackJackCard>();
	public int handValue = 0;
	public String playerName = "";
	
	 public Hand(String _playerName)
	 {
		 playerName = _playerName;
	 }
	
	 public void addCard(BlackJackCard _card)
	 {
		 cards.add(_card);
		 handValue += _card.cardValue;
		 
		 
	 }
	 /*
	  * remove the card from hand or deck. 
	  */
	 public abstract void removeCard(BlackJackCard card);
	 /**
	  * calculate the current value of all the cards in the current hand
	  */
	 protected abstract void calculateHandValue();
	 /**
	  * Displays the cards one at time. Some cards maybe face down,
	  * other cards may be showing the Suit and Rank
	  */
	 protected abstract void displayCards();
	 protected abstract void displayHandValue();
	 
	/**
	 * 
	 * @return the total value of the cards currently in hand
	 */
	public int getHandValue()
	{
		//calculateHandValue();
		return handValue;
	}


}
