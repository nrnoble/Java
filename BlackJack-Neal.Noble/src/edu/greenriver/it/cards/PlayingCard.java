package edu.greenriver.it.cards;

//12345678901234567890123456789012345678901234567890123456789012345678901234567890
/*1. Create a class called PlayingCard that stores some basic features of playing 
   cards. Your class should have the following:
•	Fields: color, width, height
•	Constructors: a parameterized constructor (no default constructor allowed)
•	Getters and setters for each field
•	An appropriate toString() method
*/

/**
 * A single card in a deck of cards
 * @author Neal Noble
 *
 */
public class PlayingCard 
{
	
	//Fields: color, width, height
	
    private  int color;  
    private  int width; 
    private  int height;
    public CardVisibility visibility;
    
    /**
     * 
     * @param _color is the color of card
     * @param _width is the width in cm
     * @param _height is the height in cm
     */
    public PlayingCard (int _color, int _width, int _height)
    {
    	this.color 	= _color;
    	this.width 	= _width;
    	this.height = _height;
    	this.visibility = CardVisibility.FACE_DOWN;
    	
    }
    
    /**
     * 
     * @return card color
     */
    public int getColor()
    {
    	return this.color;
    }
    
    /**
     * 
     * @return width
     */
    public int getWidth()
    {
    	return this.width;
    }

    /**
     * 
     * @return card height
     */
    public int getHeight()
    {
    	return this.height;
    }
    
    /**
     * 
     * @param _color sets the color of card
     */
    public void setColor(int _color)
    {
    	 this.color = _color; 
    }
    
    /**
     * 
     * @param _width sets card width in cm
     */
    public void setWidth(int _width)
    {
    	this.width = _width;
    }

    /**
     * 
     * @param _height sets height in cm
     */
    public void setHeight(int _height)
    {
    	this.height = _height;
    }

    /*
     * @return the height & width of card in cm
     */
    public String toString()
    {
    	String str = "height: " + this.height + "\n\r" +
    				 "width: " + this.width;
    	return str;
    }

}

