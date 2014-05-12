import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMarkTop extends JPanel{
  
  JLabel name1 = new JLabel("<html><font color = 'white'>"+""+GamePanel.playersname+"</font></html>");
  JLabel name2 = new JLabel("<html><font color = 'white'>"+"Mr. Sawyer"+"</font></html>");
  JLabel name3 = new JLabel("<html><font color = 'white'>"+"Vikrant"+"</font></html>");
  JLabel name4 = new JLabel("<html><font color = 'white'>"+"Varun"+"</font></html>");
  JLabel name5 = new JLabel("<html><font color = 'white'>"+"Brian"+"</font></html>");
  
  JLabel health1 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthPlayer+"</font></html>");
  JLabel health2 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthMrSawyer+"</font></html>");
  JLabel health3 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthVikrant+"</font></html>");
  JLabel health4 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthVarun+"</font></html>");
  JLabel health5 = new JLabel("<html><font color = 'green'>"+""+GamePanel.healthBrian+"</font></html>");
  
  JLabel lblFood = new JLabel("<html><font color = 'white'>Food remaining: "+GamePanel.numFood+"</font></html>");
  
  public LandMarkTop(){
    
    setLayout(null);
    setBackground(Color.BLACK);
    
    handleBooleans();
    
  }
  
  public void handleBooleans(){
    if (GamePanel.isParty)
      createParty();
    else if (GamePanel.isSupplies)
      createSupplies();
    else if (GamePanel.isStore)
      createStore();
  }
  
  public void createParty(){
    //Creates the Party Panel
    resetPanels();
    
    setBackground(Color.BLUE);
    
    JButton btnEat = new JButton("Eat");
    btnEat.setBounds(50,75,100,75);
    btnEat.addActionListener(new HandleBtnEat());
    add(btnEat);
    
    lblFood.setBounds(50,175,300,20);
    add(lblFood);
    
    JPanel panelNames = new JPanel();
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
    add(panelNames);
    
    revalidate();
    repaint();
  }
  
  public void createSupplies(){
    //Creates Supplies Panel 
    resetPanels();
    setBackground(Color.GREEN);
    
    revalidate();
    repaint();
  }
  
  public void createStore(){
    //Creates Store Panel
    resetPanels();
    setBackground(Color.YELLOW);
    
    revalidate();
    repaint();
  }
  
  public void resetPanels(){
    removeAll(); 
  }
  
  public void updateText(){
    lblFood.setText("<html><font color = 'white'>Food remaining: "+GamePanel.numFood+"</font></html>");
    health1.setText("<html><font color = 'green'>"+""+GamePanel.healthPlayer+"</font></html>");
    health2.setText("<html><font color = 'green'>"+""+GamePanel.healthMrSawyer+"</font></html>");
    health3.setText("<html><font color = 'green'>"+""+GamePanel.healthVikrant+"</font></html>");
    health4.setText("<html><font color = 'green'>"+""+GamePanel.healthVarun+"</font></html>");
    health5.setText("<html><font color = 'green'>"+""+GamePanel.healthBrian+"</font></html>");
    
    revalidate();
    repaint();
  }
  
  private class HandleBtnEat implements ActionListener{
    public void actionPerformed(ActionEvent e){
      /*
       if (GamePanel.numFood > 0){
       if (GamePanel.healthPlayer < 100){
       if (GamePanel.healthPlayer < 95){
       GamePanel.healthPlayer+=5;
       GamePanel.numFood-=5;
       }else{
       GamePanel.numFood-=100-GamePanel.healthPlayer;
       GamePanel.healthPlayer+=100-GamePanel.healthPlayer;
       
       }
       }
       if (GamePanel.healthMrSawyer < 100){
       if (GamePanel.healthMrSawyer < 95){
       GamePanel.healthMrSawyer+=5;
       GamePanel.numFood-=5;
       }else{
       GamePanel.numFood-=100-GamePanel.healthMrSawyer;
       GamePanel.healthMrSawyer+=100-GamePanel.healthMrSawyer;
       
       }
       }
       if (GamePanel.healthVikrant < 100){
       if (GamePanel.healthVikrant < 95){
       GamePanel.healthVikrant+=5;
       GamePanel.numFood-=5;
       }else{
       GamePanel.numFood-=100-GamePanel.healthVikrant;
       GamePanel.healthVikrant+=100-GamePanel.healthVikrant;
       
       }
       }
       if (GamePanel.healthVarun < 100){
       if (GamePanel.healthVarun < 95){
       GamePanel.healthVarun+=5;
       GamePanel.numFood-=5;
       }else{
       GamePanel.numFood-=100-GamePanel.healthVarun;
       GamePanel.healthVarun+=100-GamePanel.healthVarun;
       
       }
       }
       if (GamePanel.healthBrian < 100){
       if (GamePanel.healthBrian < 95){
       GamePanel.healthBrian+=5;
       GamePanel.numFood-=5;
       }else{
       GamePanel.numFood-=100-GamePanel.healthBrian;
       GamePanel.healthBrian+=100-GamePanel.healthBrian;
       
       }
       }
       }
       */
      
      
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
      
      
      updateText();
    }
  }
  
}