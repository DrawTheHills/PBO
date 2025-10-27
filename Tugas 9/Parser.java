import java.util.Scanner;
import java.util.StringTokenizer;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");
        String inputLine = reader.nextLine();

        String word1 = null;
        String word2 = null;

        StringTokenizer tokenizer = new StringTokenizer(inputLine);
        if (tokenizer.hasMoreTokens()) {
            word1 = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreTokens()) {
            word2 = tokenizer.nextToken();
        }

        if (commands.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2);
        }
    }

    public void showCommands() {
        System.out.println("Available commands: " + commands.getCommandList());
    }
}
