package src.defends;
import java.math.BigDecimal;
public class DefendContext {
    private Defend defendStrategy;
    public DefendContext(Defend defendStrategy) {
        this.defendStrategy = defendStrategy;
    }
    public void setDefendStrategy(Defend defendStrategy) {
        this.defendStrategy = defendStrategy;
    }

    public BigDecimal executeDefense(src.characters.Characters defender) {
        return defendStrategy.defend(defender);
    }
    

}
