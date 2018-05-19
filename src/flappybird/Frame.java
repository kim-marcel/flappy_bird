package flappybird;

/**
 * Created by KimFeichtinger on 19.05.18.
 */
public class Frame extends javax.swing.JFrame {

    private GUI gui;

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    public Frame(){
        gui = new GUI();

        this.setSize(1000, 750);
        this.setLocationRelativeTo(null); // displays JFrame in the center of the screen

        this.add(gui);

        this.setFocusable(false);
        this.gui.setFocusable(true);
        this.gui.requestFocus();
    }

}
