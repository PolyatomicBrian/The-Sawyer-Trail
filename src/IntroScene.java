import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntroScene extends JPanel{
  
  private javax.swing.Timer timer;
  private JLabel lblIntro = new JLabel("Welcome to The Sawyer Trail!");
  private MyJButton btnSkip = new MyJButton("Done");
  private TextField txtName = new TextField();
  private MyJButton btnNameEntered = new MyJButton("I have entered my name.");
  private String playersName;
  private GamePanel gp;
  private IntroScene is;
  private int count = 0;
  private JTextArea area = new JTextArea();
  private String inst;
  private JScrollPane scroll;
  
  private JLabel lblImage = new JLabel();
  private ImageIcon imgUPenn = new ImageIcon("upenn.png");
  private ImageIcon imgSawyer = new ImageIcon("imgSawyer.png");
  private ImageIcon imgVikrant = new ImageIcon("imgVikrant.png");
  private ImageIcon imgVarun = new ImageIcon("imgVarun.png");
  private ImageIcon imgBrian = new ImageIcon("imgBrian.png");
  
  public IntroScene(GamePanel tempgp){
    lblIntro.setForeground(Color.WHITE);
    lblIntro.setFont(GamePanel.fontType16);
    gp = tempgp; //Reference to GamePanel.
    
    setBackground(Color.GRAY);
    setPreferredSize(new Dimension(500,500));
    setLayout(null);
    
    lblIntro.setBounds(110,25,500,80);
    add(lblIntro);
    
    lblImage.setBounds(150,150,200,200);
    add(lblImage);
    
    btnSkip.setBounds(350,400,80,30);
    btnSkip.addActionListener(new HandleBtnSkip());
    add(btnSkip);
    
    
    area.setFont(GamePanel.fontType16);
    area.setEditable(false);
    area.setWrapStyleWord(true);
    area.setLineWrap(true);
    scroll = new JScrollPane(area);
    scroll.setPreferredSize(new Dimension(350,275));
    scroll.setBounds(75,100,350,275);
    
    timer = new javax.swing.Timer(2100, new TimerListener());
    
    is = this; //Reference to IntroScene.
    
    timer.start();
  }
  
  
  private void setInst(){
    inst = "Instructions:\n\n"+
      "\nFuel is a must. 8 fuels will get you from landmark-to-landmark.\n"+
      "\nFood is also a must. Every 50 units traveled, all the living characters in the vehicle will grow more hungry. Food prevents death.\n"+
      "\nFlash Drives are used for gambling. You can \"CODE\" with them, which gives you a random item.\n"+
      "\nMoney can be spent at the STORE to purchase more supplies.\n"+
      "\nTires and Mufflers do absolutely nothing and are used merely as an extra currency. Unless you like Tires and Mufflers, I mean.\n"+
      "\nThe tabs on the bottom of the screen, HEALTH, STATS, and STOP, present separate information.\n"+
      "\nHEALTH shows you the current health of each character. Check this tab often!\n"+
      "\nSTATS shows you the current supplies you possess, along with the distance to the next landmark.\n"+
      "\nSTOP takes you to a stopping point, allowing you to feed the characters, CODE using flash drives, or WAIT to see if you might stumble upon an item.\n"+
      "\nThere are 5 landmarks you will reach prior to arriving at UPenn.\n"+
      "\nNow, " + playersName + ", go grab some supplies!\n";
  }
  
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    //imgUPenn.paintIcon(this,g,200,150);
  }
  
  
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      
      count++;
      
      if (count == 1){
        lblIntro.setBounds(90,25,500,80);
        lblIntro.setText("<html>It's finally time for UPenn's<br><center>Hack-A-Thon!</center></html>");
        // lblImage = new JLabel(imgUPenn);
        lblImage.setIcon(imgUPenn);
      }else if (count == 2){
        lblIntro.setBounds(60,25,500,80);
        lblIntro.setText("<html>You are to journey with the following<br><center>people to the university:</center></html>");
      }else if (count == 3){
        lblIntro.setBounds(225,25,500,80);
        lblIntro.setText("Varun");
        lblImage.setIcon(imgVarun);
        //Show image of Varun
      }else if (count == 4){
        lblIntro.setText("Brian");
        lblImage.setIcon(imgBrian);
        //Show image of Brian
      }else if (count == 5){
        lblIntro.setBounds(205,25,500,80);
        lblIntro.setText("Mr. Sawyer");
        lblImage.setIcon(imgSawyer);
        lblImage.setBounds(175,150,200,200);
        //Show image of Mr. Sawyer
      }else if (count == 6){
        lblIntro.setBounds(145,25,500,80);
        lblIntro.setText("And of course, Vikrant.");
        lblImage.setIcon(imgVikrant);
        //Show image of Vikrant
      }else if (count == 7){
        lblIntro.setBounds(155,25,500,80);
        lblIntro.setText("What is your name?");
        lblImage.setBounds(999,999,0,0);
        lblImage.setIcon(null);
        enterName();
      }else if (count >= 8){
        lblIntro.setBounds(105,25,500,80);
        lblIntro.setText("<html>Well, " + playersName + ", here are some<br><center>instructions to read.</center></html>");
        add(scroll);
        gp.revalidate();
        gp.repaint();
        is.revalidate();
        is.repaint();
      }
      is.revalidate();
      is.repaint();
      gp.revalidate();
      gp.repaint();
    }
    
    public void enterName(){
      timer.stop();
      txtName.setBounds(100,300,300,40);
      is.add(txtName);
      btnNameEntered.setBounds(100,350,300,40);
      btnNameEntered.addActionListener(new HandleButtonNameEntered());
      is.add(btnNameEntered);
      is.repaint();
    }
    
  }
  
  private class HandleBtnSkip implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.playersname.equals("Mr. Null")){
        GamePanel.playersname = "Skipper";
      }
      timer.stop();
      
      gp.remove(is);
      SupplySelection ss = new SupplySelection(gp, playersName);
      gp.add(ss);
      gp.revalidate();
      gp.repaint();
    }
  }
  
  
  private class HandleButtonNameEntered implements ActionListener{
    public void actionPerformed(ActionEvent e){
      GamePanel.playersname = txtName.getText();
      if (GamePanel.playersname.equals("")){
        GamePanel.playersname = "Mr. No-Name";
      }
      playersName = GamePanel.playersname;
      remove(txtName);
      remove(btnNameEntered);
      
      setInst();
      area.setText(inst);
      
      is.revalidate();
      is.repaint();
      timer.start();
    }
  }
}