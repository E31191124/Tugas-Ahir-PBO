import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Petunjuk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Petunjuk extends World
{

    /**
     * Constructor for objects of class Petunjuk.
     * 
     */
    public Petunjuk()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1);
        tombolKembali kembali = new tombolKembali();
        addObject(kembali,100,(int) getWidth()/2);
    }
}
