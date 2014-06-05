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
  
  //Health
  public static int healthPlayer = 100;
  public static int healthMrSawyer = 100;
  public static int healthVikrant = 100;
  public static int healthVarun = 100;
  public static int healthBrian = 100;
  
  //LandMark
  public static boolean isParty = true;
  public static boolean isSupplies = false;
  public static boolean isStore = false;
  public static boolean isWait = false;
  
  //Font
  public static Font fontType32 = new Font("Lucida Sans Typewriter", Font.PLAIN, 32);
  public static Font fontType14 = new Font("Lucida Sans Typewriter", Font.PLAIN, 14);
  public static Font fontType16 = new Font("Lucida Sans Typewriter", Font.PLAIN, 16);
  
  
  //Misc
  public static String playersname = "Mr. Null";
  public static int miles;
  public static int totalmiles;
  public static boolean isMoving = false;
  public static GamePanel gp;
  public static int landMarksEncountered;
  public static boolean overWorldVisible = false;
  public static boolean landMarkVisible = false;
  public static boolean stoppedVisible = false;
  
  
  public GamePanel(){
    
    gp = this;
    
    setLayout(new BorderLayout());
    
    
  }
  
  public static void isGameOver(){
    if (GamePanel.healthPlayer <= 0){
      if (GamePanel.healthMrSawyer <= 0){
        if (GamePanel.healthVikrant <= 0){
          if (GamePanel.healthVarun <= 0){
            if (GamePanel.healthBrian <= 0){
              gp.removeAll();
              GameOver go = new GameOver(gp, 0);
              gp.add(go);
              gp.revalidate();
              gp.repaint();
            }
          }
        }
      }
    }
  }
  
}
