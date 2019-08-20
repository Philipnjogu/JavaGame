package kodendreamer.states;

import kodendreamer.Game;
import kodendreamer.entities.Ball;
import kodendreamer.entities.Paddle;

import java.awt.*;

public class GameState extends State {

    private Ball ball;
    private Paddle paddle;

    public GameState(Game game) {
        super(game);
        paddle = new Paddle(200, 350, game);
        ball = new Ball(100, 300, paddle);
    }

    @Override
    public void update() {
        paddle.update();
        ball.update();
    }

    @Override
    public void render(Graphics g) {
        paddle.render(g);
        ball.render(g);
    }
}
