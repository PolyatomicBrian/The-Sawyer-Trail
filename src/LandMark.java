import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandMark extends JPanel{
  
  private LandMarkTop lmt = new LandMarkTop();
  private LandMarkBottom lmb = new LandMarkBottom();
  
  public LandMark(){
    
    setLayout(new BorderLayout());
    
    add(lmt, BorderLayout.CENTER);
    add(lmb, BorderLayout.SOUTH);
    
    
  }
  
}