package src.game;

import java.util.Random;
import src.defends.Defend;
import src.defends.CasualDefence;
import src.defends.MediumDefence;
import src.defends.StrongDefence;

public class DefenseSelector {
    private final Random random;
    
    public DefenseSelector(Random random) {
        this.random = random;
    }
    
    public Defend selectRandomDefense() {
        double randomValue = random.nextDouble();
        
        if (randomValue < 0.6) {
            System.out.println("Selected: Casual Defense! (60% chance)");
            return new CasualDefence(random);
        } else if (randomValue < 0.85) {
            System.out.println("Selected: Medium Defense! (25% chance)");
            return new MediumDefence(random);
        } else {
            System.out.println("Selected: Strong Defense! (15% chance)");
            return new StrongDefence(random);
        }
    }
    
    // İleride farklı stratejiler ekleyebilirsin
    public Defend selectDefensiveStrategy() {
        double randomValue = random.nextDouble();
        // Defensive: Daha çok strong defense
        if (randomValue < 0.3) {
            return new CasualDefence(random);
        } else if (randomValue < 0.6) {
            return new MediumDefence(random);
        } else {
            return new StrongDefence(random);
        }
    }
    
    public Defend selectAggressiveStrategy() {
        // Aggressive: Daha az defense, daha çok risk
        double randomValue = random.nextDouble();
        if (randomValue < 0.8) {
            return new CasualDefence(random);
        } else if (randomValue < 0.95) {
            return new MediumDefence(random);
        } else {
            return new StrongDefence(random);
        }
    }
}