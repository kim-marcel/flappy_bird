package flappybird;

import java.awt.*;

public class Bird {

    private static final int POSITION_X = 200;
    private static final int RADIUS = 15;
    private static final int LIFT = -6;
    private static final double GRAVITY = 0.2;

    private double positionY;
    private double velocity;

    public Bird(Point panelSize){
        this.positionY = panelSize.y / 2;
        this.velocity = 0;
    }

    public void draw(Graphics g, Point panelSize){
        g.setColor(Color.RED);
        g.fillOval(POSITION_X - RADIUS, (int) (positionY - RADIUS), RADIUS * 2, RADIUS * 2);

        update(panelSize);
    }

    private void update(Point panelSize){
        velocity += GRAVITY;
        positionY += velocity;

        stayInBoundaries(panelSize);
    }

    public void fly(){
        velocity = LIFT;
    }

    private void stayInBoundaries(Point panelSize) {
        if (positionY >= panelSize.y - RADIUS) {
            positionY = panelSize.y - RADIUS;
            velocity = 0;
        }

        if (positionY <= RADIUS) {
            positionY = RADIUS;
            velocity = 0;
        }
    }

    public int getPositionX() {
        return POSITION_X;
    }

    public int getRadius() {
        return RADIUS;
    }

    public double getPositionY() {
        return positionY;
    }
}
