import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Background extends JPanel{
  
  
  private ImageIcon imgBackground;
  public static javax.swing.Timer timer;
  private javax.swing.Timer timerPause;
  public static int i = 0;
  private ObjBus objBus = new ObjBus();
  private GamePanel gp;
  private RndEvent re;
  public static boolean canLoseFuel = false;
  private boolean isEndScene = false;
  private ObjLandMark olm;
  public static int bkgdX;
  
  private ImageIcon imgLM1 = new ImageIcon("imgLM1.png");
  private ImageIcon imgLM2 = new ImageIcon("imgLM2.png");
  private ImageIcon imgLM3 = new ImageIcon("imgLM3.png");
  private ImageIcon imgLM4 = new ImageIcon("imgLM4.png");
  private ImageIcon imgLM5 = new ImageIcon("imgLM5.png");
  private ImageIcon imgLM6 = new ImageIcon("imgLM6.png");
  
  public Background(OverWorld tempow, GamePanel tempgp, TopOverWorld temptow, BottomOverWorld tempbow, LandMark templm){
    
    GamePanel.isMoving = true;
    
    setLayout(null);
    
    olm = new ObjLandMark();
    
    add(olm);
    
    gp = tempgp;
    
    imgBackground = new ImageIcon("bkgd.png");
    
    timer = new javax.swing.Timer(50, new TimerListener());
    timer.start();
    
    timerPause = new javax.swing.Timer(2500, new TimerPause());
    
    /*
     addKeyListener(new HandleKeys());
     setFocusable(true);
     */
    
    objBus.setBounds(300,100, objBus.busWidth(), objBus.busHeight());
    add(objBus);
    
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    imgBackground.paintIcon(this,g,-imgBackground.getIconWidth()+500+i,0);
    
    if (GamePanel.landMarksEncountered == 0){
      //lm1
      imgLM1.paintIcon(this,g,-imgBackground.getIconWidth()+500+i+975,0);
    }else if (GamePanel.landMarksEncountered == 1){
      //lm2
      imgLM2.paintIcon(this,g,-imgBackground.getIconWidth()+500+i+975,0);
    }else if (GamePanel.landMarksEncountered == 2){
      //lm3
      imgLM3.paintIcon(this,g,-imgBackground.getIconWidth()+500+i+975,0);
    }else if (GamePanel.landMarksEncountered == 3){
      //lm4
      imgLM4.paintIcon(this,g,-imgBackground.getIconWidth()+500+i+975,50);
    }else if (GamePanel.landMarksEncountered == 4){
      //lm5
      imgLM5.paintIcon(this,g,-imgBackground.getIconWidth()+500+i+975,0);
    }else{
      //lm6
      imgLM6.paintIcon(this,g,-imgBackground.getIconWidth()+500+i+1000,0);
    }
    
  }
  
  /*
   private class HandleKeys extends KeyListener{
   public void keyPressed(KeyEvent e){
   if (e.getKeyCode() == ){
   timer.setDelay(2);
   }
   }
   }*/
  
  
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.isMoving && GamePanel.numFuel > 0){
        i+=6; //Speed of background moving.
        
        if (!isEndScene){
          if (GamePanel.landMarksEncountered == 5 && BottomOverWorld.numNextLandMark == 0){
            gotoEndingScene();
            isEndScene = true;
            return;
          }
          if (GamePanel.miles % 25 == 0 && GamePanel.miles != 0 && !isEndScene){
            loseFuel();
          }
          if(GamePanel.miles % 200 == 0 && GamePanel.miles != 0 && !isEndScene){
            gotoLandMark();
          }
          else if(GamePanel.miles % 50 == 0 && GamePanel.miles != 0 && !isEndScene){
            doRandomEvent();
            loseHealth();
          }
        }
      }
      else if (GamePanel.numFuel <= 0 && GamePanel.stoppedVisible == false){
        outofFuelGoToStop();
      }
      
      
      
      bkgdX = -imgBackground.getIconWidth()+500+i+600;
      //olm.setBounds(bkgdX,0,400,400);
      
      GamePanel.isGameOver();
      
      olm.repaint();
      
      revalidate();
      repaint();
      
      //System.out.println(-imgBackground.getIconWidth()+500+i);
    }
  }
  
  public static void loseHealth(){
    /*
     int healthPlayerLose = (int)(GamePanel.healthPlayer / 4 * Math.random() + 1);
     int healthMrSawyerLose = (int)(GamePanel.healthMrSawyer / 4 * Math.random() + 1);
     int healthVikrantLose = (int)(GamePanel.healthVikrant / 4 * Math.random() + 1);
     int healthVarunLose = (int)(GamePanel.healthVarun / 4 * Math.random() + 1);
     int healthBrianLose = (int)(GamePanel.healthBrian / 4 * Math.random() + 1);
     */
    
    int healthPlayerLose = (int)(21 * Math.random() + 5);
    int healthMrSawyerLose = (int)(21 * Math.random() + 5);
    int healthVikrantLose = (int)(21 * Math.random() + 5);
    int healthVarunLose = (int)(21 * Math.random() + 5);
    int healthBrianLose = (int)(21 * Math.random() + 5);
    
    if (GamePanel.healthPlayer - healthPlayerLose <= 0){
      GamePanel.healthPlayer = 0;
    }else{
      GamePanel.healthPlayer -= healthPlayerLose;
    }
    
    if (GamePanel.healthMrSawyer - healthMrSawyerLose <= 0){
      GamePanel.healthMrSawyer = 0;
    }else{
      GamePanel.healthMrSawyer -= healthMrSawyerLose;
    }
    
    if (GamePanel.healthVikrant - healthVikrantLose <= 0){
      GamePanel.healthVikrant = 0;
    }else{
      GamePanel.healthVikrant -= healthVikrantLose;
    }
    
    if (GamePanel.healthVarun - healthVarunLose <= 0){
      GamePanel.healthVarun = 0;
    }else{
      GamePanel.healthVarun -= healthVarunLose;
    }
    
    if (GamePanel.healthBrian - healthBrianLose <= 0){
      GamePanel.healthBrian = 0;
    }else{
      GamePanel.healthBrian -= healthBrianLose;
    }
    
    
  }
  
  public void gotoEndingScene(){
    timer.stop();
    
    gp.removeAll();
    EndingScene go = new EndingScene(gp);
    gp.add(go);
    gp.revalidate();
    gp.repaint(); 
  }
  
  public void gotoLandMark(){
    
    GamePanel.isMoving = false;
    GamePanel.totalmiles += GamePanel.miles;
    GamePanel.miles = 0;
    GamePanel.landMarksEncountered++;
    GamePanel.overWorldVisible = false;
    GamePanel.landMarkVisible = true;
    
    i = 0;
    
    LandMark lm = new LandMark(gp);
    gp.add(lm);
    gp.revalidate();
    gp.repaint();
    timer.stop();
    timerPause.stop();
  }
  
  private void outofFuelGoToStop(){
    GamePanel.isMoving = false;
    GamePanel.totalmiles += GamePanel.miles;
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
    re.setBounds(50,25,400,20);
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