import javax.swing.*;
import java.awt.*;

public class ObjLandMark extends JLabel{
  
  private ImageIcon imgLM1 = new ImageIcon("imgLM1.png");
  private ImageIcon imgLM2 = new ImageIcon("imgLM2.png");
  private ImageIcon imgLM3 = new ImageIcon("imgLM3.png");
  private ImageIcon imgLM4 = new ImageIcon("imgLM4.png");
  private ImageIcon imgLM5 = new ImageIcon("imgLM5.png");
  private ImageIcon imgLM6 = new ImageIcon("imgLM6.png");
  
  public ObjLandMark(){

  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    if (GamePanel.landMarksEncountered == 0){
      //lm1
      imgLM1.paintIcon(this,g,0,0);
    }else if (GamePanel.landMarksEncountered == 1){
      //lm2
      imgLM2.paintIcon(this,g,0,0);
    }else if (GamePanel.landMarksEncountered == 2){
      //lm3
      imgLM3.paintIcon(this,g,0,0);
    }else if (GamePanel.landMarksEncountered == 3){
      //lm4
      imgLM4.paintIcon(this,g,0,0);
    }else if (GamePanel.landMarksEncountered == 4){
      //lm5
      imgLM5.paintIcon(this,g,0,0);
    }else{
      //lm6
      imgLM6.paintIcon(this,g,0,0);
    }
  }
}
