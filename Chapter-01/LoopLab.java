import javax.swing.*;
import java.awt.*;

public class LoopLab  extends JPanel{

    String type;
    int n ;
    public LoopLab(){
     type = JOptionPane.showInputDialog("Do u want an addition or multiplication table ? (A or M)");
     n = Integer.parseInt(JOptionPane.showInputDialog("How big do u want ? "));
    }

    @Override
    //Java calls this method when it needs to.
    public void paintComponent(Graphics g){
        int w = getWidth();
        int h = getHeight();

        int x = 0;
        int y = 0;
        int cellWidth = w / n;
        int cellHeight = h / n;

        //Nested-For-Loop
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(i==1 || j==1){
                    g.setColor(Color.orange);
                    g.fillRect(x,y,cellWidth,cellHeight);
                }
                g.setColor(Color.BLACK);
                g.drawRect(x,y,cellWidth,cellHeight);

                if(i==1){
                    g.drawString(""+j,x+5,y+15);
                } else if (j == 1) {
                    g.drawString(""+i,x+5,y+15);

                } else {
                    int value = 0;
                    if(type.toLowerCase().equals("a")){
                        value = i+j;
                    } else if (type.toLowerCase().equals("m")) {
                        value = i*j;
                    }
                    g.drawString(""+value,x+5,y+15);

                }


                x += cellWidth;
            }
            x = 0;
            y += cellHeight;
        }

    }
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400,400);
        window.setContentPane(new LoopLab());
        window.setVisible(true);
    }
}
