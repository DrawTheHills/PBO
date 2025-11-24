import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageViewerApp extends JFrame {

    private final PicturePanel panel = new PicturePanel();
    private JLabel lblStatus = new JLabel("No folder opened");

    private ImageLoader loader;

    private JButton btnPrev = new JButton("◀ Previous");
    private JButton btnNext = new JButton("Next ▶");
    private JButton btnBrowse = new JButton("Open Folder");

    public ImageViewerApp() {
        super("Naufal's Image Viewer");
        setupUI();
    }

    private void setupUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5,5));

        JPanel top = new JPanel();
        top.add(btnBrowse);
        top.add(btnPrev);
        top.add(btnNext);

        add(top, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(lblStatus, BorderLayout.SOUTH);

        btnBrowse.addActionListener(e -> openFolder());
        btnPrev.addActionListener(e -> showPrevious());
        btnNext.addActionListener(e -> showNext());

        setSize(750, 550);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openFolder() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;

        loader = new ImageLoader(chooser.getSelectedFile());

        if (!loader.hasImages()) {
            lblStatus.setText("Folder tidak berisi gambar!");
            panel.setImage(null);
            return;
        }

        loadImage();
    }

    private void loadImage() {
        try {
            File f = loader.getCurrent();
            BufferedImage image = ImageIO.read(f);
            panel.setImage(image);
            lblStatus.setText(loader.getIndex() + " / " + loader.total() + " - " + f.getName());
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Tidak dapat membuka gambar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showPrevious() {
        if (loader == null || !loader.hasImages()) return;
        loader.prev();
        loadImage();
    }

    private void showNext() {
        if (loader == null || !loader.hasImages()) return;
        loader.next();
        loadImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageViewerApp::new);
    }
}
