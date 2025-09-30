package src.Turn;
import src.characters.Characters;
public interface TurnSelector {
    TurnType selectTurn(Characters character);
}
