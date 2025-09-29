package src.attacks;
import java.math.BigDecimal;
public class AttackContext {
    private Attack attackStrategy;
    public AttackContext(Attack attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
    public void setAttackStrategy(Attack newStrategy) { 
        this.attackStrategy = newStrategy;
    }
    public BigDecimal executeAttack(src.characters.Characters attacker) { 
        return attackStrategy.attack(attacker);
    }
}
