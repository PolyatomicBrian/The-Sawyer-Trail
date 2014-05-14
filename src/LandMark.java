import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMark extends JPanel{
  
  private LandMarkTop lmt;
  private LandMarkBottom lmb;
  private GamePanel gp;

  private LandMark lm;
  
 // private javax.swing.Timer timerCheckVisible;
  
  public LandMark(GamePanel tempgp){
    
    gp = tempgp;

    lm = this;
    
    lmt = new LandMarkTop(gp);
    lmb = new LandMarkBottom(gp, lmt, lm);
    setLayout(new BorderLayout());
    
    add(lmt, BorderLayout.CENTER);
    add(lmb, BorderLayout.SOUTH);
    
    //timerCheckVisible = new javax.swing.Timer(75, new TimerListener()); // So sad...
    
   // timerCheckVisible.start();
    
    //setVisible(true);
    
  }
  
  /*
  //This is bad programming. Yuck.
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.landMarkVisible){
        setVisible(true);
      }else{
        setVisible(false);
      }
    }
  }
  */
  
  
}