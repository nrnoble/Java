import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;


//import java.awt.*;
//import java.awt.event.*;
import java.awt.image.*;
//import java.io.*;
//import javax.imageio.*;
//import javax.swing.*;

public class ImageTest 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ImageFrame frame = new ImageFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


            }
        }
        );
    }
}


class CardSubImageMap
{	
	public CardSubImageMap(int _x, int _y, int _width, int _height, Rank _rank) 
	{
		super();
		this.x = _x;
		this.y = _y;
		this.width = _width;
		this.height = _height;
		this.rank = _rank;
	}
	
		public int x;
		public int y;
		public int width;
		public int height;
		public Rank rank;	
}



// Base class for CardImage
// Extracts the sub image from the larger image container
class SubImage
{
    public int x, y, height, width;
    private BufferedImage imageContainer;
    private Image subImage;
    public SubImage(BufferedImage _imageContainer, int _xpointOfSubImage, 
    				int _ypointOfSubImage, int _width, int _height) 
    {
        this.x = _xpointOfSubImage;
        this.y = _ypointOfSubImage;
        this.height = _height;
        this.height = _width;
        this.imageContainer = _imageContainer;
        this.subImage = _imageContainer.getSubimage(_xpointOfSubImage, _ypointOfSubImage, 
        											_width, _height);
     }
    
    public Image getSubImage()
    {	
    	if (this.subImage != null)
    			return this.subImage;
    	else
    	{
    		this.subImage = imageContainer.getSubimage(this.x, this.y, this.width, this.height);
    		return this.subImage;
    	}
    }
    
}

class CardImage extends SubImage
{
	Suit suit;
	Rank rank;
	
	
	
	public CardImage(BufferedImage _imageContainer, int _x, int _y, 
					 Rank _rank, Suit _suit) 
	{
		super(_imageContainer, _x, _y, 180, 250);
		this.suit = _suit;
		this.rank = _rank;
	}	
	
	public CardImage(BufferedImage _imageContainer, CardSubImageMap _imageMap, Suit _suit) 
	{
		super(_imageContainer, _imageMap.x , _imageMap.y, _imageMap.width, _imageMap.height);
		this.suit = _suit;
		this.rank = _imageMap.rank;
	}
	}



class ImageFrame extends JFrame
{
    public ImageFrame()
    {
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ImageComponent component = new ImageComponent();
        add(component);

    }

    public static final int DEFAULT_WIDTH = 435;
    public static final int DEFAULT_HEIGHT = 440;
}





class ImageComponent extends JComponent
{

    private static final long serialVersionUID = 1L;
    private Image image;

    
    
    ArrayList<CardSubImageMap> cardImagesMapping = new ArrayList<CardSubImageMap>();
    
