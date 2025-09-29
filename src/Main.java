package src;

import java.math.BigDecimal;
import src.characters.Human;
import src.characters.Goblins;
import src.characters.Characters;
import src.game.Fight;

public class Main {
    public static void main(String[] args) {
        // GoF Factory Method Pattern kullanımı!
        
        // Factory creators (ConcreteCreator instances)
        Characters humanCreator = new Human("temp", BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        Characters goblinCreator = new Goblins("temp", BigDecimal.valueOf(1), BigDecimal.valueOf(1), BigDecimal.valueOf(1));
        
        // Factory Method ile characters oluştur
        Characters Human = humanCreator.deployForBattle("Sir Lancelot");
        Characters Goblin = goblinCreator.deployForBattle("Stabby");
        
        System.out.println("\n=== FACTORY CREATED CHARACTERS ===");
        System.out.println(Human.getName() + " - HP: " + Human.getHealth() + ", DMG: " + Human.getDamage() + ", DEF: " + Human.getDefense());
        System.out.println(Goblin.getName() + " - HP: " + Goblin.getHealth() + ", DMG: " + Goblin.getDamage() + ", DEF: " + Goblin.getDefense());
        System.out.println();
        
        // Fight oluştur ve savaş başlat!
        Fight epicBattle = new Fight();
        epicBattle.simulateWar(Human, Goblin);
    }
}