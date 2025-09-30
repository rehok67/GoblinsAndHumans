package src.Turn;
import src.utils.InputUtil;
import src.characters.Characters;

public class UserTurnSelector implements TurnSelector {
    @Override
    public TurnType selectTurn(Characters character) {
        int choice = InputUtil.readInt("=== " + character.getName() + "'s Turn ===\n" +
                                       "What do you want to do?\n" +
                                       "1. Attack\n" +
                                       "2. Skip Turn\n" +
                                       "3. Defend\n" +
                                       "Choose (1-3): ", 1, 3);
        return switch (choice) {
            case 1 -> TurnType.ATTACK;
            case 2 -> TurnType.SKIP;
            case 3 -> TurnType.DEFEND;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };

    }
    
}
