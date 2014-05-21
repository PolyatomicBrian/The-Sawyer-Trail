import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopped extends JPanel{
  
  private GamePanel gp;
  
  private Stopped lm;
  
  private javax.swing.Timer timerStoppedVisible;
  
  public Stopped(GamePanel tempgp){
    
    gp = tempgp;
    
    lm = this;
    
    StoppedTop lmt = new StoppedTop(gp);
    StoppedBottom lmb = new StoppedBottom(gp, lmt, lm);
    setLayout(new BorderLayout());
    
    add(lmt, BorderLayout.CENTER);
    add(lmb, BorderLayout.SOUTH);
    
    timerStoppedVisible = new javax.swing.Timer(75, new StoppedTimer());
    
    timerStoppedVisible.start();
    
    
  }
  
  
  private class StoppedTimer implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.overWorldVisible == false && GamePanel.stoppedVisible){
        setVisible(true);
        revalidate();
        repaint();
        gp.revalidate();
        gp.repaint();
      }else{
        setVisible(false);
      }
      GamePanel.isGameOver();
    }
    
  }
  
  
  
}