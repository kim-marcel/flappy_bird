package flappybird;

import java.awt.*;

public class Bird {

    private static final int POSITION_X = 200;
    private static final int RADIUS = 15;
    private static final int LIFT = -6;
    private static final double GRAVITY = 0.2;

    private double velocity = 0;
    private double positionY;

    public Bird(Point panelSize){
        this.positionY = panelSize.y / 2;
    }

    public void draw(Graphics g, Point panelSize){
        g.setColor(Color.RED);
        g.fillOval(POSITION_X - RADIUS, (int) (positionY - RADIUS), RADIUS * 2, RADIUS * 2);

        update(panelSize);
    }

    private void update(Point panelSize){
        velocity += GRAVITY;
        positionY += velocity;

        if (positionY >= panelSize.y - RADIUS) {
            positionY = panelSize.y - RADIUS;
            velocity = 0;
        }

        if (positionY <= RADIUS) {
            positionY = RADIUS;
            velocity = 0;
        }
    }

    public void fly(){
        velocity = LIFT;
    }
}
