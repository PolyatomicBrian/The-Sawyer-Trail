import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RndEvent extends JPanel{
  
  private JLabel lblRndMsg = new JLabel();
  private ArrayList<JLabel> listRndMsg = new ArrayList<JLabel>();
  private String name;
  private int playerHealth;
  private int varunHealth;
  private int brianHealth;
  private int mrSawyerHealth;
  private int vikrantHealth;
  
  public RndEvent(int tempPlayerHealth, int tempVarunHealth, int tempBrianHealth, int tempMrSawyerHealth, int tempVikrantHealth){
    
    playerHealth = tempPlayerHealth;
    varunHealth = tempVarunHealth;
    brianHealth = tempBrianHealth;
    mrSawyerHealth = tempMrSawyerHealth;
    vikrantHealth = tempVikrantHealth;
    
    
  }
  
  public void fillArray(){
   
    JLabel lbl1 = new JLabel(name + " died of dysentery.");
    //JLabel lbl2 = 
    
  }
  
  public JLabel selectRndMsg(){
    int numRnd = (int)(listRndMsg.size() * Math.random());
    //get message from arraylist
    return lblRndMsg;

  }
  
  public void selectName(){
   int numRnd = (int)(6 * Math.random());
   //check if each character's health > 0
     //if yes, then name can be used
    //else no.
    
    
  }
  
}