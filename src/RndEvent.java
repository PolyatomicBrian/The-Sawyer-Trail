import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RndEvent extends JPanel{
  
  private TopOverWorld tow;
  private GamePanel gp;
  private JLabel lblRndMsg = new JLabel("<html><font color = 'white'>Temp</font></html>");
  private ArrayList<JLabel> listRndMsg = new ArrayList<JLabel>();
  private String playersname;
  private int playerHealth;
  private int varunHealth;
  private int brianHealth;
  private int mrSawyerHealth;
  private int vikrantHealth;
  
  public RndEvent(GamePanel tempgp, TopOverWorld temptow, String tempplayersname, int tempPlayerHealth, int tempVarunHealth, int tempBrianHealth, int tempMrSawyerHealth, int tempVikrantHealth){
    
    tow = temptow;
    gp = tempgp;
    playersname = tempplayersname;
    
    setLayout(new BorderLayout());
    
    playerHealth = tempPlayerHealth;
    varunHealth = tempVarunHealth;
    brianHealth = tempBrianHealth;
    mrSawyerHealth = tempMrSawyerHealth;
    vikrantHealth = tempVikrantHealth;
    fillArray();
    
    selectRndMsg();
    add(lblRndMsg, BorderLayout.NORTH);
    tow.repaint();
    gp.repaint();
  }
  
  public void fillArray(){
    
    //List of random events.
    
    JLabel lbl1 = new JLabel(selectName() + " died of dysentery.");
    JLabel lbl2 = new JLabel(selectName() + " told a joke.");
    JLabel lbl3 = new JLabel(selectName() + " started to sing.");
    JLabel lbl4 = new JLabel(selectName() + " began to speak nonsense.");
    JLabel lbl5 = new JLabel(selectName() + " is deep in thought.");
    JLabel lbl6 = new JLabel(selectName() + " sneezed.");
    JLabel lbl7 = new JLabel(selectName() + " coughed.");
    JLabel lbl8 = new JLabel(selectName() + " screamed the word \"Octopus\".");
    JLabel lbl9 = new JLabel(selectName() + " looked at their cell phone.");
    JLabel lbl10 = new JLabel(selectName() + " scratched their arm.");
    JLabel lbl11 = new JLabel(selectName() + " began to pick at a scab on their leg.");
    JLabel lbl12 = new JLabel(selectName() + " tied their shoelaces.");
    
    listRndMsg.add(lbl1);
    listRndMsg.add(lbl2);
    listRndMsg.add(lbl3);
    listRndMsg.add(lbl4);
    listRndMsg.add(lbl5);
    listRndMsg.add(lbl6);
    listRndMsg.add(lbl7);
    listRndMsg.add(lbl8);
    listRndMsg.add(lbl9);
    listRndMsg.add(lbl10);
    listRndMsg.add(lbl11);
    listRndMsg.add(lbl12);
    
  }
  
  public JLabel selectRndMsg(){
    int numRnd = (int)(listRndMsg.size() * Math.random());
    lblRndMsg = listRndMsg.get(numRnd);
    return lblRndMsg;
    
  }
  
  public String selectName(){
    
    int numRnd = (int)(5 * Math.random());
    
    if (numRnd == 0 && playerHealth > 0){
      
      return playersname;
    }
    if (numRnd == 1 && varunHealth > 0){
      
      return "Varun";
    }
    if (numRnd == 2 && brianHealth > 0){
      
      return "Brian";
    }
    if (numRnd == 3 && mrSawyerHealth > 0){
      
      return "Mr. Sawyer";
    }
    if (numRnd == 4 && vikrantHealth > 0){
      
      return "Vikrant";
    }
    
    return selectName();
    
  }
  
}