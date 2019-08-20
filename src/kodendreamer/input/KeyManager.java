package kodendreamer.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;

    private boolean leftPressed, rightPressed;

    public void update() {
        leftPressed = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_KP_LEFT];
        rightPressed = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_KP_RIGHT];
    }

    public KeyManager() {
        keys = new boolean[256];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key Type");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed: " + e.getKeyChar());
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key Released: " + e.getKeyChar());

        keys[e.getKeyCode()] = false;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }
}
