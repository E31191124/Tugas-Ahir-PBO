import greenfoot.*;
/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Actor
{
    private ScoreKeeper gunScoreKeeper;
    public Gun(ScoreKeeper scorekeeper)
    {
        gunScoreKeeper = scorekeeper;
    }
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        if(Greenfoot.mouseClicked(null))
        {
            Rocket rocket = (Rocket) getOneObjectAtOffset(0,0,Rocket.class);
            Greenfoot.playSound ("EnergyGun.wav");
            if(rocket!=null)
            {
                rocket.destroy();
                gunScoreKeeper.incrementScore(RocketAttackWorld.scoreOfRockets);
                Greenfoot.playSound ("MetalExplosion.wav");
            }
        }
    }    
}
