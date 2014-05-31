import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJButton extends JButton{
  
  public MyJButton(){
    setColorAndFont();
  }
  
  public MyJButton(String s){
    setText(s);
    
    setColorAndFont();
  }
  
  private void setColorAndFont(){
    setBackground(Color.WHITE);
    setFont(GamePanel.fontType16); 
  }
  
}