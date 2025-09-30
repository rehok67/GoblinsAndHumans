package src;

import java.math.BigDecimal;
import src.characters.Human;
import src.characters.Goblins;
import src.characters.Characters;
import src.game.Fight;
import src.GameCommand.AttackCommand;
import src.GameCommand.CommandManager;

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

        // 🚀 COMMAND PATTERN TEST!
        System.out.println("\n=== COMMAND PATTERN TEST ===");
        CommandManager commandManager = new CommandManager();
        
        // Command'ları oluştur ve çalıştır
        AttackCommand humanAttack = new AttackCommand(Human, Goblin);
        AttackCommand goblinAttack = new AttackCommand(Goblin, Human);

        System.out.println("Before attacks:");
        System.out.println(Human.getName() + " HP: " + Human.getHealth());
        System.out.println(Goblin.getName() + " HP: " + Goblin.getHealth());
        
        // Command Manager ile çalıştır
        commandManager.executeCommand(humanAttack);
        commandManager.executeCommand(goblinAttack);
        
        System.out.println("\nAfter attacks:");
        System.out.println(Human.getName() + " HP: " + Human.getHealth());
        System.out.println(Goblin.getName() + " HP: " + Goblin.getHealth());

        commandManager.showHistory();
        
        System.out.println("\n=== ORIGINAL FIGHT SYSTEM ===");
        // Orijinal fight sistemi
        Fight epicBattle = new Fight();
        epicBattle.simulateWar(Human, Goblin);
    }
}