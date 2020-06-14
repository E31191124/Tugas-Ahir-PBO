import greenfoot.*;
import java.util.Calendar;
/**
 * Pertahanan Kota!
 * Game sederhana mempertahankan kota dari serangan roket!
 * Cara Bermain:
 * Mouse = kontrol; mouse klik = Tembak!
 * 
 * Author: Andi Purnama
 * Pelita Bangsa
 */
public class RocketAttackWorld extends World
{   private ScoreKeeper scoreKeeper = new ScoreKeeper();
    private int actIteration = 0;
    private int x = 0;
    private int speed = 2;
    private int numRocketsCreated = 0;
    private int level = 0;
    private int maxRocketsPerLevel = 10;
    public static int scoreOfRockets = 5;
    public static int scoreOfRockets()
    {
        return scoreOfRockets();
    }
    
    
    /**
     * Constructor for objects of class RocketAttackWorld.
     * 
     */
    public RocketAttackWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 500, 1);
        //GreenfootImage backgroundImage = new GreenfootImage(getWidth(), getHeight());
        //backgroundImage.setColor(Color.blue);
        //backgroundImage.fillRect(0,0,getWidth(), (int) (getHeight() *.75));
        //backgroundImage.setColor(Color.green);
        //backgroundImage.fillRect(0,(int) (getHeight()*.75), getWidth(), (int) (getHeight() *.25));
        //setBackground(backgroundImage);
        //diatas tuh kalo bg nya mau warna doang
        createCity();
        addGun();
        addScoreKeeper();
        //prepare();
    }

    public void createCity()
    {
        int x = 0;
        int y = (int)(getHeight()*.78);
        int counter =1;
        while(true)
        {
            Actor cityActor = getCityActor();
            GreenfootImage image = cityActor.getImage();
            int width = image.getWidth();
            if((x + width) > getWidth())            
            {
                break;
            }

            addObject(cityActor, x+width/2, y);
            x=x+width;
            counter = counter + 1;
            
            //Biar house selalu penuh brad
            if(counter % 2 == 0)
            {
            House house = new House();
            GreenfootImage houseImage = house.getImage();
            int houseWidth = houseImage.getWidth();
            if((x + houseWidth) > getWidth())
            break;

            addObject(house, x+houseWidth/2, y);
            x = x + houseWidth;
            }
            else
            {
            Building building = new Building();
            GreenfootImage buildingImage = building.getImage();
            int buildingWidth = buildingImage.getWidth();
            if((x + buildingWidth) > getWidth())
            break;

            addObject(building, x+buildingWidth/2, y);
            x = x + buildingWidth;                
            }
            counter = counter + 1;
        }
        House house = new House();
        GreenfootImage houseImage = house.getImage();
        int houseImageWidth = houseImage.getWidth();
        addObject(house,x + houseImageWidth/2, y);
        x = x + houseImageWidth;
        House house2 = new House();
        addObject(house2, x+houseImageWidth/2,y);
        //ni sampe sini nih pokonya, kalo error koment wkwk
    }

    public void addGun()
    {
        addObject(new Gun(scoreKeeper), getWidth() /2, getHeight() /2);
    }

    public Actor getCityActor()
    {
        int buildingType = Greenfoot.getRandomNumber(3);
        if(buildingType == 0)
        {
            return new House();
        }
        else if(buildingType == 1)
        {
            return new Building();
        }
        else if(buildingType == 2)
        {
            return new Building2();
        }
        return null;
    }

    public void addLevelDisplay(int level)
    {
        addObject(new LevelDisplay(level), getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
        java.util.List rocketList = getObjects(Rocket.class);
        if(numRocketsCreated >= (maxRocketsPerLevel * level) && rocketList.size() == 0)
        {
            level = level + 1;
            numRocketsCreated = 0;
            actIteration = 0;
            speed = 1;
            addLevelDisplay(level);
            return;
        }
        java.util.List houseList = getObjects(House.class);
        int numHomesLeft = 0;
        if(houseList != null)
        {
            numHomesLeft = houseList.size();
            
        }
        java.util.List buildingList = getObjects(Building.class);
        if(buildingList != null)
        {
            numHomesLeft = numHomesLeft + buildingList.size();
        }
        
        //pengganti nyawa nih, kalo home abis game selesai
        if(numHomesLeft == 0)
        {
            //Greenfoot.stop(); //di coment soalnya stop manual pake tombol
            scoreKeeper.gameOver();
            tombolLagi mainlagi = new tombolLagi();
            addObject(mainlagi,450, 380);
            tombolKeluar keluar = new tombolKeluar();
            addObject(keluar,800,(int) getWidth()/2);
            addObject(new EndDisplay(), getWidth()/2, getHeight()/2);
            return;
        }
        
        //pertambahan ketika level naik
        actIteration = actIteration + 1;
        if(actIteration % 100 == 0)
        {
            Rocket rocket = new Rocket(speed);
            numRocketsCreated = numRocketsCreated + 2;
            if(numRocketsCreated > 0 && numRocketsCreated % 2.5 == 0)
            {
                speed = speed + 3;
                scoreOfRockets = scoreOfRockets + 5;
                return;
            }
            int rocketWidth = rocket.getImage().getWidth();
            x = Greenfoot.getRandomNumber(getWidth());
            if(x - rocketWidth < 0)
            {
                x=rocketWidth / 2;
            }
            else if(x + rocketWidth > getWidth())
            {
                x = getWidth() - rocketWidth/2;
            }
            addObject(rocket, x, 0);
            return;
        }
        return;
    }
    
    public void addScoreKeeper()
    {
        addObject(scoreKeeper, getWidth()/2, (int) (getHeight()*.90));
    }

   
}
