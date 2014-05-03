import javax.swing.*;
import java.awt.*;

public class Runner{
  
  public static void main(String[] args){
    
    JFrame f = new JFrame();
    f.setTitle("The Sawyer Trail");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(500,500);
    Container pane = f.getContentPane();
    f.setLayout(new BorderLayout());
    
    GamePanel gp = new GamePanel();

    MainMenu mm = new MainMenu(gp);
    
    gp.add(mm);
    pane.add(gp, BorderLayout.CENTER);
    
    /*
    //******Below is for testing purposes.
    SupplySelection ss = new SupplySelection(gp,"carrot");
    
    pane.add(ss, BorderLayout.CENTER);
    //******Testing purposes end here.
    */
    
    f.setVisible(true);
    
  }
}