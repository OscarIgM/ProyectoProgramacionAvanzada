import javax.swing.*;
import java.awt.*;

class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}