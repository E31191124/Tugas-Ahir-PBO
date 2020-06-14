import greenfoot.*;
/**
 * Write a description of class ScoreKeeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreKeeper extends Actor
{
    private int currentScore = 0;
    public void incrementScore(int amount)
    {
        currentScore += amount;
        GreenfootImage image = new GreenfootImage("Score: " + currentScore, 25, Color.BLACK, Color.GREEN);
        setImage(image);
    }
    public ScoreKeeper()
    {
        GreenfootImage image = new GreenfootImage("Score: " + currentScore, 25, Color.BLACK, Color.GREEN);
        setImage(image);
        return;
    }
    public void act() 
    {
        
    }
    public void gameOver()
    {
        GreenfootImage image = new GreenfootImage("Game Over: " + currentScore, 25, Color.BLACK, Color.GREEN);
        setImage(image);
        //showText("Permainan Selesai",450,300);
    }
}
