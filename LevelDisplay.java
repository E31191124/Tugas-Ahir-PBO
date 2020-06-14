import greenfoot.*;
import java.util.Calendar;
/**
 * Write a description of class LevelDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelDisplay extends Actor
{
    public int WIDTH = 200;
    public int HEIGHT = 200;
    public static final float FONT_SIZE = 20.0f;
    public LevelDisplay(int level)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0,128,128,100));
        image.fillRect(0,0,WIDTH,HEIGHT);
        image.setColor(new Color(255,255,255,100));
        image.fillRect(5,5,WIDTH-10,HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString("Level " + level, WIDTH/2-40, HEIGHT/2);
        setImage(image);
    }
    /**
     * Act - do whatever the LevelDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Greenfoot.delay(100);
        World world = getWorld();
        world.removeObject(this);
    }    
}
