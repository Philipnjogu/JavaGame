package kodendreamer.entities;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball extends Entity {

    public static final int DEF_HEALTH = 3;

    private int life;
    private Paddle paddle;

    public Ball(double x, double y, Paddle paddle) {
        super(x, y, 48, 48);

        life = DEF_HEALTH;

        xVel = speed;
        yVel = -speed;
        this.paddle = paddle;

    }

    @Override
    public void update() {

        move();
    }

    @Override
    public void move() {
        super.move();

        if(getBounds().contains(paddle.getBounds())){
            this.yVel *= -1;
        }

        if ((x + width) >= 600 || x <= 0) xVel *= -1;
        if ((y + height) >= 375 || y <= 0) yVel *= -1;

    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.fill(new Ellipse2D.Double(x, y, width, height));
        g2d.setPaint(Color.YELLOW);
        g2d.draw(getBounds());

    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
