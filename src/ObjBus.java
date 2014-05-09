import javax.swing.*;
import java.awt.*;

public class ObjBus extends JPanel{
  
  private ImageIcon frameOne;
  private ImageIcon frameTwo;
  
  public ObjBus(){
    frameOne = new ImageIcon("imgBus.png");
    //set frameTwo image
    
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    int x = (getWidth() - frameOne.getIconWidth())/2;
    int y = (getHeight() - frameOne.getIconHeight())/2;
    frameOne.paintIcon(this,g,x,y);
  }
  
  public int busWidth(){
    return frameOne.getIconWidth();
  }
  
  public int busHeight(){
    return frameOne.getIconHeight();
  }
}
