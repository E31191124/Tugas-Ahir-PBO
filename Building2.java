import greenfoot.*;

/**
 * Write a description of class Building2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Building2 extends Actor
{   private int numHits = 0;
    private int maximumNumberOfHits = 2;
    public void destroy()
    {
        numHits = numHits+1;
        World world = getWorld();
        if(numHits == maximumNumberOfHits)
        {
            world.addObject(new Explosion(), getX(), getY());
            world.removeObject(this);
            
        }
        else
        {
            int width = getImage().getWidth();
            int height = getImage().getHeight();
            getImage().scale(width/2,height/2);
        }
        Greenfoot.playSound ("Explosion.wav");
    }
}
