package src.game;

import java.util.Random;
import src.attacks.Attack;
import src.attacks.CasualAttack;
import src.attacks.MediumAttack;
import src.attacks.HeavyAttack;

public class AttackSelector {
    private final Random random;
    
    public AttackSelector(Random random) {
        this.random = random;
    }
    
    public Attack selectRandomAttack() {
        double randomValue = random.nextDouble();
        
        if (randomValue < 0.6) {
            System.out.println("Selected: Casual Attack! (60% chance)");
            return new CasualAttack(random);
        } else if (randomValue < 0.85) {
            System.out.println("Selected: Medium Attack! (25% chance)");
            return new MediumAttack(random);
        } else {
            System.out.println("Selected: Heavy Attack! (15% chance)");
            return new HeavyAttack(random);
        }
    }
}