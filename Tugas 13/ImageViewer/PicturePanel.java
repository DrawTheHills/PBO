import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PicturePanel extends JPanel {

    private BufferedImage img;

    public void setImage(BufferedImage image) {
        this.img = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (img == null) return;

        int pw = getWidth();
        int ph = getHeight();
        int iw = img.getWidth();
        int ih = img.getHeight();

        double scale = Math.min((double) pw / iw, (double) ph / ih);

        int w = (int)(iw * scale);
        int h = (int)(ih * scale);
        int x = (pw - w) / 2;
        int y = (ph - h) / 2;

        g.drawImage(img, x, y, w, h, this);
    }
}
