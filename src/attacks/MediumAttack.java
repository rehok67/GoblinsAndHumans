package src.attacks;

import java.math.BigDecimal;
import java.util.Random;
import src.characters.Characters;

public class MediumAttack extends Attack {
    private final Random random;
    
    public MediumAttack(Random random) {
        this.random = random;
    }
    
    public BigDecimal attack(Characters attacker) {
        BigDecimal hitchance = BigDecimal.valueOf(random.nextDouble(0, 0.4));
        if (hitchance.compareTo(BigDecimal.valueOf(0.2)) < 0) {
            System.out.println(attacker.getName() + " missed the medium attack!");
            return BigDecimal.ZERO;
        } else {
            return attacker.getDamage().multiply(BigDecimal.valueOf(1.5));
        }
    }
}