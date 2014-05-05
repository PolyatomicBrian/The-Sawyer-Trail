import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PostSupplySelectionScene extends JPanel{
  
  private JButton btnOK = new JButton("OK");
  private JLabel lblTimeToGo = new JLabel("<html><font color = 'white'>It's time to go!</font></html>");
  private GamePanel gp;
  private PostSupplySelectionScene psss;
  private int numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers;
  private String playersname;
  
  public PostSupplySelectionScene(GamePanel tempgp, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers, String tempplayersname){
    
    gp = tempgp;
    playersname = tempplayersname;
    psss = this;
    numFuel = tempnumFuel;
    numFood = tempnumFood;
    numFlashDrives = tempnumFlashDrives;
    numMoney = tempnumMoney;
    numTires = tempnumTires;
    numMufflers = tempnumMufflers;
    
    setLayout(null);
    setBackground(Color.DARK_GRAY);
    
    btnOK.addActionListener(new HandleBtnOK());
    btnOK.setBounds(370,400,80,30);
    add(btnOK);
    
    lblTimeToGo.setBounds(145,25,500,20);
    add(lblTimeToGo);
  }
  
  private class HandleBtnOK implements ActionListener{
    public void actionPerformed(ActionEvent e){
      gp.remove(psss);
      OverWorld ow = new OverWorld(gp, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers);
      gp.add(ow);
      gp.revalidate();
      gp.repaint();
    }
  }
  
}