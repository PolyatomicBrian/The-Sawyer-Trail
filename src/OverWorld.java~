import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OverWorld extends JPanel{
  GamePanel gp;
  int numFuel;
  int numFood;
  int numFlashDrives;
  int numMoney;
  int numTires;
  int numMufflers;
  String playersname;
  
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