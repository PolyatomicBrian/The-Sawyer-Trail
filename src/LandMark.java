import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMark extends JPanel{
  
  private LandMarkTop lmt = new LandMarkTop();
  private LandMarkBottom lmb;
  private GamePanel gp;
  
  public LandMark(GamePanel tempgp){
    
    gp = tempgp;
    lmb = new LandMarkBottom(gp, lmt);
    setLayout(new BorderLayout());
    
    add(lmt, BorderLayout.CENTER);
    add(lmb, BorderLayout.SOUTH);
    
    
  }
  
}