package src.GameCommand;
import src.Turn.TurnType;
import src.characters.Characters;
public class CommandFactory {
    public static GameCommand createCommand(TurnType type, Characters attacker, Characters defender) {
        return switch (type) {
            case ATTACK -> new AttackCommand(attacker, defender);
            case SKIP -> new SkipTurnCommand(attacker);
            default -> throw new IllegalArgumentException("Invalid turn type: " + type);
        };
    }
}