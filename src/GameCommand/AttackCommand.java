package src.GameCommand;

import java.math.BigDecimal;
import java.util.Random;

import src.characters.Characters;
import src.game.CalcRound;

public class AttackCommand implements GameCommand {
    private Characters attacker;
    private Characters defender;
    private Random gameRandom = new Random();
    private CalcRound calcRound = new CalcRound(gameRandom, gameRandom);

    public AttackCommand(Characters attacker, Characters defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    @Override
    public void execute() {
        BigDecimal attackResult = calcRound.executeRound(attacker, defender);
        defender.healthUpdate(attackResult);
        
        // Command pattern'de feedback vermek güzel practice!
        System.out.println("⚔️ " + attacker.getName() + " attacked " + defender.getName() + 
                          " for " + attackResult + " damage!");
    }
}
