package src.GameCommand;

import java.math.BigDecimal;
import java.util.Random;
import src.characters.Characters;
import src.game.CalcAttackRound;

public class AttackCommand implements GameCommand {
    private Characters attacker;
    private Characters defender;
    private Random gameRandom = new Random();
    private CalcAttackRound calcRound = new CalcAttackRound(gameRandom, gameRandom);

    public AttackCommand(Characters attacker, Characters defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    @Override
    public void execute() {
        BigDecimal attackResult = calcRound.executeRound(attacker, defender);
        defender.healthUpdate(attackResult);
        
        System.out.println("⚔️ " + attacker.getName() + " attacked " + defender.getName() + 
                          " for " + attackResult + " damage!");
    }
}
