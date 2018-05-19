package flappybird;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Created by KimFeichtinger on 19.05.18.
 */
public class GUI extends javax.swing.JPanel {

    private static final int DELAY = 30;

    Point panelSize = new Point(1000, 750);

    Controller c;

    public GUI() {

        c = new Controller(panelSize);

        ActionListener taskPerformer = evt -> repaint();

        Timer timer = new Timer(DELAY, taskPerformer);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g){
        paintBackground(g);
        paintForeground(g);
    }

    private void paintForeground(Graphics g) {
        c.drawAll(g);
    }

    private void paintBackground(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,this.getWidth(), this.getHeight());
    }

}
