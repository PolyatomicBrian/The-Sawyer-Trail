import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel{
  
  private GamePanel gp;
  
  public GameOver(GamePanel tempgp){
    setBackground(Color.BLACK);
    setLayout(new BorderLayout());
    
    JLabel lblGameOver = new JLabel("<html><font color='white'>Game Over</font></html>");
    //lblGameOver.setBounds(200,150,300,20);
    lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
    lblGameOver.setVerticalAlignment(SwingConstants.CENTER);
    add(lblGameOver);
    
    JButton btnRestart = new JButton("Play again?");
    btnRestart.addActionListener(new HandleBtnRestart());
    add(btnRestart,BorderLayout.SOUTH);
    
    gp = tempgp;
  }
  
  public void restartGame(){
    gp.removeAll();
    
    MainMenu mm = new MainMenu(gp);
    
    gp.add(mm);
    
    revalidate();
    repaint();
    
    gp.revalidate();
    gp.repaint(); 
  }
  
  private class HandleBtnRestart implements ActionListener{
    public void actionPerformed(ActionEvent e){
      restartGame();
    }
  }
}