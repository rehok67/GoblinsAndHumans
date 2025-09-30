package src.GameCommand;
import src.characters.*;

public class SkipTurnCommand implements GameCommand {
    private Characters attacker;

    public SkipTurnCommand(Characters attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute(){
        System.out.println("⏭️ " + attacker.getName() + " skipped their turn!");
 
    }
}
