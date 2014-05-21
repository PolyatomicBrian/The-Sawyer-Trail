import javax.swing.*;
import java.awt.*;

public class Runner{
  
  /*REMAINING OBJECTIVES:
   * Get GameOver "play again" working properly. (Timer, etc)
   * Add fonts.
   * Add instructions.
   * Add art.
   * Add music.
   * Debug more and more and more.
   * Make code look nicer.
   */
  
  
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
    EndingScene es = new EndingScene(gp);
    gp.add(es);
    pane.add(gp);
    */
    
    f.setVisible(true);
    
    
  }
}
