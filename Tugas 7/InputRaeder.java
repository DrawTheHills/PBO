import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        System.out.print("\nAnda: ");
        return scanner.nextLine().trim().toLowerCase();
    }
}
