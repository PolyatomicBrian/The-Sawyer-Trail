import javax.swing.*;
import java.awt.*;

public class Runner{
  
  //CURRENT OBJECTIVE:
  //Get RndEvent to affect inventory properly.
  
  public static void main(String[] args){
    
    JFrame f = new JFrame();
    f.setTitle("The Sawyer Trail");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(500,500);
    f.setResizable(false);
    Container pane = f.getContentPane();
    f.setLayout(new BorderLayout());
    
    GamePanel gp = new GamePanel();
    
    
     MainMenu mm = new MainMenu(gp);
     
     gp.add(mm);
     pane.add(gp, BorderLayout.CENTER);
     
    
    
    
    /*
    //****Below is for testing purposes.
    SupplySelection ss = new SupplySelection(gp,"carrot");
    
    gp.add(ss);
    pane.add(gp, BorderLayout.CENTER);
    */
    
    
    
    /*
     OverWorld ow = new OverWorld(gp);
     GamePanel.overWorldVisible = true;
     gp.add(ow);
     pane.add(gp, BorderLayout.CENTER);
     */
    
     
    
    f.setVisible(true);
    
    
  }
}
