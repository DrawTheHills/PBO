import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {

    public int x, y;
    public int width = 20;
    public int height = 140;

    public int score = 0;

    public Paddle(int x, int screenHeight) {
        this.x = x;
        this.y = screenHeight / 2 - height / 2;
    }

    public void moveUp() {
        y -= 8;
        if (y < 0) y = 0;
    }

    public void moveDown(int screenHeight) {
        y += 8;
        if (y + height > screenHeight)
            y = screenHeight - height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}
