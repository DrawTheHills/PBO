import java.util.ArrayList;

public class Library {

    private ArrayList<Book> collection;
    private int autoId;

    public Library() {
        collection = new ArrayList<Book>();
        autoId = 1;
    }

    public void insertBook(String isbn, String title, String lecturer) {
        Book b = new Book(autoId, isbn, title, lecturer);
        collection.add(b);
        autoId++;
    }

    public ArrayList<Book> listBooks() {
        return collection;
    }

    public Book getBookById(int id) {
        for (Book b : collection) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public boolean removeBook(int id) {
        Book b = getBookById(id);
        if (b == null) return false;
        collection.remove(b);
        return true;
    }

    public ArrayList<Book> findByTitle(String keyword) {
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book b : collection) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }
}
