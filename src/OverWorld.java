import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OverWorld extends JPanel{
  private GamePanel gp;
  private OverWorld ow;
  private javax.swing.Timer timerCheckVisible;
  private String playersname;
  
  
  public OverWorld(GamePanel tempgp/*, String tempplayersname, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers*/){
    
    gp = tempgp;
    
    timerCheckVisible = new javax.swing.Timer(75, new TimerListener()); //I hate myself for making this timer...
    
    BottomOverWorld bow = new BottomOverWorld(ow,gp/*, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, healthMrSawyer, healthVikrant, healthBrian, healthVarun, healthPlayer*/);
    TopOverWorld tow = new TopOverWorld(ow,gp,bow/*, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, healthMrSawyer, healthVikrant, healthBrian, healthVarun, healthPlayer*/);
    
    setLayout(new GridLayout(2,1));
    add(tow);
    add(bow);
    ow = this;
    
    timerCheckVisible.start();
    
    setVisible(true);
  }
  
  //This is bad programming. Yuck.
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.overWorldVisible){
        setVisible(true);
      }else{
        setVisible(false);
      }
    }
  }
  
}