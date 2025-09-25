package src.defends;
import java.math.BigDecimal;
import java.util.Random;

import src.characters.Characters;
public class StrongDefence extends Defend{
    private final Random random;

    public StrongDefence(Random random) {
        this.random = random;
    }

    @Override
    public BigDecimal defend(Characters defender){
        BigDecimal successChange = BigDecimal.valueOf(random.nextDouble(0,0.5));
        if (successChange.compareTo(BigDecimal.valueOf(0.4)) < 0) {
            System.out.println(defender.getName() + " failed to defend strongly!");
            return BigDecimal.ZERO;
        } else {
            return defender.getDefense().multiply(BigDecimal.valueOf(1.5));
        }
    }
}

