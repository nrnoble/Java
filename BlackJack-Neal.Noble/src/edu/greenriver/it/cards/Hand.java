package edu.greenriver.it.cards;

import java.util.ArrayList;
import java.util.List;

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
	 public abstract void removeCard(BlackJackCard card);
	 protected abstract void calculateHandValue();
	 protected abstract void displayCards();
	 protected abstract void displayHandValue();
	 
	public int getHandValue()
	{
		//calculateHandValue();
		return handValue;
	}


}
