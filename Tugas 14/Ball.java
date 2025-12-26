import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {

    private int x, y;
    private int size = 20;

    private int dx = 4;
    private int dy = 3;

    private Pong game;

    public Ball(Pong game) {
        this.game = game;
        reset();
    }

    public void reset() {
        x = game.width / 2 - size / 2;
        y = game.height / 2 - size / 2;
        dx = (Math.random() > 0.5) ? 4 : -4;
        dy = (Math.random() > 0.5) ? 3 : -3;
    }

    public void update(Paddle left, Paddle right) {
        x += dx;
        y += dy;

        if (y <= 0 || y + size >= game.height) {
            dy *= -1;
        }

        if (getBounds().intersects(left.getBounds())) {
            bounceFromPaddle(left);
        }

        if (getBounds().intersects(right.getBounds())) {
            bounceFromPaddle(right);
        }

        if (x < 0) {
            right.score++;
            reset();
        }

        if (x > game.width) {
            left.score++;
            reset();
        }
    }

    private void bounceFromPaddle(Paddle paddle) {
        dx *= -1;

        int paddleCenter = paddle.y + paddle.height / 2;
        int ballCenter = y + size / 2;

        int distance = ballCenter - paddleCenter;
        dy = distance / 10;

        if (dy == 0) dy = 1;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
    }
}
