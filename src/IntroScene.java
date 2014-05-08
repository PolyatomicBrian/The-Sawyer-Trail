import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntroScene extends JPanel{
  
  private javax.swing.Timer timer;
  private JLabel lblIntro = new JLabel("Welcome to The Sawyer Trail!");
  private TextField txtName = new TextField();
  private JButton btnNameEntered = new JButton("I have entered my name.");
  private String playersName;
  private GamePanel gp;
  private IntroScene is;
  private int count = 0;
  
  
  public IntroScene(GamePanel tempgp){
    lblIntro.setForeground(Color.WHITE);
    
    gp = tempgp; //Reference to GamePanel.
    
    setBackground(Color.GRAY);
    setPreferredSize(new Dimension(500,500));
    setLayout(null);
    
    lblIntro.setBounds(150,25,500,20);
    add(lblIntro);
    
    timer = new javax.swing.Timer(2100, new TimerListener());
    
    is = this; //Reference to IntroScene.
    
    timer.start();
  }
  
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      count++;
      if (count == 1){
        lblIntro.setBounds(125,25,500,20);
        lblIntro.setText("It's finally time for UPenn's Hack-A-Thon!");
      }else if (count == 2){
        lblIntro.setBounds(100,25,500,20);
        lblIntro.setText("You are to journey with the following people to Penn State:");
      }else if (count == 3){
        lblIntro.setBounds(225,25,500,20);
        lblIntro.setText("Varun");
        //Show image of Varun
      }else if (count == 4){
        lblIntro.setText("Brian");
        //Show image of Brian
      }else if (count == 5){
        lblIntro.setBounds(205,25,500,20);
        lblIntro.setText("Mr. Sawyer");
        //Show image of Mr. Sawyer
      }else if (count == 6){
        lblIntro.setBounds(175,25,500,20);
        lblIntro.setText("And of course, Vikrant.");
        //Show image of Vikrant
      }else if (count == 7){
        lblIntro.setBounds(175,25,500,20);
        lblIntro.setText("What is your name?");
        enterName();
      }else if (count == 8){
        lblIntro.setBounds(100,25,500,20);
        lblIntro.setText("Well, " + playersName + ", why don't you go get some supplies?");
      }else if (count >= 10){
        gotoSupplySelection();
      }
    }
    
    public void enterName(){
      timer.stop();
      txtName.setBounds(100,300,300,40);
      is.add(txtName);
      btnNameEntered.setBounds(105,350,300,40);
      btnNameEntered.addActionListener(new HandleButtonNameEntered());
      is.add(btnNameEntered);
      is.repaint();
    }
    
    public void gotoSupplySelection(){
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
      playersName = txtName.getText();
      remove(txtName);
      remove(btnNameEntered);
      is.revalidate();
      is.repaint();
      timer.start();
    }
  }
}