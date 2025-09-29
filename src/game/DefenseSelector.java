package src.game;

import java.util.Random;
import src.defends.Defend;
import src.defends.CasualDefence;
import src.defends.MediumDefence;
import src.defends.StrongDefence;
import src.defends.DefendContext;

public class DefenseSelector {
    private final Random random;

    public DefenseSelector(Random random) {
        this.random = random;
    }

    public DefendContext selectRandomDefense() {    
        double randomValue = random.nextDouble();
        
        if (randomValue < 0.6) {
            System.out.println("Selected: Casual Defense! (60% chance)");
            return new DefendContext(new CasualDefence(random));
        } else if (randomValue < 0.85) {
            System.out.println("Selected: Medium Defense! (25% chance)");
            return new DefendContext(new MediumDefence(random));
        } else {
            System.out.println("Selected: Strong Defense! (15% chance)");
            return new DefendContext(new StrongDefence(random));
        }
    }
    

}