import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EndingScene extends JPanel{
  
  private javax.swing.Timer timer;
  private JLabel lblOutro = new JLabel("You have made it to the Hack-A-Thon!");
  private JButton btnSkip = new JButton("Skip");
  private GamePanel gp;
  private EndingScene es;
  private int count = 0;
  
  
  public EndingScene(GamePanel tempgp){
    lblOutro.setForeground(Color.WHITE);
    
    gp = tempgp; //Reference to GamePanel.
    
    setBackground(Color.GRAY);
    setPreferredSize(new Dimension(500,500));
    setLayout(new BorderLayout());
    
    //lblOutro.setBounds(150,25,500,20);
    lblOutro.setHorizontalAlignment(SwingConstants.CENTER);
    lblOutro.setVerticalAlignment(SwingConstants.CENTER);
    add(lblOutro, BorderLayout.CENTER);
    
    //btnSkip.setBounds(350,400,80,30);
    btnSkip.addActionListener(new HandleBtnSkip());
   // btnSkip.setHorizontalAlignment(SwingConstants.EAST);
    add(btnSkip, BorderLayout.SOUTH);
    
    timer = new javax.swing.Timer(2100, new TimerListener());
    
    es = this;
    
    timer.start();
  }
  
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      count++;
      if (count == 1){
       // lblOutro.setBounds(125,25,500,20);
        lblOutro.setText("Now it's time to sign in.");
      }else if (count == 2){
       // lblOutro.setBounds(100,25,500,20);
        lblOutro.setText("You need to show your IDs.");
      }else if (count == 3){
       // lblOutro.setBounds(225,25,500,20);
        lblOutro.setText("...");
      }else if (count == 4){
        lblOutro.setText("Vikrant was holding onto everyone's IDs...");

      }else if (count == 5){
       // lblOutro.setBounds(205,25,500,20);
        lblOutro.setText("...");

      }else if (count == 6){
       // lblOutro.setBounds(175,25,500,20);
        lblOutro.setText("....");

      }else if (count == 7){
      //  lblOutro.setBounds(175,25,500,20);
        lblOutro.setText(".....");
      }else if (count == 8){
        //lblOutro.setBounds(100,25,500,20);
        lblOutro.setText("You are not allowed to enter the Hack-A-Thon...");
      }else if (count == 9){
       // lblOutro.setBounds(100,25,500,20);
        lblOutro.setText("Crap.");
      }else if (count >= 11){
        gotoGameOver();
      }
      
    }
  }
  
  private void gotoGameOver(){
    timer.stop();
    
    gp.remove(es);
    GameOver go = new GameOver(gp);
    gp.add(go);
    gp.revalidate();
    gp.repaint();
  }
  
  private class HandleBtnSkip implements ActionListener{
    public void actionPerformed(ActionEvent e){
      gotoGameOver();
    }
  }
}
