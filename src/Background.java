import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Background extends JPanel{
  
  
  private ImageIcon imgBackground;
  public static javax.swing.Timer timer;
  private javax.swing.Timer timerPause;
  private int i = 0;
  private ObjBus objBus = new ObjBus();
  private GamePanel gp;
  private OverWorld ow;
  private TopOverWorld tow;
  private BottomOverWorld bow;
  private RndEvent re;
  private LandMark lm;
  public static boolean canLoseFuel = false;
  
  public Background(OverWorld tempow, GamePanel tempgp, TopOverWorld temptow, BottomOverWorld tempbow, LandMark templm){
    
    GamePanel.isMoving = true;
    
    setLayout(null);
    
    tow = temptow;
    bow = tempbow;
    ow = tempow;
    gp = tempgp;
    lm = templm;
    
    imgBackground = new ImageIcon("bkgd.png");
    
    timer = new javax.swing.Timer(50, new TimerListener());
    timer.start();
    
    timerPause = new javax.swing.Timer(2500, new TimerPause());
    
    
    
    /*
     re = new RndEvent(GamePanel.playersname, GamePanel.healthPlayer, GamePanel.healthVarun, GamePanel.healthBrian, GamePanel.healthMrSawyer, GamePanel.healthVikrant);
     re.setBounds(100,25,300,20);
     add(re);
     */
    
    
    objBus.setBounds(300,100, objBus.busWidth(), objBus.busHeight());
    add(objBus);
    
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    imgBackground.paintIcon(this,g,-imgBackground.getIconWidth()+500+i,0);
    
  }
  
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.isMoving && GamePanel.numFuel > 0){
        i+=6; //Speed of background moving.
        if (GamePanel.miles % 25 == 0 && GamePanel.miles != 0){
          loseFuel();
        }
        if(GamePanel.miles % 200 == 0 && GamePanel.miles != 0){
          gotoLandMark();
        }else if(GamePanel.miles % 50 == 0 && GamePanel.miles != 0){
          doRandomEvent();
        }
      }else if (GamePanel.numFuel <= 0 && GamePanel.stoppedVisible == false){
        outofFuelGoToStop();
      }
      
      //System.out.println(""+GamePanel.miles);
      
      revalidate();
      repaint();
    }
  }
  
  public void gotoLandMark(){
    
    //GamePanel.miles = 0;
    //gp.remove(this); //Null pointer exception here : gp.remove(ow);
    //LandMark lm = new LandMark(gp);
    GamePanel.isMoving = false;
    GamePanel.totalmiles += GamePanel.miles;
    GamePanel.miles = 0;
    GamePanel.landMarksEncountered++;
    GamePanel.overWorldVisible = false;
    GamePanel.landMarkVisible = true;
    
    LandMark lm = new LandMark(gp);
    gp.add(lm);
    //ow.setVisible(false);
    // gp.removeAll();
    //gp.add(lm);
    gp.revalidate();
    gp.repaint();
    timer.stop();
    timerPause.stop();
  }
  
  private void outofFuelGoToStop(){
    GamePanel.isMoving = false;
    GamePanel.totalmiles += GamePanel.miles;
    //GamePanel.landMarksEncountered++;
    GamePanel.overWorldVisible = false;
    GamePanel.stoppedVisible = true;
    
    Stopped st = new Stopped(gp);
    gp.add(st);
  }
  
  private void loseFuel(){
    if (canLoseFuel){
      GamePanel.numFuel--;
      canLoseFuel = false;
    }
  }
  
  private void doRandomEvent(){
    
    GamePanel.isMoving = false;
    timerPause.start();
    re = new RndEvent(GamePanel.playersname, GamePanel.healthPlayer, GamePanel.healthVarun, GamePanel.healthBrian, GamePanel.healthMrSawyer, GamePanel.healthVikrant);
    re.setBounds(100,25,300,20);
    add(re);
    timer.stop();
    revalidate();
    repaint();
    
  }
  
  private class TimerPause implements ActionListener{
    public void actionPerformed(ActionEvent e){
      timer.start();
      GamePanel.miles++;
      BottomOverWorld.numNextLandMark--;
      GamePanel.isMoving = true;
      remove(re);
      revalidate();
      repaint();
      timerPause.stop();
    }
  }
}