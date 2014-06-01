import javax.swing.*;
import java.awt.*;

public class TopOverWorld extends JPanel{
  
  private GamePanel gp;
  private TopOverWorld tow; 
  
  private Background bg;
  
  private OverWorld ow;
  private BottomOverWorld bow;
  private LandMark lm;
  
  public TopOverWorld(OverWorld tempow, GamePanel tempgp, BottomOverWorld tempbow, LandMark templm){
    
    setLayout(null);

    gp = tempgp;
    tow = this;
    ow = tempow;
    bow = tempbow;
    lm = templm;
    
    bg = new Background(ow,gp,tow,bow, lm);
    
    setBackground(Color.BLACK);
    
    bg.setBounds(0,0,500,500);
    add(bg);
    
  }

 
}