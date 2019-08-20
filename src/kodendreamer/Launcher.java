package kodendreamer;

import kodendreamer.Game;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Breakout kodendreamer.Game", 600, 400);
        game.start();
    }
}
