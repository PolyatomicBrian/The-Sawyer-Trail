import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMarkBottom extends JPanel{
  
  private JButton btnParty = new JButton("Party");
  private JButton btnSupplies = new JButton("Supplies");
  private JButton btnStore = new JButton("Store");
  private JButton btnLeave = new JButton("Leave");
  
  public LandMarkBottom(){
    
    setPreferredSize(new Dimension(500,75));
    setLayout(null);
    
    btnParty.setBounds(0,0,100,75);
    add(btnParty);
    
    btnSupplies.setBounds(100,0,100,75);
    add(btnSupplies);
    
    btnStore.setBounds(200,0,100,75);
    add(btnStore);
    
    btnLeave.setBounds(400,0,100,75);
    add(btnLeave);
    
    
  }
  
}