import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMark extends JPanel{
  
 // private LandMarkTop lmt;
//  private LandMarkBottom lmb;
  private GamePanel gp;
  
  private LandMark lm;
  
  private javax.swing.Timer timerLandMarkVisible;
  
  public LandMark(GamePanel tempgp){
    
    gp = tempgp;
    
    lm = this;
    
    LandMarkTop lmt = new LandMarkTop(gp);
    LandMarkBottom lmb = new LandMarkBottom(gp, lmt, lm);
    setLayout(new BorderLayout());
    
    add(lmt, BorderLayout.CENTER);
    add(lmb, BorderLayout.SOUTH);
    
    timerLandMarkVisible = new javax.swing.Timer(75, new LandMarkTimer()); // So sad...
    
    timerLandMarkVisible.start();
    
    
  }
  
  
  
  //This is bad programming. Yuck.
  private class LandMarkTimer implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.overWorldVisible == false && GamePanel.landMarkVisible){
        setVisible(true);
        revalidate();
        repaint();
        gp.revalidate();
        gp.repaint();
      }else{
        setVisible(false);
      }
    }
    
  }
  
  
  
}