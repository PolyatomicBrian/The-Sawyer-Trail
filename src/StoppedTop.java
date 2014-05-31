import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoppedTop extends JPanel{
  
  private GamePanel gp;
  private OverWorld ow;
  private javax.swing.Timer timerDispMsg;
  private javax.swing.Timer timerRemoveMsg;
  
  //Party
  private JLabel name1 = new JLabel("<html><font color = 'white'>"+GamePanel.playersname+"</font></html>");
  private JLabel name2 = new JLabel("<html><font color = 'white'>Mr. Sawyer</font></html>");
  private JLabel name3 = new JLabel("<html><font color = 'white'>Vikrant</font></html>");
  private JLabel name4 = new JLabel("<html><font color = 'white'>Varun</font></html>");
  private JLabel name5 = new JLabel("<html><font color = 'white'>Brian</font></html>");
  
  private JLabel health1 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthPlayer+"</font></html>");
  private JLabel health2 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthMrSawyer+"</font></html>");
  private JLabel health3 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthVikrant+"</font></html>");
  private JLabel health4 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthVarun+"</font></html>");
  private JLabel health5 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthBrian+"</font></html>");
  
  private  JLabel lblFood = new JLabel("<html><font color = 'white'>Food remaining: "+GamePanel.numFood+"</font></html>");
  
  private ImageIcon imgCampfire;
  private JLabel lblCampfire;
  
  //Supplies
  private JLabel lblSupplyFuel = new JLabel("Fuel: " + GamePanel.numFuel);
  private JLabel lblSupplyFood = new JLabel("Food: " + GamePanel.numFood);
  private JLabel lblSupplyFlashDrives = new JLabel("Flash Drives: " + GamePanel.numFlashDrives);
  private JLabel lblSupplyMoney = new JLabel("Money: " + GamePanel.numMoney);
  private JLabel lblSupplyTires = new JLabel("Tires: " + GamePanel.numTires);
  private JLabel lblSupplyMufflers = new JLabel("Mufflers: " + GamePanel.numMufflers);
  private JButton btnCode = new JButton("Code");
  
  //Wait
  private JLabel waitname1 = new JLabel("<html><font color = 'white'>"+GamePanel.playersname+"</font></html>");
  private JLabel waitname2 = new JLabel("<html><font color = 'white'>Mr. Sawyer</font></html>");
  private JLabel waitname3 = new JLabel("<html><font color = 'white'>Vikrant</font></html>");
  private JLabel waitname4 = new JLabel("<html><font color = 'white'>Varun</font></html>");
  private JLabel waitname5 = new JLabel("<html><font color = 'white'>Brian</font></html>");
  
  private JLabel waithealth1 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthPlayer+"</font></html>");
  private JLabel waithealth2 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthMrSawyer+"</font></html>");
  private JLabel waithealth3 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthVikrant+"</font></html>");
  private JLabel waithealth4 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthVarun+"</font></html>");
  private JLabel waithealth5 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthBrian+"</font></html>");
  
  private RndEvent re;
  
  private JPanel panelParty = new JPanel();
  private JPanel panelNamesParty = new JPanel();
  private JPanel panelSuppliesAll = new JPanel();
  private JPanel panelSupplies = new JPanel();
  private JPanel panelWaitAll = new JPanel();
  private JPanel panelWait = new JPanel();
  private JPanel panelWaitNames = new JPanel();
  
  private JButton btnEat = new JButton("Eat Food");
  private JButton btnWait = new JButton("Wait");
  
  private int countDispDelay;
  private boolean canWait = true;
  private JLabel lblMustWait = new JLabel("<html><font color = 'white'></html></font>");
  private String strPeriods = "";
  
  public StoppedTop(GamePanel tempgp){
    gp = tempgp;
    
    setLayout(null);
    setBackground(Color.BLACK);
    
    timerDispMsg = new javax.swing.Timer(200, new TimerDispListener());
    timerRemoveMsg = new javax.swing.Timer(2000, new TimerRemoveListener());
    
    createParty();
    createSupplies();
    createWait();
    
    handleBooleans();
    
  }
  
  public void handleBooleans(){
    if (GamePanel.isParty){
      partyVis();
      updateTextSupplies();
      updateTextParty();
    }
    
    else if (GamePanel.isSupplies){
      suppliesVis();
      updateTextSupplies();
      updateTextParty();
    }
    else if (GamePanel.isWait){
      storeVis();
      updateTextSupplies();
      updateTextParty();
    } 
  }
  
  public void createParty(){
    //Creates the Party Panel
    
    panelParty.setBackground(Color.BLUE);
    
    panelParty.setLayout(null);
    
    btnEat.setBounds(50,75,100,75);
    btnEat.addActionListener(new HandleBtnEat());
    panelParty.add(btnEat);
    
    lblFood.setBounds(50,175,300,20);
    panelParty.add(lblFood);
    
    imgCampfire = new ImageIcon("campfire.png");
    lblCampfire = new JLabel(imgCampfire);
    lblCampfire.setBounds(50,225,100,100);
    panelParty.add(lblCampfire);
    
    panelNamesParty.setBackground(new Color(22,145,217));
    panelNamesParty.setLayout(new GridLayout(5,2));
    
    panelNamesParty.add(name1);
    panelNamesParty.add(health1);
    panelNamesParty.add(name2);
    panelNamesParty.add(health2);
    panelNamesParty.add(name3);
    panelNamesParty.add(health3);
    panelNamesParty.add(name4);
    panelNamesParty.add(health4);
    panelNamesParty.add(name5);
    panelNamesParty.add(health5);
    
    
    panelNamesParty.setBounds(300,75,200,250);
    panelParty.add(panelNamesParty);
    
    panelParty.setBounds(0,0,500,425);
    
    add(panelParty);
    
    revalidate();
    repaint();
  }
  
  public void createSupplies(){
    //Creates Supplies Panel 
    
    panelSuppliesAll.setBackground(Color.GREEN);
    
    panelSuppliesAll.setLayout(null);
    
    btnCode.setBounds(50,75,100,75);
    btnCode.addActionListener(new HandleBtnCode());
    panelSuppliesAll.add(btnCode);
    
    
    panelSupplies.setLayout(new GridLayout(6,1));
    
    
    panelSupplies.add(lblSupplyFuel);
    panelSupplies.add(lblSupplyFood);
    panelSupplies.add(lblSupplyFlashDrives);
    panelSupplies.add(lblSupplyMoney);
    panelSupplies.add(lblSupplyTires);
    panelSupplies.add(lblSupplyMufflers);
    
    panelSupplies.setBackground(new Color(255,102,0));
    panelSupplies.setBounds(300,75,200,250);
    
    panelSuppliesAll.add(panelSupplies);
    
    panelSuppliesAll.setBounds(0,0,500,425);
    
    add(panelSuppliesAll);
    
    revalidate();
    repaint();
  }
  
  public void createWait(){
    
    panelWait.setBackground(Color.RED);
    
    panelWait.setLayout(null);
    
    btnWait.setBounds(50,75,100,75);
    btnWait.addActionListener(new HandleBtnWait());
    panelWait.add(btnWait);
    
    panelWaitNames.setLayout(new GridLayout(5,2));
    
    panelWaitNames.add(waitname1);
    panelWaitNames.add(waithealth1);
    panelWaitNames.add(waitname2);
    panelWaitNames.add(waithealth2);
    panelWaitNames.add(waitname3);
    panelWaitNames.add(waithealth3);
    panelWaitNames.add(waitname4);
    panelWaitNames.add(waithealth4);
    panelWaitNames.add(waitname5);
    panelWaitNames.add(waithealth5);
    
    panelWaitNames.setBackground(new Color(79,213,214));
    //panelWaitNames.setBackground(Color.
    panelWaitNames.setBounds(300,75,200,250);
    
    panelWait.add(panelWaitNames);
    
    lblMustWait.setBounds(50,200,500,20);
    panelWait.add(lblMustWait);
    
    panelWait.setBounds(0,0,500,425);
    
    add(panelWait);
    
    revalidate();
    repaint();
  }
  
  public void resetPanels(){
    removeAll(); 
  }
  
  public void code(){
    GamePanel.numFlashDrives--;
    //give random item(s)
    //0 = fuel
    //1 = food
    //2 = fuel (yes, again)
    //3 = money
    //4 = tire
    //5 = muffler
    
    int numSelect = (int)(6 * Math.random());
    int numAmount;
    if (numSelect == 0 || numSelect == 2 || numSelect == 4 || numSelect == 5){
      numAmount = (int)(4 * Math.random() + 1);
    }else{
      numAmount = (int)(41 * Math.random() + 10);
    }
    if (numSelect == 0 || numSelect == 2){
      GamePanel.numFuel += numAmount;
    }else if (numSelect == 1){
      GamePanel.numFood += numAmount;
    }else if (numSelect == 3){
      GamePanel.numMoney += numAmount;
    }else if (numSelect == 4){
      GamePanel.numTires += numAmount;
    }else if (numSelect == 5){
      GamePanel.numMufflers += numAmount;
    }
  }
  
  public void partyVis(){
    panelParty.setVisible(true);
    panelSuppliesAll.setVisible(false);
    panelWaitAll.setVisible(false);
  }
  public void suppliesVis(){
    panelParty.setVisible(false);
    panelSuppliesAll.setVisible(true);
    panelWaitAll.setVisible(false);
  }
  public void storeVis(){
    panelParty.setVisible(false);
    panelSuppliesAll.setVisible(false);
    panelWaitAll.setVisible(true);
  }
  
  
  public void updateTextSupplies(){
    lblSupplyFuel.setText("Fuel: " + GamePanel.numFuel);
    lblSupplyFood.setText("Food: " + GamePanel.numFood);
    lblSupplyFlashDrives.setText("Flash Drives: " + GamePanel.numFlashDrives);
    lblSupplyMoney.setText("Money: " + GamePanel.numMoney);
    lblSupplyTires.setText("Tires: " + GamePanel.numTires);
    lblSupplyMufflers.setText("Mufflers: " + GamePanel.numMufflers);
    
    gp.revalidate();
    gp.repaint();
  }
  
  
  public void updateTextParty(){
    lblFood.setText("<html><font color = 'white'>Food remaining: "+GamePanel.numFood+"</font></html>");
    health1.setText("<html><font color = 'green'>"+GamePanel.healthPlayer+"</font></html>");
    health2.setText("<html><font color = 'green'>"+GamePanel.healthMrSawyer+"</font></html>");
    health3.setText("<html><font color = 'green'>"+GamePanel.healthVikrant+"</font></html>");
    health4.setText("<html><font color = 'green'>"+GamePanel.healthVarun+"</font></html>");
    health5.setText("<html><font color = 'green'>"+GamePanel.healthBrian+"</font></html>");
    
    revalidate();
    repaint();
  }
  
  public void updateTextWait(){
    for (int i = 0; i<=countDispDelay; i++){
      if (i%2 == 0)
        strPeriods += ".";
      lblMustWait.setText("<html><font color = 'white'>Waiting" + strPeriods + "</html></font>");
    }
    revalidate();
    repaint();
  }
  
  
  
  
  private class HandleBtnEat implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.healthPlayer < 100 && GamePanel.numFood > 0 && GamePanel.healthPlayer > 0){
        GamePanel.healthPlayer++;
        GamePanel.numFood--;
      }
      if (GamePanel.healthMrSawyer < 100 && GamePanel.numFood > 0 && GamePanel.healthMrSawyer > 0){
        GamePanel.healthMrSawyer++;
        GamePanel.numFood--;
      }
      if (GamePanel.healthVikrant < 100 && GamePanel.numFood > 0 && GamePanel.healthVikrant > 0){
        GamePanel.healthVikrant++;
        GamePanel.numFood--;
      }
      if (GamePanel.healthVarun < 100 && GamePanel.numFood > 0 && GamePanel.healthVarun > 0){
        GamePanel.healthVarun++;
        GamePanel.numFood--;
      }
      if (GamePanel.healthBrian < 100 && GamePanel.numFood > 0 && GamePanel.healthBrian > 0){
        GamePanel.healthBrian++;
        GamePanel.numFood--;
      }
      
      updateWaitStats();
      updateTextParty();
    }
  }
  
  private class HandleBtnCode implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numFlashDrives > 0){
        code();
        updateTextSupplies();
      }
    }
  }
  
  private class HandleBtnWait implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (canWait){
        doRandomEvent();
        Background.loseHealth();
        updateWaitStats();
        updateTextParty();
      }
    }
  }
  
  public void updateWaitStats(){
    waithealth1.setText("<html><font color = 'green'>"+""+GamePanel.healthPlayer+"</font></html>");
    waithealth2.setText("<html><font color = 'green'>"+""+GamePanel.healthMrSawyer+"</font></html>");
    waithealth3.setText("<html><font color = 'green'>"+""+GamePanel.healthVikrant+"</font></html>");
    waithealth4.setText("<html><font color = 'green'>"+""+GamePanel.healthVarun+"</font></html>");
    waithealth5.setText("<html><font color = 'green'>"+""+GamePanel.healthBrian+"</font></html>"); 
  }
  
  private void doRandomEvent(){
    
    canWait = false;
    timerDispMsg.start();
    re = new RndEvent(GamePanel.playersname, GamePanel.healthPlayer, GamePanel.healthVarun, GamePanel.healthBrian, GamePanel.healthMrSawyer, GamePanel.healthVikrant);
    
    revalidate();
    repaint();
    gp.revalidate();
    gp.repaint();
    
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    imgCampfire.paintIcon(this,g,50,200);
  }
  
  
  private class TimerDispListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      countDispDelay++;
      if (countDispDelay == 12){
        gp.add(re, BorderLayout.NORTH);
        countDispDelay = 0;
        
        lblMustWait.setText("<html><font color = 'white'></html></font>");
        strPeriods = "";
        
        timerRemoveMsg.start();
        gp.revalidate();
        gp.repaint();
        timerDispMsg.stop();
      }
      if (countDispDelay > 0)
        updateTextWait();
    }
  }
  
  private class TimerRemoveListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      canWait = true;
      gp.remove(re);
      timerRemoveMsg.stop();
    }
  }
  
  
}