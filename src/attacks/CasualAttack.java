package src.attacks;

import java.math.BigDecimal;
import java.util.Random;
import src.characters.Characters;

public class CasualAttack extends Attack {
    private final Random random;
    
    public CasualAttack(Random random) {
        this.random = random;
    }
    
    public BigDecimal attack(Characters attacker) {
        BigDecimal hitchance = BigDecimal.valueOf(random.nextDouble(0, 0.4));
        if (hitchance.compareTo(BigDecimal.valueOf(0.1)) < 0) {
            System.out.println(attacker.getName() + " missed the casual attack!");
            return BigDecimal.ZERO;
        } else {
            return attacker.getDamage();
        }
    }
}