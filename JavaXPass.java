import java.awt.Dimension;
import java.awt.Toolkit;

public class JavaXPass {
     public static void main(String[] args) {
        LogicClass.ReadXml();
        NewJFrame n = new NewJFrame();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = n.getSize().width;
        int h = n.getSize().height;
        int x = (dim.width-w)-50;
        int y = (dim.height-h)-60;
        
        n.setLocation(x, y);
        n.setVisible(true);
        n.setDefaultCloseOperation(3);
    }
}