package kodendreamer.entities;

import java.awt.*;

public abstract class Entity {
    public static final double DEF_SPEED = 3;

    protected double x, y, width, height;

    protected double speed;

    protected double xVel, yVel;

    public Entity(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        speed = DEF_SPEED;

    }

    public abstract void update();


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

    public void move() {
        y += yVel;
        x += xVel;
    }

    public abstract void render(Graphics g);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getxVel() {
        return xVel;
    }

    public void setxVel(double xVel) {
        this.xVel = xVel;
    }

    public double getyVel() {
        return yVel;
    }

    public void setyVel(double yVel) {
        this.yVel = yVel;
    }
}
