import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
  
  //Global Variables
  
  //Supplies
  public static int numFuel;
  public static int numFood;
  public static int numFlashDrives;
  public static int numMoney;
  public static int numTires;
  public static int numMufflers;
  
  public static String playersname = "Mr. Null";
  
  //Health
  public static int healthPlayer = 100;
  public static int healthMrSawyer = 100;
  public static int healthVikrant = 100;
  public static int healthVarun = 100;
  public static int healthBrian = 100;
  
  public GamePanel(){
    
    setLayout(new BorderLayout());
    
    
  }
}
