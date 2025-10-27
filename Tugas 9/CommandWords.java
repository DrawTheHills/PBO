import java.util.HashMap;

public class CommandWords {
    private HashMap<String, String> validCommands;

    public CommandWords() {
        validCommands = new HashMap<>();
        validCommands.put("go", "go");
        validCommands.put("help", "help");
        validCommands.put("quit", "quit");
    }

    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    public String getCommandList() {
        return String.join(" ", validCommands.keySet());
    }
}
