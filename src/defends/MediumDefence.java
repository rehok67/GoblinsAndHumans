package src.defends;
import java.math.BigDecimal;
import java.util.Random;

import src.characters.Characters;
public class MediumDefence extends Defend {
    private final Random random;

    public MediumDefence(Random random) {
        this.random = random;
    }

    @Override
    public BigDecimal defend(Characters defender) {
        BigDecimal successChange = BigDecimal.valueOf(random.nextDouble(0, 0.5));
        if (successChange.compareTo(BigDecimal.valueOf(0.3)) < 0) {
            System.out.println(defender.getName() + " failed to defend medium!");
            return BigDecimal.ZERO;
        } else {
            return defender.getDefense().multiply(BigDecimal.valueOf(1.0));
        }
    }
}
