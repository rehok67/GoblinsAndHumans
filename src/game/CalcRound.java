package src.game;

import java.math.BigDecimal;
import java.util.Random;
import src.attacks.Attack;
import src.characters.Characters;
import src.defends.Defend;

public class CalcRound {
    private final AttackSelector attackSelector;
    private final DefenseSelector defenseSelector;

    public CalcRound(Random randomAttacker, Random randomDefender) {
        this.attackSelector = new AttackSelector(randomAttacker);
        this.defenseSelector = new DefenseSelector(randomDefender);
    }

    public BigDecimal executeRound(Characters attacker, Characters defender) {
        // Attack ve Defense strategy'lerini seç
        Attack selectedAttack = attackSelector.selectRandomAttack();
        Defend selectedDefense = defenseSelector.selectRandomDefense();
        
        System.out.println(attacker.getName() + " vs " + defender.getName() + " - Round starting!");
        System.out.println(attacker.getName() + " is preparing to attack...");
        System.out.println(defender.getName() + " is preparing to defend...");
        
        // Attack ve Defense'ı gerçekleştir
        BigDecimal attackResult = selectedAttack.attack(attacker);
        BigDecimal defendResult = selectedDefense.defend(defender);
        
        // Net damage hesapla
        BigDecimal netDamage = attackResult.subtract(defendResult);
        if (netDamage.compareTo(BigDecimal.ZERO) < 0) {
            netDamage = BigDecimal.ZERO; // Damage negatif olamaz
        }
        
        System.out.println("Attack damage: " + attackResult + ", Defense: " + defendResult + ", Net damage: " + netDamage);
        return netDamage;
    }
    
    // İleride farklı stratejiler ekleyebilirsin
}