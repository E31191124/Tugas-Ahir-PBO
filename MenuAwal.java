import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuAwal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuAwal extends World
{

    /**
     * Constructor for objects of class MenuAwal.
     * 
     */
    public MenuAwal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1);
        prepare();
    }
    
    private void prepare() 
    {
        //menu menu = new menu();
        //addObject(menu,532,330);
        //help help = new help();
        //addObject(help,539,482);
        tombolPlay play = new tombolPlay();
        addObject(play,450,(int) getWidth()/2);
        tombolPetunjuk petunjuk = new tombolPetunjuk();
        addObject(petunjuk,790,(int) getWidth()/2);
        tombolKeluar keluar = new tombolKeluar();
        addObject(keluar,850,(int) getWidth()/2);

        

        
    }
  
}
