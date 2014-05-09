import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Background extends JPanel{
  
  
  private ImageIcon imgBackground;
  private javax.swing.Timer timer;
  private javax.swing.Timer timerPause;
  private int i = 0;
  private ObjBus objBus = new ObjBus();
  private GamePanel gp;
  private RndEvent re;
  
  public Background(GamePanel tempgp){
    
    setLayout(null);
    
    gp = tempgp;
    
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
      if (GamePanel.isMoving){
        i+=6; //Speed of background moving.
        
        if(GamePanel.miles % 200 == 0){
          //Go to landmark.
          //Set miles to zero.
        }else if(GamePanel.miles % 50 == 0){
          doRandomEvent();
        }
      }
      
      revalidate();
      repaint();
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
      GamePanel.isMoving = true;
      remove(re);
      revalidate();
      repaint();
      timerPause.stop();
    }
  }
}