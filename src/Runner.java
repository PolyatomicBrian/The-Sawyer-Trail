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
    
<<<<<<< HEAD
    GamePanel gp = new GamePanel();
    MainMenu mm = new MainMenu(gp);
=======
    MainMenu objMainMenu = new MainMenu(); //Stupid mistake. Should make this a GameScreen object (or whatever) and add the MainMenu to that.
>>>>>>> 705e673e8c7bd8de760b248c5890a75970d5fb46
    
    gp.add(mm);
    pane.add(gp, BorderLayout.CENTER);
    
    f.setVisible(true);
    
  }
}
