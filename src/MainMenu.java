import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel{
  private JButton btnStart = new JButton("START");
  private JButton btnQuit = new JButton("QUIT");
  private JLabel lblTitle = new JLabel("The Sawyer Trail");
  //Create font object
  
  public MainMenu(){
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(500,500));
    setLayout(null);
    
    btnStart.addActionListener(new StartGame());
    btnQuit.addActionListener(new QuitGame());
    
    btnStart.setBounds(25,300,200,90); //Sets location and size of button. (x,y,w,h) <-ints
    //Change btnStart font here. (8-bit-like font?)
    btnStart.setBackground(Color.WHITE);
    add(btnStart);
    
    btnQuit.setBounds(260,300,200,90);
    //Change btnQuit font here. (8-bit-like font?)
    btnQuit.setBackground(Color.WHITE);
    add(btnQuit);
    
    
    lblTitle.setBounds(185,25,500,25);
    //Change font
    //Change font size
    //Change font color
    add(lblTitle);
    
  }
  
  private class StartGame implements ActionListener{
    public void actionPerformed(ActionEvent e){
     remove(btnStart);
     remove(btnQuit);
     remove(lblTitle);
     repaint();
     //Do more stuff.
    }
  }
  
  private class QuitGame implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.exit(0); //Closes application.
    }
  }
}