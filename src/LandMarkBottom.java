import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMarkBottom extends JPanel{
  
  private MyJButton btnParty = new MyJButton("Party");
  private MyJButton btnSupplies = new MyJButton("Supplies");
  private MyJButton btnStore = new MyJButton("Store");
  private MyJButton btnLeave = new MyJButton("Leave");
  
  private GamePanel gp;
  private LandMarkTop lmt;

  private LandMark lm;
  
  public LandMarkBottom(GamePanel tempgp, LandMarkTop templmt, LandMark templm){
    
    gp = tempgp;
    lmt = templmt;

    lm = templm;
    
    setPreferredSize(new Dimension(500,75));
    setBackground(Color.BLACK);
    setLayout(null);
    
    btnParty.setBounds(0,0,100,75);
    btnParty.addActionListener(new HandleBtnParty());
    add(btnParty);
    
    btnSupplies.setBounds(100,0,100,75);
    btnSupplies.addActionListener(new HandleBtnSupplies());
    btnSupplies.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
    add(btnSupplies);
    
    btnStore.setBounds(200,0,100,75);
    btnStore.addActionListener(new HandleBtnStore());
    add(btnStore);
    
    btnLeave.setBounds(400,0,100,75);
    btnLeave.addActionListener(new HandleBtnLeave());
    add(btnLeave);
    
  }
  
  private class HandleBtnParty implements ActionListener{
    public void actionPerformed(ActionEvent e){
      GamePanel.isParty = true;
      GamePanel.isSupplies = false;
      GamePanel.isStore = false;
      lmt.handleBooleans();
    }
  }
  
  private class HandleBtnSupplies implements ActionListener{
    public void actionPerformed(ActionEvent e){
      GamePanel.isParty = false;
      GamePanel.isSupplies = true;
      GamePanel.isStore = false;
      lmt.handleBooleans();
    }
  }
  
  private class HandleBtnStore implements ActionListener{
    public void actionPerformed(ActionEvent e){
      GamePanel.isParty = false;
      GamePanel.isSupplies = false;
      GamePanel.isStore = true;
      lmt.handleBooleans();
    }
  }
  
  private class HandleBtnLeave implements ActionListener{
    public void actionPerformed(ActionEvent e){

      BottomOverWorld.numNextLandMark = 200;
      gp.remove(lm);
      GamePanel.isMoving = true;
      GamePanel.overWorldVisible = true;
      Background.timer.start();
      gp.revalidate();
      gp.repaint();
    }
  }
  
}