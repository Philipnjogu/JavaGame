package kodendreamer.states;

import kodendreamer.Game;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class HelpState extends State {

    public HelpState(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.fill(new Ellipse2D.Double(200, 200, 150, 150));
    }
}
