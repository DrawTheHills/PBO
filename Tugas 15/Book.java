public class Book {
    private int id;
    private String isbn;
    private String title;
    private String lecturer;

    public Book(int id, String isbn, String title, String lecturer) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.lecturer = lecturer;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | ISBN: " + isbn +
               " | Judul: " + title +
               " | Dosen: " + lecturer;
    }
}