    private static BufferedImage clubsImageContainer;
    private static BufferedImage spadesImageContainer;
    private static BufferedImage heartsImageContainer;
    private static BufferedImage diamondsImageContainer;
    
    
    private static ArrayList<CardSubImageMap> suitImageMap ()
    {
    	ArrayList<CardSubImageMap> suitImages = new ArrayList<CardSubImageMap>();
      
    	
    	suitImages.add(new CardSubImageMap(0,0,180,250,Rank.Ace));
    	suitImages.add(new CardSubImageMap(203,0,180,250,Rank.Two));
    	suitImages.add(new CardSubImageMap(407,0,180,250,Rank.Three));
    	suitImages.add(new CardSubImageMap(610,0,180,250,Rank.Four));
    	suitImages.add(new CardSubImageMap(813,0,180,250,Rank.Five));
    	suitImages.add(new CardSubImageMap(0,266,180,251,Rank.Six));
    	suitImages.add(new CardSubImageMap(204,266,180,251,Rank.Seven));
    	suitImages.add(new CardSubImageMap(407,266,180,251,Rank.Eight));
    	suitImages.add(new CardSubImageMap(610,266,180,251,Rank.Nine));
    	suitImages.add(new CardSubImageMap(813,266,180,251,Rank.Ten));
    	suitImages.add(new CardSubImageMap(0,533,180,250,Rank.Jack));
    	suitImages.add(new CardSubImageMap(203,533,180,250,Rank.Queen));
    	suitImages.add(new CardSubImageMap(407,533,180,250,Rank.King));
    	suitImages.add(new CardSubImageMap(610,533,180,250,Rank.Joker));
    	suitImages.add(new CardSubImageMap(813,533,180,250,Rank.Back));
        
    	
    	return suitImages;
    }
    
    
    public ImageComponent()
    {
   	 	
        try
        {
        	
        	  clubsImageContainer = ImageIO.read(new File("clubs.jpg"));   
        	  spadesImageContainer = ImageIO.read(new File("spades.jpg"));  
        	  heartsImageContainer = ImageIO.read(new File("hearts.jpg"));  
        	  diamondsImageContainer = ImageIO.read(new File("diamonds.jpg"));  
        	  
        	  cardImagesMapping = suitImageMap();        
       }
	   catch (IOException e)
	   {
		   	  e.printStackTrace();
	   }
    }
    @SuppressWarnings("static-access")
	public void paintComponent (Graphics g)
    {
    	int y = 3;
    	int ystep = 100/4;

    	for (CardSubImageMap map : cardImagesMapping)
    	{
    		CardImage card  = new CardImage(clubsImageContainer,map, Suit.Clubs); 
	    	image = card.getSubImage();
	        if(image == null) return;
	        int imageWidth = image.getWidth(this)/3;
	        int imageHeight = image.getHeight(this)/3;
	        image = image.getScaledInstance(imageWidth, imageHeight, image.SCALE_AREA_AVERAGING);
	        g.drawImage(image, y, 0, this);
	        repaint();
//	        try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	        

	        y += ystep;
	        
	   	}
    	
    	y = 3;

    	
    	for (CardSubImageMap map : cardImagesMapping)
    	{
    		CardImage card  = new CardImage(diamondsImageContainer,map, Suit.Dimonds); 
	    	image = card.getSubImage();
	        if(image == null) return;
	        int imageWidth = image.getWidth(this)/3;
	        int imageHeight = image.getHeight(this)/3;
	        image = image.getScaledInstance(imageWidth, imageHeight, image.SCALE_AREA_AVERAGING);
	        g.drawImage(image, y, 100, this);
	        y += ystep;
	        
	   	}
    	
    	y = 3;
    	for (CardSubImageMap map : cardImagesMapping)
    	{
    		CardImage card  = new CardImage(heartsImageContainer,map, Suit.Hearts); 
	    	image = card.getSubImage();
	        if(image == null) return;
	        int imageWidth = image.getWidth(this)/3;
	        int imageHeight = image.getHeight(this)/3;
	        image = image.getScaledInstance(imageWidth, imageHeight, image.SCALE_AREA_AVERAGING);
	        g.drawImage(image, y, 300, this);
	        y += ystep;
	        
	   	}
    	
    	y = 3;
    	for (CardSubImageMap map : cardImagesMapping)
    	{
    		CardImage card  = new CardImage(spadesImageContainer,map, Suit.Spades); 
	    	image = card.getSubImage();
	        if(image == null) return;
	        int imageWidth = image.getWidth(this)/3;
	        int imageHeight = image.getHeight(this)/3;
	        image = image.getScaledInstance(imageWidth, imageHeight, image.SCALE_AREA_AVERAGING);
	        g.drawImage(image, y, 200, this);
	        repaint();
	        y += ystep;
	        
	   	}
    	
    	
    	
    	//test++;
        /*temp = two;
        if(image == null) return;
        imageWidth = temp.getWidth(this)/2;
        imageHeight = temp.getHeight(this)/2;
		image2 = temp.getScaledInstance(imageWidth, imageHeight, temp.SCALE_AREA_AVERAGING);
        g.drawImage(image2,100,0, this);
        
        
        temp = three;
        if(image == null) return;
        imageWidth = temp.getWidth(this)/2;
        imageHeight = temp.getHeight(this)/2;
		image2 = temp.getScaledInstance(imageWidth, imageHeight, temp.SCALE_AREA_AVERAGING);
        g.drawImage(image2,200,0, this);
        
        temp = four;
        if(image == null) return;
        imageWidth = temp.getWidth(this)/2;
        imageHeight = temp.getHeight(this)/2;
		image2 = temp.getScaledInstance(imageWidth, imageHeight, temp.SCALE_AREA_AVERAGING);
        g.drawImage(image2,300,0, this);
        
        temp = five;
        if(image == null) return;
        imageWidth = temp.getWidth(this)/2;
        imageHeight = temp.getHeight(this)/2;
		image2 = temp.getScaledInstance(imageWidth, imageHeight, temp.SCALE_AREA_AVERAGING);
        g.drawImage(image2,400,0, this);
        
        temp = six;
        if(image == null) return;
        imageWidth = temp.getWidth(this)/2;
        imageHeight = temp.getHeight(this)/2;
		image2 = temp.getScaledInstance(imageWidth, imageHeight, temp.SCALE_AREA_AVERAGING);
        g.drawImage(image2,500,0, this);
        
        temp = seven;
        if(image == null) return;
        imageWidth = temp.getWidth(this)/2;
        imageHeight = temp.getHeight(this)/2;
		image2 = temp.getScaledInstance(imageWidth, imageHeight, temp.SCALE_AREA_AVERAGING);
        g.drawImage(image2,600,0, this);*/

/*        for (int i = 0; i*imageWidth <= getWidth(); i++)
            for(int j = 0; j*imageHeight <= getHeight();j++)
                if(i+j>0) g.copyArea(3, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);*/
    }

}