package flappybird;

import java.awt.*;
import java.util.Random;

public class Pipe {

    Random r = new Random();

    private static final int WIDTH = 50;
    private static final int SPACE = 150;
    private static final int STEP_SIZE = 2; // pixels by which the pipe will move every frame

    private int positionX;
    private int spaceHeight;

    public Pipe(int positionX, Point panelSize){
        this.positionX = positionX;
        spaceHeight = r.nextInt(panelSize.y - SPACE); // Height on which the space will begin
    }

    public void draw(Graphics g, Point panelSize){
        g.setColor(new Color(255, 255, 255));

        g.fillRect(positionX,0, WIDTH, spaceHeight);
        g.fillRect(positionX, spaceHeight + SPACE, WIDTH, panelSize.y - SPACE - spaceHeight);
    }

    public void move(){
        positionX -= STEP_SIZE;
    }

    public boolean isOffTheScreen(){ // Returns true when it moved off the screen
        return positionX + WIDTH <= 0;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
}