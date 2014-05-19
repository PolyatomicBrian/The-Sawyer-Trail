import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoppedBottom extends JPanel{
  
  private JButton btnParty = new JButton("Party");
  private JButton btnSupplies = new JButton("Supplies");
  private JButton btnStore = new JButton("Wait");
  private JButton btnLeave = new JButton("Leave");
  
  private GamePanel gp;
  private StoppedTop lmt;

  private Stopped lm;
  
  public StoppedBottom(GamePanel tempgp, StoppedTop templmt, Stopped templm){
    
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
      GamePanel.isWait = false;
      lmt.handleBooleans();
    }
  }
  
  private class HandleBtnSupplies implements ActionListener{
    public void actionPerformed(ActionEvent e){
      GamePanel.isParty = false;
      GamePanel.isSupplies = true;
      GamePanel.isWait = false;
      lmt.handleBooleans();
    }
  }
  
  private class HandleBtnStore implements ActionListener{
    public void actionPerformed(ActionEvent e){
      GamePanel.isParty = false;
      GamePanel.isSupplies = false;
      GamePanel.isWait = true;
      lmt.handleBooleans();
    }
  }
  
  private class HandleBtnLeave implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numFuel <= 0)
        return;
      gp.remove(lm);
      GamePanel.isMoving = true;
      GamePanel.overWorldVisible = true;
      GamePanel.stoppedVisible = false;
      Background.timer.start();
      gp.revalidate();
      gp.repaint();
    }
  }
  
}