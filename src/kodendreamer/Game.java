package kodendreamer;

import kodendreamer.display.Display;
import kodendreamer.input.KeyManager;
import kodendreamer.states.GameState;
import kodendreamer.states.HelpState;
import kodendreamer.states.MenuState;
import kodendreamer.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * The main kodendreamer.Game Object that instantiate and call other Objects and components of the game
 */
public class Game implements Runnable {

    private Thread thread;
    private Display display;

    private String title;
    private int width, height;

    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState, helpState, menuState;

    //Key Manager
    private KeyManager keyManager;

    /**
     * @param title  for the title of the window
     * @param width  for the width window
     * @param height for the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

    }

    /**
     * Initializes Objects and components of the window
     */
    private void init() {
        display = new Display(title, width, height);
        keyManager = new KeyManager();
        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addKeyListener(keyManager);

        gameState = new GameState(this);
        menuState = new MenuState(this);
        helpState = new HelpState(this);

        State.setCurrentState(gameState);
    }

    /**
     * Starts this thread instance
     */
    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this, "kodendreamer.Game");
        thread.start();
    }


    /**
     * Updates the game objects
     */
    private void update() {
        keyManager.update();
        if (State.getCurrentState() != null) State.getCurrentState().update();
    }

    /**
     * Render the update Objects
     */

    private void render() {
        bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        if (State.getCurrentState() != null)
            State.getCurrentState().render(g);

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        init();

        int fps = 60; //Frames per second
        double timePerTick = 1000000000 / fps; //Time before another tick
        double delta = 0; //Check whether you tick again
        long now;
        long lastTime = System.nanoTime();

        //kodendreamer.Game loop checker
        long timer = 0;
        int ticks = 0;

        while (running) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                ticks++;

                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks " + ticks);
                ticks = 0;
                timer = 0;
            }

        }

        stop();
    }

    /**
     * Stops this Thread Instance
     */

    private synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}
