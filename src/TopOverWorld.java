import javax.swing.*;
import java.awt.*;

public class TopOverWorld extends JPanel{
  
  private GamePanel gp;
  private TopOverWorld tow;
  private String playersname;
  private int numFuel;
  private int numFood;
  private int numFlashDrives;
  private int numMoney;
  private int numTires;
  private int numMufflers;
  
  private int playerHealth;
  private int mrSawyerHealth;
  private int vikrantHealth;
  private int varunHealth;
  private int brianHealth;
  
  public TopOverWorld(GamePanel tempgp/*, String tempplayersname, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers, int tempMrSawyerHealth, int tempVikrantHealth, int tempVarunHealth, int  tempBrianHealth, int tempPlayerHealth*/){
    
    gp = tempgp;
    tow = this;
    playersname = GamePanel.playersname;
    
    playerHealth = GamePanel.healthPlayer;
    varunHealth = GamePanel.healthVarun;
    mrSawyerHealth = GamePanel.healthMrSawyer;
    vikrantHealth = GamePanel.healthVikrant;
    brianHealth = GamePanel.healthBrian;
    
    setBackground(Color.BLACK);
    
    RndEvent re = new RndEvent(gp,tow,playersname,100,100,100,100,100);
    add(re);
    repaint();
  }
  
}