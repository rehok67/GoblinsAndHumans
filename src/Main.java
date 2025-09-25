package src;

import java.math.BigDecimal;
import src.characters.Human;
import src.characters.Goblins;
import src.game.Fight;

public class Main {
    public static void main(String[] args) {
        // Characters oluştur
        Human warrior = new Human("Warrior", BigDecimal.valueOf(20), BigDecimal.valueOf(100), BigDecimal.valueOf(5));
        Goblins goblin = new Goblins("Goblin", BigDecimal.valueOf(15), BigDecimal.valueOf(80), BigDecimal.valueOf(3));
        
        // Fight oluştur ve savaş başlat!
        Fight epicBattle = new Fight();
        epicBattle.simulateWar(warrior, goblin);
    }
}