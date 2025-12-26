import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private Library library;
    private Scanner input;

    public MainApp() {
        library = new Library();
        input = new Scanner(System.in);
        seedData();
    }

    public static void main(String[] args) {
        new MainApp().start();
    }

    private void start() {
        boolean running = true;
        while (running) {
            showMenu();
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    showAllBooks();
                    break;
                case "2":
                    addNewBook();
                    break;
                case "3":
                    editBook();
                    break;
                case "4":
                    deleteBook();
                    break;
                case "5":
                    searchBook();
                    break;
                case "0":
                    running = false;
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n=== SISTEM PERPUSTAKAAN AKADEMIK ===");
        System.out.println("1. Lihat semua buku");
        System.out.println("2. Tambah buku");
        System.out.println("3. Edit buku");
        System.out.println("4. Hapus buku");
        System.out.println("5. Cari buku berdasarkan judul");
        System.out.println("0. Keluar");
        System.out.print("Pilihan: ");
    }

    private void showAllBooks() {
        ArrayList<Book> data = library.listBooks();
        if (data.isEmpty()) {
            System.out.println("Data buku masih kosong.");
        } else {
            for (Book b : data) {
                System.out.println(b);
            }
        }
    }

    private void addNewBook() {
        System.out.print("ISBN: ");
        String isbn = input.nextLine();
        System.out.print("Judul Mata Kuliah: ");
        String title = input.nextLine();
        System.out.print("Nama Dosen: ");
        String lecturer = input.nextLine();

        library.insertBook(isbn, title, lecturer);
        System.out.println("Buku berhasil ditambahkan.");
    }

    private void editBook() {
        System.out.print("Masukkan ID buku: ");
        int id = readNumber();
        Book b = library.getBookById(id);

        if (b == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        System.out.println("Data saat ini: " + b);

        System.out.print("Judul baru (kosongkan jika tidak diubah): ");
        String title = input.nextLine();
        if (!title.isEmpty()) b.setTitle(title);

        System.out.print("ISBN baru (kosongkan jika tidak diubah): ");
        String isbn = input.nextLine();
        if (!isbn.isEmpty()) b.setIsbn(isbn);

        System.out.print("Dosen baru (kosongkan jika tidak diubah): ");
        String lecturer = input.nextLine();
        if (!lecturer.isEmpty()) b.setLecturer(lecturer);

        System.out.println("Data buku berhasil diperbarui.");
    }

    private void deleteBook() {
        System.out.print("Masukkan ID buku yang akan dihapus: ");
        int id = readNumber();
        boolean success = library.removeBook(id);
        System.out.println(success ? "Buku dihapus." : "Buku tidak ditemukan.");
    }

    private void searchBook() {
        System.out.print("Masukkan kata kunci judul: ");
        String key = input.nextLine();
        ArrayList<Book> result = library.findByTitle(key);

        if (result.isEmpty()) {
            System.out.println("Tidak ditemukan buku yang sesuai.");
        } else {
            for (Book b : result) {
                System.out.println(b);
            }
        }
    }

    private int readNumber() {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    // Data awal (BEDA TOTAL DENGAN TEMANMU)
    private void seedData() {
        library.insertBook("978-1111111111", "Algoritma dan Pemrograman", "Dr. Raka Putra");
        library.insertBook("978-2222222222", "Basis Data Lanjut", "Dr. Nabila Sari");
        library.insertBook("978-3333333333", "Interaksi Manusia dan Komputer", "Dr. Kevin Pratama");
        library.insertBook("978-4444444444", "Rekayasa Perangkat Lunak", "Dr. Maya Kartika");
    }
}
