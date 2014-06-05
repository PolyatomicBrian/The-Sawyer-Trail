import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel{
  
  private JLabel lblGameOver = new JLabel("");
  
  public GameOver(GamePanel tempgp, int tempisDead){
    setBackground(Color.BLACK);
    setLayout(new BorderLayout());
    
    if (tempisDead != 0){
      lblGameOver.setText("<html><font color='white'>Game Over</font></html>");
      lblGameOver.setFont(GamePanel.fontType16);
    }
    else{
      lblGameOver.setText("<html><font color='white'>Everyone starved. Game Over.</font></html>");
      lblGameOver.setFont(GamePanel.fontType16);
    }
    //lblGameOver.setBounds(200,150,300,20);
    lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
    lblGameOver.setVerticalAlignment(SwingConstants.CENTER);
    add(lblGameOver);
    
    addBtnRestart();
    
  }
  
  public void restartGame(){
    /*
     resetStats();
     
     gp.removeAll();
     
     MainMenu mm = new MainMenu(gp);
     
     gp.add(mm);
     
     revalidate();
     repaint();
     
     gp.revalidate();
     gp.repaint(); 
     */
    System.exit(0);
  }
  
  private void addBtnRestart(){
    MyJButton btnRestart = new MyJButton("Quit");
    btnRestart.addActionListener(new HandleBtnRestart());
    btnRestart.setPreferredSize(new Dimension(500,100));
    add(btnRestart,BorderLayout.SOUTH); 
  }
  
  
  private class HandleBtnRestart implements ActionListener{
    public void actionPerformed(ActionEvent e){
      restartGame();
    }
  }
}