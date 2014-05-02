import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SupplySelection extends JPanel{
  
  private GamePanel gp;
  private String playersName;
  private int numSupplies = 10;
  //Initialize variable for each supply.
  //Create 2 buttons per supply.
  
  public SupplySelection(GamePanel tempgp, String tempplayersName){
    
    gp = tempgp; //Reference to GamePanel.
    playersName = tempplayersName;
    
  }
}