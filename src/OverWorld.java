import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OverWorld extends JPanel{
  GamePanel gp;
  
  /*
  //Supplies
   int numFuel;
   int numFood;
   int numFlashDrives;
   int numMoney;
   int numTires;
   int numMufflers;
   */
  
  //Health
   int healthMrSawyer = 100;
   int healthVikrant = 100;
   int healthBrian = 100;
   int healthVarun = 100;
   int healthPlayer = 100;
  
   String playersname;
  
  
  public OverWorld(GamePanel tempgp/*, String tempplayersname, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers*/){
    gp = tempgp;
    /*
    playersname = tempplayersname;
    numFuel = tempnumFuel;
    numFood = tempnumFood;
    numFlashDrives = tempnumFlashDrives;
    numMoney = tempnumMoney;
    numTires = tempnumTires;
    numMufflers = tempnumMufflers;
    
    
    healthMrSawyer = 100;
    healthVikrant = 100;
    healthBrian = 100;
    healthVarun = 100;
    healthPlayer = 100;
    */
     
    TopOverWorld tow = new TopOverWorld(gp/*, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, healthMrSawyer, healthVikrant, healthBrian, healthVarun, healthPlayer*/);
    BottomOverWorld bow = new BottomOverWorld(gp/*, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, healthMrSawyer, healthVikrant, healthBrian, healthVarun, healthPlayer*/);
    setLayout(new GridLayout(2,1));
    add(tow);
    add(bow);
    
  }
  
  //Create method to getHealth?
  //Create method to setHealth?
  
}