import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RndEvent extends JPanel{
  
  private JLabel lblRndMsg = new JLabel("<html><font color = 'white'>Temp</font></html>");
  private ArrayList<JLabel> listRndMsg = new ArrayList<JLabel>();
  private String playersname;
  private int playerHealth;
  private int varunHealth;
  private int brianHealth;
  private int mrSawyerHealth;
  private int vikrantHealth;
  
  private int supplyNum;
  private String supplyName;
  private int indexMsg;

  private boolean canRndNum = true;
  private boolean canRndSelectMsg = true;
  private int rndSupplyNum = (int)(6 * Math.random());

  private boolean msgSelector = true;
  
  public RndEvent(String tempplayersname, int tempPlayerHealth, int tempVarunHealth, int tempBrianHealth, int tempMrSawyerHealth, int tempVikrantHealth){
 
    playersname = tempplayersname;
    
    setLayout(new BorderLayout());
    setBackground(Color.WHITE);
    
    playerHealth = tempPlayerHealth;
    varunHealth = tempVarunHealth;
    brianHealth = tempBrianHealth;
    mrSawyerHealth = tempMrSawyerHealth;
    vikrantHealth = tempVikrantHealth;
    fillArray();
    
    
    if (canRndSelectMsg){
      if (GamePanel.healthVikrant > 0){
        
        lblRndMsg.setText("Vikrant has died of dysentery.");
        //lblRndMsg.setText("Mr. Sawyer mentioned something about Bob Saget.");
        lblRndMsg.setHorizontalAlignment(SwingConstants.CENTER);
        lblRndMsg.setVerticalAlignment(SwingConstants.CENTER);
        
        GamePanel.healthVikrant = 0;
        
      }else{
        selectRndMsg();
        canRndSelectMsg = false;
      }
    }
   
    
    if (indexMsg >= 15)
      modifySuppliesGood();
    
    lblRndMsg.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
    
    add(lblRndMsg);
    repaint();
  }
  
  public void fillArray(){
    
    //List of random events.
    
    //Trivial or Humorous
    JLabel lbl1 = new JLabel(selectName() + " contemplated life.");
    JLabel lbl2 = new JLabel(selectName() + " told a joke.");
    JLabel lbl3 = new JLabel(selectName() + " started to sing.");
    JLabel lbl4 = new JLabel(selectName() + " began to speak nonsense.");
    JLabel lbl5 = new JLabel(selectName() + " is deep in thought.");
    JLabel lbl6 = new JLabel(selectName() + " sneezed.");
    JLabel lbl7 = new JLabel(selectName() + " coughed.");
    JLabel lbl8 = new JLabel(selectName() + " screamed the word \""+randomWord()+"\".");
    JLabel lbl9 = new JLabel(selectName() + " looked at their cell phone.");
    JLabel lbl10 = new JLabel(selectName() + " scratched their arm.");
    JLabel lbl11 = new JLabel(selectName() + " began to pick at a scab on their leg.");
    JLabel lbl12 = new JLabel(selectName() + " tied their shoelaces.");
    JLabel lbl13 = new JLabel(selectName() + "'s stomach growled.");
    JLabel lbl14 = new JLabel(selectName() + " mentioned something about "+randomWord()+".");
    JLabel lbl15 = new JLabel(selectName() + " belched.");
    JLabel lbl16 = new JLabel(selectName() + " rambled on about " + randomWord()+".");
    
    
    //Game affecting
    /*
    //Bad
    JLabel lbl16 = new JLabel(selectName() + " accidentally ruined " + selectSupply());
    JLabel lbl17 = new JLabel(selectName() + " sat on and destroyed " + selectSupply());
    JLabel lbl18 = new JLabel(selectName() + " threw " + selectSupply() + " out the window.");
    JLabel lbl19 = new JLabel(selectName() + " ate " + selectSupply() + ". Have fun digesting it.");
    JLabel lbl20 = new JLabel(selectSupply() + " blew out the window.");
    JLabel lbl21 = new JLabel(selectSupply() + " went bad.");
    */
    
    //Good
    JLabel lbl22 = new JLabel(selectName() + " found " + selectSupplyGood());
    JLabel lbl23 = new JLabel(selectName() + " stumbled upon " + selectSupplyGood());
    JLabel lbl24 = new JLabel(selectName() + " remembered there were " + selectSupplyGood() + " in the trunk.");
    JLabel lbl25 = new JLabel(selectName() + " pulled " + selectSupplyGood() + " from under the seats.");
    JLabel lbl26 = new JLabel(selectName() + " had " + selectSupplyGood() + " in their pockets.");
    
    
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
    listRndMsg.add(lbl13);
    listRndMsg.add(lbl14);
    listRndMsg.add(lbl15);
    listRndMsg.add(lbl16);
    
    /*
    listRndMsg.add(lbl16);
    listRndMsg.add(lbl17);
    listRndMsg.add(lbl18);
    listRndMsg.add(lbl19);
    listRndMsg.add(lbl20);
    listRndMsg.add(lbl21);
    */
    
    listRndMsg.add(lbl22);
    listRndMsg.add(lbl23);
    listRndMsg.add(lbl24);
    listRndMsg.add(lbl25);
    listRndMsg.add(lbl26);
   
    
  }
  
  public JLabel selectRndMsg(){

    if (msgSelector){
      msgSelector = false;
      int numRnd = (int)(listRndMsg.size() * Math.random());
      lblRndMsg = listRndMsg.get(numRnd);
      indexMsg = numRnd;
      lblRndMsg.setHorizontalAlignment(SwingConstants.CENTER);
      lblRndMsg.setVerticalAlignment(SwingConstants.CENTER);
      return lblRndMsg;
    }

    return lblRndMsg;
  }
  
  public String selectNumSupply(int maxNum){
    int numRnd = 0;
    
    if (maxNum == 0)
      maxNum = 50;
    
    if (canRndNum){
      
      numRnd = (int)((maxNum / 2) * Math.random() + 1);
      
      
      supplyNum = numRnd;
      canRndNum = false;
      
    }
    return ""+numRnd;
  }
  
  /*Method below cut from final game.
   * Intended to allow player to lose a random supply.
   
  public String selectSupply(){    
    
    int numRnd = rndSupplyNum; 
    
    if (canRndName){
      numRnd = (int)(6 * Math.random());
      canRndName = false;
    }
    
    if (GamePanel.numFuel <= 0 && GamePanel.numFood <= 0 && GamePanel.numFlashDrives <= 0 && GamePanel.numMoney <= 0 && GamePanel.numTires <= 0 && GamePanel.numMufflers <= 0){
      canRndName = false;
      isNothing = true;
      return "nothing";
    }
    
    if (numRnd == 0 && GamePanel.numFuel > 0){
      supplyName = " fuel";
      selectNumSupply(GamePanel.numFuel);
      canRndName = false;
      //modifySuppliesBad();
      return supplyNum + supplyName;
      // return selectNumSupply(GamePanel.numFuel) + supplyName;
    }
    else if (numRnd == 1 && GamePanel.numFood > 0){
      supplyName = " food";
      selectNumSupply(GamePanel.numFood);
      canRndName = false;
      //modifySuppliesBad();
      return supplyNum + supplyName;
      // return selectNumSupply(GamePanel.numFood) + supplyName;
    }
    else if (numRnd == 2 && GamePanel.numFlashDrives > 0){
      supplyName = " flash drives";
      selectNumSupply(GamePanel.numFlashDrives);
      canRndName = false;
      //modifySuppliesBad();
      return supplyNum + supplyName;
      //   return selectNumSupply(GamePanel.numFlashDrives) + supplyName;
    }
    else if (numRnd == 3 && GamePanel.numMoney > 0){
      supplyName = " money";
      selectNumSupply(GamePanel.numMoney);
      canRndName = false;
      //modifySuppliesBad();
      return supplyNum + supplyName;
      //   return selectNumSupply(GamePanel.numMoney) + supplyName;
    }
    else if (numRnd == 4 && GamePanel.numTires > 0){
      supplyName = " tires";
      selectNumSupply(GamePanel.numTires);
      canRndName = false;
      //modifySuppliesBad();
      return supplyNum + supplyName;
      //  return selectNumSupply(GamePanel.numTires) + supplyName;
    }
    else if (numRnd == 5 && GamePanel.numMufflers > 0){
      supplyName = " mufflers";
      selectNumSupply(GamePanel.numMufflers);
      canRndName = false;
      //modifySuppliesBad();
      return supplyNum + supplyName;
      //return selectNumSupply(GamePanel.numMufflers) + supplyName;
    }
    else{
      canRndName = true;
      return selectSupply();
    }
  }
*/
  
  
  
  public String randomWord(){
    int numRnd = (int)(5 * Math.random());
    String rndWord = "Cat";
    
    if (numRnd == 0)
      rndWord = "Octopus";
    else if (numRnd == 1)
      rndWord = "Bob Saget";
    else if (numRnd == 2)
      rndWord = "Carrot";
    else if (numRnd == 3)
      rndWord = "Computer";
    else if (numRnd == 4)
      rndWord = "Java";
    else if (numRnd == 5)
      rndWord = "Snoo";
    
    return rndWord;
    
  }
  
  public String selectSupplyGood(){
    int numRnd = rndSupplyNum;
    
    if (GamePanel.numFuel <= 0){
      numRnd = (int)(3 * Math.random());
    }
    
    if (numRnd == 0){
      supplyName = " fuel";
      selectNumSupply(GamePanel.numFuel);
    }
    else if (numRnd == 1){
      supplyName = " food";
      selectNumSupply(GamePanel.numFood);
    }
    else if (numRnd == 2){
      supplyName = " flash drives";
      selectNumSupply(GamePanel.numFlashDrives);
    }
    else if (numRnd == 3){
      supplyName = " money";
      selectNumSupply(GamePanel.numMoney);
    }
    else if (numRnd == 4){
      supplyName = " tires";
      selectNumSupply(GamePanel.numTires);
    }
    else if (numRnd == 5){
      supplyName = " mufflers";
      selectNumSupply(GamePanel.numMufflers);
    }
    else{
      return selectSupplyGood();
    }
    
    
    return supplyNum + supplyName;
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
  
  /*Cut from final game. Worked with SupplySelection() by actually removing the supply.
   * 
  private void modifySuppliesBad(){
    //  if (indexMsg >= 15 && indexMsg <= 20){
    if (supplyName.equals(" fuel"))
      GamePanel.numFuel -= supplyNum;
    else if (supplyName.equals(" food"))
      GamePanel.numFood -= supplyNum;
    else if (supplyName.equals(" flash drives"))
      GamePanel.numFlashDrives -= supplyNum;
    else if (supplyName.equals(" money"))
      GamePanel.numMoney -= supplyNum;
    else if (supplyName.equals(" tires"))
      GamePanel.numTires -= supplyNum;
    else if (supplyName.equals(" mufflers"))
      GamePanel.numMufflers -= supplyNum;
    //   }
  }
  */
  
  private void modifySuppliesGood(){
    
    if (supplyName.equals(" fuel"))
      GamePanel.numFuel += supplyNum;
    else if (supplyName.equals(" food"))
      GamePanel.numFood += supplyNum;
    else if (supplyName.equals(" flash drives"))
      GamePanel.numFlashDrives += supplyNum;
    else if (supplyName.equals(" money"))
      GamePanel.numMoney += supplyNum;
    else if (supplyName.equals(" tires"))
      GamePanel.numTires += supplyNum;
    else if (supplyName.equals(" mufflers"))
      GamePanel.numMufflers += supplyNum;
    
  }
  
  public int msgWidth(){
    return lblRndMsg.getWidth();
  }
  
  public int msgHeight(){
    return lblRndMsg.getHeight();
  }
  
  
}