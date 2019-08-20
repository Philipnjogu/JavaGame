package kodendreamer.display;

import javax.swing.*;
import java.awt.*;

/**
 * The kodendreamer.display screen of the kodendreamer.Game
 */

public class Display {

    private JFrame frame;
    private Canvas canvas;


    public Display(String title, int width, int height) {
        createFrame(title, width, height);
    }

    /**
     * @param title  of the frame
     * @param width  of the frame
     * @param height of the frame
     */
    private void createFrame(String title, int width, int height) {
        frame = new JFrame(title);

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //Setting Up Canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    /**
     * @return JFrame frame for the kodendreamer.display
     */
    public JFrame getFrame() {
        return frame;
    }


    /**
     * @return Canvas canvas of the frame
     */
    public Canvas getCanvas() {
        return canvas;
    }

}
