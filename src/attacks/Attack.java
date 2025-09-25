package src.attacks;

import java.math.BigDecimal;
import src.characters.Characters;

public abstract class Attack {
    public abstract BigDecimal attack(Characters attacker);
}