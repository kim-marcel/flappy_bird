package flappybird;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Controller {

    private static final int SPACE = 300;

    private ArrayList<Pipe> pipes;
    private Bird bird;

    private Point panelSize;

    public Controller(Point panelSize){
        this.panelSize = panelSize;

        pipes = new ArrayList<>();
        bird = new Bird(panelSize);

        initializePipes();
    }

    private void initializePipes() {
        int positionX = panelSize.x;
        int numberOfPipes = panelSize.x / SPACE + 1;

        for (int i = 0; i < numberOfPipes; i++) {
            pipes.add(new Pipe(positionX, panelSize));
            positionX += SPACE;
        }
    }

    public void drawAll(Graphics g){
        drawPipes(g);
        drawBird(g);
    }

    private void drawPipes(Graphics g){
        Pipe toRemove = null;

        for (Pipe pipe : pipes) {
            if (!pipe.isOffTheScreen()) {
                pipe.draw(g, panelSize);
                pipe.move();
            } else {
                toRemove = pipe;
            }
        }

        if (toRemove != null) {
            pipes.remove(toRemove);
            addNewPipe();
        }
    }

    private void drawBird(Graphics g) {
        bird.draw(g, panelSize);
    }

    private void addNewPipe(){
        int positionX = pipes.get(pipes.size() - 1).getPositionX() + SPACE;

        pipes.add(new Pipe(positionX, panelSize));
    }

    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_SPACE){
            bird.fly();
        }
    }
}
