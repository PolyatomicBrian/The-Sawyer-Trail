import javax.swing.*;
import java.awt.*;

public class Runner{
  
  public static void main(String[] args){
    JFrame f = new JFrame();
    f.setTitle("Trail");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(500,500);
    Container pane = f.getContentPane();
    pane.setLayout(new BorderLayout());
    
    MainMenu objMainMenu = new MainMenu();
    
    pane.add(objMainMenu, BorderLayout.CENTER);
    
    f.setVisible(true);
    
  }
}