import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OverWorld extends JPanel{
  private GamePanel gp;
  private int numFuel;
  private int numFood;
  private int numFlashDrives;
  private int numMoney;
  private int numTires;
  private int numMufflers;
  private String playersname;
  
  public OverWorld(GamePanel tempgp, String tempplayersname, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers){
    gp = tempgp;
    playersname = tempplayersname;
    numFuel = tempnumFuel;
    numFood = tempnumFood;
    numFlashDrives = tempnumFlashDrives;
    numMoney = tempnumMoney;
    numTires = tempnumTires;
    numMufflers = tempnumMufflers;
     
    TopOverWorld tow = new TopOverWorld();
    BottomOverWorld bow = new BottomOverWorld(gp, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers);
    setLayout(new GridLayout(2,1));
    add(tow);
    add(bow);
    
  }
  
}