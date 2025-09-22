import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A very simple GUI (graphical user interface) for the clock display.
 * In this implementation, time runs at about 3 minutes per second, so that
 * testing the display is a little quicker.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Clock
{
    private JFrame frame;
    private JLabel label;
    private ClockDisplay clock;
    private boolean clockRunning = false;
    private TimerThread timerThread;
    
    public Clock()
    {
        clock = new ClockDisplay();
        makeFrame();
    }

    private void start()
    {
        clockRunning = true;
        timerThread = new TimerThread();
        timerThread.start();
    }
    
    private void stop()
    {
        clockRunning = false;
    }
    
    private void step()
    {
        clock.timeTick();
        String text = "<html><center>" 
                      + clock.getTime() + "<br>"     
                      + clock.getDate() + "<br>"      
                      + clock.getTemperature() +     
                      "</center></html>";
        label.setText(text);
    }

    private void showAbout()
    {
        JOptionPane.showMessageDialog (frame, 
                    "Clock Version 1.0\n" +
                    "A simple interface for the 'Objects First' clock display project",
                    "About Clock", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void quit()
    {
        System.exit(0);
    }

    private void makeFrame()
    {
        frame = new JFrame("Clock");
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        makeMenuBar(frame);
               
        contentPane.setLayout(new BorderLayout(12, 12));
        
        label = new JLabel(clock.getTime(), SwingConstants.CENTER);
        Font displayFont = label.getFont().deriveFont(96.0f);
        label.setFont(displayFont);

        contentPane.add(label, BorderLayout.CENTER);

        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(1, 0));
        
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> start());
        toolbar.add(startButton);
        
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> stop());
        toolbar.add(stopButton);

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(e -> step());
        toolbar.add(stepButton);

        JPanel flow = new JPanel();
        flow.add(toolbar);
        
        contentPane.add(flow, BorderLayout.SOUTH);
          
        frame.pack();
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
    
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;

        menu = new JMenu("File");
        menubar.add(menu);
        
        item = new JMenuItem("About Clock...");
            item.addActionListener(e -> showAbout());
        menu.add(item);

        menu.addSeparator();
        
        item = new JMenuItem("Quit");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            item.addActionListener(e -> quit());
        menu.add(item);
    }
    
    class TimerThread extends Thread
    {
        public void run()
        {
            while (clockRunning) {
                step();
                pause();
            }
        }
        
        private void pause()
        {
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException exc) {
            }
        }
    }
}
