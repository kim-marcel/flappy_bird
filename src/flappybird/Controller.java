package flappybird;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Controller {

    private static final int SPACE = 200;

    private ArrayList<Pipe> pipes;
    private Bird bird;

    private Pipe currentPipe;

    private Point panelSize;
    private int score;

    public Controller(Point panelSize) {
        this.panelSize = panelSize;

        pipes = new ArrayList<>();
        bird = new Bird(panelSize);

        score = 0;

        initializePipes();
    }

    private void initializePipes() {
        int positionX = panelSize.x;
        int numberOfPipes = panelSize.x / SPACE + 1;

        for (int i = 0; i < numberOfPipes; i++) {
            pipes.add(new Pipe(positionX, panelSize));
            positionX += SPACE;
        }

        currentPipe = pipes.get(0);
    }

    public void drawAll(Graphics g) {
        drawPipes(g);
        drawBird(g);

        findCurrentPipe();
        collisionDetection();

        drawScore(g);
    }

    private void findCurrentPipe() {
        int birdPositionX = bird.getPositionX();
        int birdRadius = bird.getRadius();

        for (Pipe pipe : pipes) {
            if (pipe.getPositionX() + pipe.getWidth() >= birdPositionX - birdRadius) {
                currentPipe = pipe;
                return;
            }
        }
    }

    private void drawPipes(Graphics g) {
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

    private void drawScore(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString("Score: " + score, 25, 25);
    }

    private void collisionDetection() {
        if (currentPipe.passedByBird(bird)) {
            score++;
        }

        if (currentPipe.detectCollisionWithBird(bird)) {
            score = 0;
        }
    }

    private void addNewPipe() {
        int positionX = pipes.get(pipes.size() - 1).getPositionX() + SPACE;

        pipes.add(new Pipe(positionX, panelSize));
    }

    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.fly();
        }
    }
}
