import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMark extends JPanel{
  
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
    
    timerLandMarkVisible = new javax.swing.Timer(75, new LandMarkTimer());
    
    timerLandMarkVisible.start();
    
    
  }
  
  
  
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