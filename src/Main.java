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
        Characters knight = humanCreator.deployForBattle("Sir Lancelot");
        Characters assassin = goblinCreator.deployForBattle("Stabby");
        
        System.out.println("\n=== FACTORY CREATED CHARACTERS ===");
        System.out.println(knight.getName() + " - HP: " + knight.getHealth() + ", DMG: " + knight.getDamage() + ", DEF: " + knight.getDefense());
        System.out.println(assassin.getName() + " - HP: " + assassin.getHealth() + ", DMG: " + assassin.getDamage() + ", DEF: " + assassin.getDefense());
        System.out.println();
        
        // Fight oluştur ve savaş başlat!
        Fight epicBattle = new Fight();
        epicBattle.simulateWar(knight, assassin);
    }
}