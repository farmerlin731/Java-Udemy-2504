import javax.swing.*;
import java.awt.*;

public class GuiPractice  extends JPanel{
    @Override
    //Java calls this method when it needs to.
    public void paintComponent(Graphics g){
        //The order of statements is important.
        g.drawString("GUI Practice :)",100,100);
        g.drawLine(10,10,50,50);
        g.setColor(Color.RED);
        g.drawRect(50,50,180,100);

        g.setColor(Color.pink);
        int width = getWidth();
        int height = getHeight();
        g.fillRect(230,150,width-230,height-150);

        g.setColor(Color.orange);
        g.fillOval(10,100,30,30);
    }
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300,300);
        window.setContentPane(new Main());
        window.setVisible(true);
    }
}
