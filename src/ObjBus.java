import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ObjBus extends JLabel{
  
  private ImageIcon frameOne;
  private ImageIcon frameTwo;
  private boolean isOne = true;
  private boolean isTwo = false;
  
  private javax.swing.Timer timer;
  
  public ObjBus(){
    frameOne = new ImageIcon("imgBus1.png");
    frameTwo = new ImageIcon("imgBus2.png");
    setIcon( frameOne );
    timer = new javax.swing.Timer(600, new TimerListener());
    timer.start();
    
  }
      
  public void paintComponent(Graphics g){

    super.paintComponent(g);
    
    int x = (getWidth() - frameOne.getIconWidth())/2;
    int y = (getHeight() - frameOne.getIconHeight())/2;
    if (isOne)
      frameOne.paintIcon(this,g,x,y);
    else if (isTwo)
      frameTwo.paintIcon(this,g,x,y);

  }
          
  public int busWidth(){
    return frameOne.getIconWidth();
  }
  
  public int busHeight(){
    return frameOne.getIconHeight();
  }

  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    /*
      if (isOne){
        setIcon( frameTwo );
      }else{
        setIcon( frameOne );
      }
      isOne = !isOne;
      */
      
      if (isOne){
        isOne = false;
        isTwo = true;
      }else if (isTwo){
        isOne = true;
        isTwo = false;
      }
      
    }
  }
  
}
