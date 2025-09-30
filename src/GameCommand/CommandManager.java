package src.GameCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<GameCommand> commandHistory = new ArrayList<>();
    
    public void executeCommand(GameCommand command) {
        command.execute();
        commandHistory.add(command);
    }
    
    public void showHistory() {
        System.out.println("\n📜 Command History:");
        for (int i = 0; i < commandHistory.size(); i++) {
            System.out.println((i + 1) + ". " + commandHistory.get(i).getClass().getSimpleName());
        }
    }
    
    public int getCommandCount() {
        return commandHistory.size();
    }
}