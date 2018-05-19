package flappybird;

import java.awt.*;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Pipe> pipes;

    private static final int SPACE = 300;
    private Point panelSize;

    public Controller(Point panelSize){
        this.panelSize = panelSize;

        pipes = new ArrayList<>();

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

        System.out.println(pipes.size());
    }

    private void addNewPipe(){
        int positionX = pipes.get(pipes.size() - 1).getPositionX() + SPACE;

        pipes.add(new Pipe(positionX, panelSize));
    }

}
