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
  
  
  public OverWorld(GamePanel tempgp /*LandMark templm, String tempplayersname, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers*/){
    
    gp = tempgp;
    
    timerCheckVisible = new javax.swing.Timer(75, new TimerListener()); //I hate myself for making this timer...
    
    createLandMarkPanel();
    
    bow = new BottomOverWorld(ow,gp/*, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, healthMrSawyer, healthVikrant, healthBrian, healthVarun, healthPlayer*/);
    TopOverWorld tow = new TopOverWorld(ow,gp,bow,lm/*, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, healthMrSawyer, healthVikrant, healthBrian, healthVarun, healthPlayer*/);
    
    setLayout(new GridLayout(2,1));
    add(tow);
    add(bow);
    ow = this;
    
    
    
    timerCheckVisible.start();
    
    setVisible(true);
  }
  
  private void createLandMarkPanel(){
   // LandMark lm2 = new LandMark(gp);
   // gp.add(lm2);
       //lm2.setVisible(false);
   // lm = lm2;
  }
  
  //This is bad programming. Yuck.
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