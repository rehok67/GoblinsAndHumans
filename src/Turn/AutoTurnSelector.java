package src.Turn;
import src.characters.Characters;
public class AutoTurnSelector implements TurnSelector {
    @Override
    public TurnType selectTurn(Characters character) {
        // Simple logic: Always attack if possible
        return TurnType.ATTACK;
    }
    
}
