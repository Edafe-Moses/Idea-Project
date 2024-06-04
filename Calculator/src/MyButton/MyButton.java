package MyButton;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String text) {
        super(text);
        setOpaque(false); // Make the button transparent
        setContentAreaFilled(false); // Remove the default background
        setBorderPainted(false); // Remove the default border color
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (getModel().isArmed()) {
            // Change the background color when the button is clicked
            g2d.setColor(Color.gray);
        } else {
            g2d.setColor(new Color(148, 208, 239));
        }

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.addRenderingHints(rh);

        int width = getWidth();
        int height = getHeight();
        int arcWidth = 20; // Adjust the corner arc width
        int arcHeight = 20; // Adjust the corner arc height

        g2d.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);

        super.paintComponent(g);
    }
}