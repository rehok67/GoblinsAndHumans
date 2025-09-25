package src.characters;

import java.math.BigDecimal;

public abstract class Characters {
    protected String name;

    public String getName() {
        return name;
    }

    abstract public BigDecimal getDamage();
    abstract public BigDecimal getHealth();
    abstract public BigDecimal getDefense();
    abstract public BigDecimal healthUpdate(BigDecimal damage);
}