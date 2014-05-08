import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OverWorld extends JPanel{
<<<<<<< HEAD
  GamePanel gp;
=======
  private GamePanel gp;
  private int numFuel;
  private int numFood;
  private int numFlashDrives;
  private int numMoney;
  private int numTires;
  private int numMufflers;
  private String playersname;
>>>>>>> aeb6e0fb7d937d98e371137a7c47ce57f59f5944
  
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