import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OverWorld extends JPanel{
  private GamePanel gp;
  private OverWorld ow;
  private LandMark lm;
  private javax.swing.Timer timerCheckVisible;
  private String playersname;
  private BottomOverWorld bow;
  
  
  public OverWorld(GamePanel tempgp){
    
    gp = tempgp;
    setBackground(new Color(0xd2b48c));
    timerCheckVisible = new javax.swing.Timer(75, new TimerListener());
    
    bow = new BottomOverWorld(ow,gp);
    TopOverWorld tow = new TopOverWorld(ow,gp,bow,lm);
    
    setLayout(new GridLayout(2,1));
    add(tow);
    add(bow);
    ow = this;
    
    timerCheckVisible.start();
    
    setVisible(true);
  }
  
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.overWorldVisible){
        setVisible(true);
      }else{
        setVisible(false);
      }
      bow.updateStats();
    }
  }
  
}