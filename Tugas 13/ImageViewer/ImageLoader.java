import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageLoader {

    private final List<File> imageFiles = new ArrayList<>();
    private int index = -1;

    private static final String[] VALID_EXT = {"png","jpg","jpeg","gif","bmp"};

    public ImageLoader(File directory) {
        load(directory);
    }

    private boolean isValidImage(File f) {
        String name = f.getName().toLowerCase();
        for (String ext : VALID_EXT) {
            if (name.endsWith("." + ext)) return true;
        }
        return false;
    }

    private void load(File dir) {
        if (dir == null || !dir.isDirectory()) return;

        File[] files = dir.listFiles();
        if (files == null) return;

        for (File f : files) {
            if (f.isFile() && isValidImage(f)) {
                imageFiles.add(f);
            }
        }

        if (!imageFiles.isEmpty()) index = 0;
    }

    public boolean hasImages() {
        return !imageFiles.isEmpty();
    }

    public File getCurrent() {
        if (!hasImages() || index < 0) return null;
        return imageFiles.get(index);
    }

    public void next() {
        if (!hasImages()) return;
        index = (index + 1) % imageFiles.size();
    }

    public void prev() {
        if (!hasImages()) return;
        index = (index - 1 + imageFiles.size()) % imageFiles.size();
    }

    public int getIndex() { return index + 1; }
    public int total() { return imageFiles.size(); }
}
