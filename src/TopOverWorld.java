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
  
  //private RndEvent re; 
  private Background bg;
  
  private OverWorld ow;
  private BottomOverWorld bow;
  private LandMark lm;
  
  public TopOverWorld(OverWorld tempow, GamePanel tempgp, BottomOverWorld tempbow, LandMark templm/*, String tempplayersname, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers, int tempMrSawyerHealth, int tempVikrantHealth, int tempVarunHealth, int  tempBrianHealth, int tempPlayerHealth*/){
    
    setLayout(null);
    
     
    
    gp = tempgp;
    tow = this;
    ow = tempow;
    bow = tempbow;
    lm = templm;
    
    playersname = GamePanel.playersname;
    
    bg = new Background(ow,gp,tow,bow, lm);
    
    playerHealth = GamePanel.healthPlayer;
    varunHealth = GamePanel.healthVarun;
    mrSawyerHealth = GamePanel.healthMrSawyer;
    vikrantHealth = GamePanel.healthVikrant;
    brianHealth = GamePanel.healthBrian;
    
    setBackground(Color.BLACK);
    
    //  re = new RndEvent(gp,tow,playersname,playerHealth,varunHealth,brianHealth,mrSawyerHealth,vikrantHealth);
    //   re.setBounds(100, 25, 300, 20/*re.msgWidth(), re.msgHeight()*/);
    //  add(re);
    
    
    
    bg.setBounds(0,0,500,500);
    add(bg);
    
  }

 
}