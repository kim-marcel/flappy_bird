package flappybird;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


/**
 * Created by KimFeichtinger on 19.05.18.
 */
public class GUI extends javax.swing.JPanel {

    private static final int DELAY = 10;

    Point panelSize;

    Controller c;

    public GUI(Point panelSize) {
        this.panelSize = panelSize;

        c = new Controller(this.panelSize);

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

    public void keyPressed(KeyEvent evt) {
        c.keyPressed(evt);
    }
}
