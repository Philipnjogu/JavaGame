package kodendreamer.entities;

import kodendreamer.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Paddle extends Entity {
    private Game game;

    public Paddle(double x, double y, Game game) {
        super(x, y, 200, 20);
        this.game = game;
    }

    @Override
    public void update() {
        getInput();
        move();
    }

    public void getInput() {
        xVel = 0;
        yVel = 0;

        if (game.getKeyManager().isLeftPressed()) xVel = -speed;
        if (game.getKeyManager().isRightPressed()) xVel = speed;
    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.fill(new Rectangle2D.Double(x, y, width, height));


    }

}
