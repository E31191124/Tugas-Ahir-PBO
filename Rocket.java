import greenfoot.*;

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    private int speed;
    private int originalTransparency;
    public Rocket(int newSpeed)
    {
        setRotation(90);
        speed = newSpeed;
        originalTransparency = getImage().getTransparency();
    }
    public void destroy()
    {
        World world = getWorld();
        world.addObject(new Explosion(), getX(), getY());
        world.removeObject(this);
    }
    public void act() 
    {
        move(speed);
        World world = getWorld();
        Gun gun = (Gun) getOneIntersectingObject(Gun.class);
        if(gun!=null)
        {
            getImage().setTransparency(originalTransparency-50);
        }
        else
        {
            getImage().setTransparency(originalTransparency);
        }
        House houseActor = (House)getOneIntersectingObject(House.class);
        if(houseActor != null)
        {
            houseActor.destroy();
            destroy();
            return;
        }
        Building buildingActor = (Building)getOneIntersectingObject(Building.class);
        if(buildingActor != null)
        {
            buildingActor.destroy();
            destroy();
            return;
        }
        Building2 building2Actor = (Building2)getOneIntersectingObject(Building2.class);
        if(building2Actor != null)
        {
            building2Actor.destroy();
            destroy();
            return;
        }
        if(getY() == world.getHeight()-1)
        {
            world.removeObject(this);
            return;
        }
    }
}
