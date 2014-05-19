import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel{
  private JButton btnStart = new JButton("START");
  private JButton btnQuit = new JButton("QUIT");
  private JLabel lblTitle = new JLabel("<html><font color='white'>The Sawyer Trail</font></html>");
  private GamePanel gp;
  private MainMenu mm;
  
  //Create font object
  
  public MainMenu(GamePanel tempgp){
    gp = tempgp; //Reference to GamePanel
    
    setBackground(Color.BLACK);
    setPreferredSize(new Dimension(500,500));
    setLayout(null);
    
    btnStart.setFont(GamePanel.fontType32);
    btnQuit.setFont(GamePanel.fontType32);
    
    btnStart.addActionListener(new StartGame());
    btnQuit.addActionListener(new QuitGame());
    
    btnStart.setBounds(30,300,200,90); //Sets location and size of button. (x,y,w,h) <-ints
    //Change btnStart font here. (8-bit-like font?)
    btnStart.setBackground(Color.WHITE);
    add(btnStart);
    
    btnQuit.setBounds(265,300,200,90);
    //Change btnQuit font here. (8-bit-like font?)
    btnQuit.setBackground(Color.WHITE);
    add(btnQuit);
    
    lblTitle.setFont(GamePanel.fontType32);
    lblTitle.setBounds(140,25,500,60);
    //Change font
    //Change font size
    add(lblTitle);
    
    mm = this; //Reference to MainMenu
    
  }
  
  private class StartGame implements ActionListener{
    public void actionPerformed(ActionEvent e){
      
     gp.remove(mm);
     IntroScene is = new IntroScene(gp);
     gp.add(is);
     
     gp.revalidate(); //Mandatory whenever calling the remove method. Recalculates the layout.
     gp.repaint();
    }
  }
  
  private class QuitGame implements ActionListener{
    public void actionPerformed(ActionEvent e){
      System.exit(0); //Closes application.
    }
  }
}