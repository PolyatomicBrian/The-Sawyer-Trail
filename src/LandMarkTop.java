import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMarkTop extends JPanel{
  
  private GamePanel gp;
  private OverWorld ow;
  
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
  
  //Store
  private JLabel lblStoreBlank = new JLabel("");
  private JLabel lblStoreBuy = new JLabel("Buy");
  private JLabel lblStoreSell = new JLabel("Sell");
  private JLabel lblStoreYouHave = new JLabel("You Have");
  
  private JLabel lblStoreFuel = new JLabel("Fuel: ");
  private JButton btnBuyFuel = new JButton("$40");
  private JButton btnSellFuel = new JButton("$20");
  private JLabel lblStoreFuelYouHave = new JLabel(""+GamePanel.numFuel);
  
  private JLabel lblStoreFood = new JLabel("Food:");
  private JButton btnBuyFood = new JButton("$20");
  private JButton btnSellFood = new JButton("$10");
  private JLabel lblStoreFoodYouHave = new JLabel(""+GamePanel.numFood);
  
  private JLabel lblStoreFlashDrives = new JLabel("Flash Drives:");
  private JButton btnBuyFlashDrives = new JButton("$50");
  private JButton btnSellFlashDrives = new JButton("$25");
  private JLabel lblStoreFlashDrivesYouHave = new JLabel(""+GamePanel.numFlashDrives);
  
  private JLabel lblStoreTires = new JLabel("Tires: ");
  private JButton btnBuyTires = new JButton("$30");
  private JButton btnSellTires = new JButton("$15");
  private JLabel lblStoreTiresYouHave = new JLabel(""+GamePanel.numTires);
  
  private JLabel lblStoreMufflers = new JLabel("Mufflers: ");
  private JButton btnBuyMufflers = new JButton("$30");
  private JButton btnSellMufflers = new JButton("$15");
  private JLabel lblStoreMufflersYouHave = new JLabel(""+GamePanel.numMufflers);
  
  private JLabel lblMoneyYouHave = new JLabel("You have $" + GamePanel.numMoney);
  
  private JPanel panelParty = new JPanel();
  private JPanel panelNames = new JPanel();
  private JPanel panelSuppliesAll = new JPanel();
  private JPanel panelSupplies = new JPanel();
  private JPanel panelStoreAll = new JPanel();
  private JPanel panelStore = new JPanel();
  
  private JButton btnEat = new JButton("Eat");
  
  public LandMarkTop(GamePanel tempgp){
    gp = tempgp;
    
    
    setLayout(null);
    setBackground(Color.BLACK);
    
    
    createParty();
    createSupplies();
    createStore();
    
    handleBooleans();
    
  }
  
  public void handleBooleans(){
    if (GamePanel.isParty){
      partyVis();
      updateTextSupplies();
      updateTextStore();
      updateTextParty();
    }
    
    else if (GamePanel.isSupplies){
      suppliesVis();
      updateTextSupplies();
      updateTextStore();
      updateTextParty();
    }
    else if (GamePanel.isStore){
      storeVis();
      updateTextSupplies();
      updateTextStore();
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
    
    imgCampfire = new ImageIcon("campfire.png");
    lblCampfire = new JLabel(imgCampfire);
    lblCampfire.setBounds(50,225,100,100);
    panelParty.add(lblCampfire);
    
    lblFood.setBounds(50,175,300,20);
    panelParty.add(lblFood);
    
    
    panelNames.setLayout(new GridLayout(5,2));
    
    
    
    panelNames.add(name1);
    panelNames.add(health1);
    panelNames.add(name2);
    panelNames.add(health2);
    panelNames.add(name3);
    panelNames.add(health3);
    panelNames.add(name4);
    panelNames.add(health4);
    panelNames.add(name5);
    panelNames.add(health5);
    
    panelNames.setBackground(new Color(22,145,217));
    panelNames.setBounds(300,75,200,250);
    panelParty.add(panelNames);
    
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
  
  public void createStore(){
    //Creates Store Panel
    
    panelStoreAll.setBackground(Color.YELLOW);
    
    panelStoreAll.setLayout(null);
    
    panelStore.setLayout(new GridLayout(6,4,5,5));
    
    panelStore.add(lblStoreBlank);
    panelStore.add(lblStoreBuy);
    panelStore.add(lblStoreSell);
    panelStore.add(lblStoreYouHave);
    
    btnBuyFuel.addActionListener(new HandleBtnBuyFuel());
    btnSellFuel.addActionListener(new HandleBtnSellFuel());
    
    panelStore.add(lblStoreFuel);
    panelStore.add(btnBuyFuel);
    panelStore.add(btnSellFuel);
    panelStore.add(lblStoreFuelYouHave);
    
    btnBuyFood.addActionListener(new HandleBtnBuyFood());
    btnSellFood.addActionListener(new HandleBtnSellFood());
    
    panelStore.add(lblStoreFood);
    panelStore.add(btnBuyFood);
    panelStore.add(btnSellFood);
    panelStore.add(lblStoreFoodYouHave);
    
    btnBuyFlashDrives.addActionListener(new HandleBtnBuyFlashDrives());
    btnSellFlashDrives.addActionListener(new HandleBtnSellFlashDrives());
    
    panelStore.add(lblStoreFlashDrives);
    panelStore.add(btnBuyFlashDrives);
    panelStore.add(btnSellFlashDrives);
    panelStore.add(lblStoreFlashDrivesYouHave);
    
    btnBuyTires.addActionListener(new HandleBtnBuyTires());
    btnSellTires.addActionListener(new HandleBtnSellTires());
    
    panelStore.add(lblStoreTires);
    panelStore.add(btnBuyTires);
    panelStore.add(btnSellTires);
    panelStore.add(lblStoreTiresYouHave);
    
    btnBuyMufflers.addActionListener(new HandleBtnBuyMufflers());
    btnSellMufflers.addActionListener(new HandleBtnSellMufflers());
    
    panelStore.add(lblStoreMufflers);
    panelStore.add(btnBuyMufflers);
    panelStore.add(btnSellMufflers);
    panelStore.add(lblStoreMufflersYouHave);
    
    panelStore.setBackground(Color.YELLOW);
    panelStore.setBounds(75,50,300,300);
    panelStoreAll.add(panelStore);
    
    lblMoneyYouHave.setBounds(75,20,300,20);
    panelStoreAll.add(lblMoneyYouHave);
    
    panelStoreAll.setBounds(0,0,500,425);
    
    panelStoreAll.setVisible(false);
    
    add(panelStoreAll);
    
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
    panelStoreAll.setVisible(false);
  }
  public void suppliesVis(){
    panelParty.setVisible(false);
    panelSuppliesAll.setVisible(true);
    panelStoreAll.setVisible(false);
  }
  public void storeVis(){
    panelParty.setVisible(false);
    panelSuppliesAll.setVisible(false);
    panelStoreAll.setVisible(true);
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
  
  public void updateTextStore(){
    lblStoreFuelYouHave.setText(""+GamePanel.numFuel);
    lblStoreFoodYouHave.setText(""+GamePanel.numFood);
    lblStoreFlashDrivesYouHave.setText(""+GamePanel.numFlashDrives);
    lblStoreTiresYouHave.setText(""+GamePanel.numTires);
    lblStoreMufflersYouHave.setText(""+GamePanel.numMufflers);
    lblMoneyYouHave.setText("You have $"+GamePanel.numMoney);
    
    revalidate();
    repaint();
    gp.revalidate();
    gp.repaint();
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    imgCampfire.paintIcon(this,g,50,200);
  }
  
  
  private class HandleBtnBuyFuel implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numMoney >= 40){
        GamePanel.numMoney -= 40;
        GamePanel.numFuel++;
      }
      updateTextStore();
    }
  }
  private class HandleBtnSellFuel implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numFuel > 0){
        GamePanel.numFuel--;
        GamePanel.numMoney += 20;
      }
      updateTextStore();
    }
  }
  
  private class HandleBtnBuyFood implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numMoney >= 20){
        GamePanel.numMoney -= 20;
        GamePanel.numFood += 50;
      }
      updateTextStore();
    }
  }
  private class HandleBtnSellFood implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numFood >= 50){
        GamePanel.numFood -= 50;
        GamePanel.numMoney += 10;
      }
      updateTextStore();
    }
  }
  
  private class HandleBtnBuyFlashDrives implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numMoney >= 50){
        GamePanel.numMoney -= 50;
        GamePanel.numFlashDrives++;
      }
      updateTextStore();
    }
  }
  private class HandleBtnSellFlashDrives implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numFlashDrives > 0){
        GamePanel.numFlashDrives--;
        GamePanel.numMoney += 25;
      }
      updateTextStore();
    }
  }
  private class HandleBtnBuyTires implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numMoney >= 30){
        GamePanel.numMoney -= 30;
        GamePanel.numTires++;
      }
      updateTextStore();
    }
  }
  private class HandleBtnSellTires implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numTires > 0){
        GamePanel.numTires--;
        GamePanel.numMoney += 15;
      }
      updateTextStore();
    }
  }
  private class HandleBtnBuyMufflers implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numMoney >= 30){
        GamePanel.numMoney -= 30;
        GamePanel.numMufflers++;
      }
      updateTextStore();
    }
  }
  private class HandleBtnSellMufflers implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.numMufflers > 0){
        GamePanel.numMufflers--;
        GamePanel.numMoney += 15;
      }
      updateTextStore();
    }
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
  
  
}