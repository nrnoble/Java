package edu.greenriver.it.gametest;


import edu.greenriver.it.Utilities.Constants;
import edu.greenriver.it.Utilities.KeyPress;
import edu.greenriver.it.cardgame.BlackjackGame;

/**
 * 
 * @author Neal Noble
 *
 */
public class CardGameTest 
{

	/**
	 *  Start executing card game
	 * @param args not implemented
	 */
	
	public static void main (String args[])
	{

		char keepPlaying = Constants.Y;
		//Initialize Blackjack game
		BlackjackGame blackJack = new BlackjackGame(Constants.GAME_NAME,Constants.WELCOME_MESSSAGE);
		
		
		// Keep looping through more rounds until the player 
		// decides to quit.
		while (keepPlaying == Constants.Y)
		{
			blackJack.playRound();
			
			System.out.println(Constants.DIVIDER);
			
			// prompt user to keep playing
			keepPlaying = KeyPress.myGetKeyHack(Constants.PLAY_ANOTHER_GAME, Constants.Y);
		}
		
		System.out.println(Constants.THANK_YOU);
		
		
	}
	
	
}
