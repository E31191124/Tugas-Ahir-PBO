import greenfoot.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private static GreenfootImage[] explosionImageArray;
    private int imageArrayIndex = 0;
    private int incrementImageArrayIndex = 1;
    public Explosion()
    {
        initializeImages();
        setImage(explosionImageArray[0]);
    }
    public void initializeImages()
    {
        if(explosionImageArray == null)
        {
            int explosionArraySize = 10;
            explosionImageArray = new GreenfootImage[explosionArraySize];
            GreenfootImage baseImage = new GreenfootImage("explosion.png");
            int maxImageSize = baseImage.getWidth()*4;
            int deltaImageSize = maxImageSize / explosionArraySize;
            int size = 0;
            for(int count = 0; count < explosionArraySize; count = count + 1)
            {
                size = size + deltaImageSize;
                explosionImageArray[count] = new GreenfootImage(baseImage);
                explosionImageArray[count].scale(size, size);
            }
        }
    }
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()  
    {
        setImage(explosionImageArray[imageArrayIndex]);
        imageArrayIndex = imageArrayIndex + incrementImageArrayIndex;
        if(imageArrayIndex == 10)
        {
            incrementImageArrayIndex = incrementImageArrayIndex * -1;
            imageArrayIndex = imageArrayIndex + incrementImageArrayIndex;
        }
        if(imageArrayIndex < 0)
        {
            getWorld().removeObject(this);
        }
    }    
}
