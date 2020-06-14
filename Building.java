import greenfoot.*;

/**
 * Write a description of class Building here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Building extends Actor
{
    public void destroy()
    {
        World world = getWorld();
        world.addObject(new Explosion(), getX(), getY());
        world.removeObject(this);
        Greenfoot.playSound ("Explosion.wav");
    }
}
