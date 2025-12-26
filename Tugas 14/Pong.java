import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong implements ActionListener, KeyListener {

    public int width = 700;
    public int height = 500;

    private JFrame frame;
    private Renderer renderer;
    private Timer timer;

    private Paddle left;
    private Paddle right;
    private Ball ball;

    private boolean w, s, up, down;

    public Pong() {
        frame = new JFrame("My Pong");
        renderer = new Renderer(this);

        frame.add(renderer);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);

        left = new Paddle(30, height);
        right = new Paddle(width - 50, height);
        ball = new Ball(this);

        timer = new Timer(16, this);
        timer.start();
    }

    public void update() {
        if (w) left.moveUp();
        if (s) left.moveDown(height);

        if (up) right.moveUp();
        if (down) right.moveDown(height);

        ball.update(left, right);
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.WHITE);
        g.drawString(left.score + " : " + right.score, width / 2 - 20, 30);

        left.render(g);
        right.render(g);
        ball.render(g);
    }

    public static void main(String[] args) {
        new Pong();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        renderer.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) w = true;
        if (e.getKeyCode() == KeyEvent.VK_S) s = true;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) w = false;
        if (e.getKeyCode() == KeyEvent.VK_S) s = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
