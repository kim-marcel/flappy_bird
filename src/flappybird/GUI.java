package flappybird;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Created by KimFeichtinger on 19.05.18.
 */
public class GUI extends javax.swing.JPanel {

    private static final int DELAY = 100;

    public GUI() {

        ActionListener taskPerformer = evt -> {
            repaint();
        };

        Timer timer = new Timer(DELAY, taskPerformer);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0,0,10,10);
    }

}
