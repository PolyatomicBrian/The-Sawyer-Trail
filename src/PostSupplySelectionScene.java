import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PostSupplySelectionScene extends JPanel{
  
  private MyJButton btnOK = new MyJButton("OK");
  private javax.swing.Timer timer;
  
  private GamePanel gp;
  private JLabel lblTimeToGo = new JLabel("<html><font color = 'white'>It's time to go!</font></html>");
  private PostSupplySelectionScene psss;
  private String playersname;
  private ImageIcon imgTimeToGo = new ImageIcon("imgTimeToGo.png");
  
  public PostSupplySelectionScene(GamePanel tempgp, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers, String tempplayersname){
    
    gp = tempgp;
    playersname = tempplayersname;
    psss = this;
    GamePanel.numFuel = tempnumFuel;
    GamePanel.numFood = tempnumFood;
    GamePanel.numFlashDrives = tempnumFlashDrives;
    GamePanel.numMoney = tempnumMoney;
    GamePanel.numTires = tempnumTires;
    GamePanel.numMufflers = tempnumMufflers;
    GamePanel.playersname = playersname;
    
    
    setLayout(null);
    setBackground(Color.GRAY);
    
    /*
     btnOK.addActionListener(new HandleBtnOK());
     btnOK.setBounds(370,400,80,30);
     add(btnOK);
     */
    
    lblTimeToGo.setBounds(140,25,500,20);
    add(lblTimeToGo);
    
    timer = new javax.swing.Timer(2100, new TimerListener());
    
    timer.start();
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    imgTimeToGo.paintIcon(this,g,50,50);
  }
  
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      gp.remove(psss);
      OverWorld ow = new OverWorld(gp);
      GamePanel.overWorldVisible = true;
      gp.add(ow);
      gp.revalidate();
      gp.repaint();
      timer.stop();
    }
  }
  
  private class HandleBtnOK implements ActionListener{
    public void actionPerformed(ActionEvent e){
      gp.remove(psss);
      OverWorld ow = new OverWorld(gp);
      GamePanel.overWorldVisible = true;
      gp.add(ow);
      gp.revalidate();
      gp.repaint();
    }
  }
  
}