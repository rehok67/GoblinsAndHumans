package src.game;

import java.math.BigDecimal;
import java.util.Random;
import src.characters.Characters;

// Fight class uses CalcRound to simulate turn-based combat
public class Fight {
    
    // Simulate multiple rounds until one player dies
    public void simulateWar(Characters player1, Characters player2) {
        CalcRound calcRound = new CalcRound(new Random(), new Random());
        int roundNumber = 1;
        
        System.out.println("=== WAR BEGINS ===");
        System.out.println(player1.getName() + " (HP: " + player1.getHealth() + ") vs " + 
                          player2.getName() + " (HP: " + player2.getHealth() + ")");
        System.out.println();
        
        while (player1.getHealth().compareTo(BigDecimal.ZERO) > 0 && 
               player2.getHealth().compareTo(BigDecimal.ZERO) > 0) {
            
            System.out.println("=== ROUND " + roundNumber + " ===");
            
            // Player 1 attacks Player 2
            System.out.println(player1.getName() + "'s turn:");
            BigDecimal attackResult = calcRound.executeRound(player1, player2);
            player2.healthUpdate(attackResult);
            System.out.println(player2.getName() + " remaining HP: " + player2.getHealth());
            
            // Check if player2 is dead
            if (player2.getHealth().compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("\n🏆 " + player1.getName() + " WINS! " + player2.getName() + " has been defeated!");
                break;
            }
            
            System.out.println("\n" + player2.getName() + "'s turn:");
            attackResult = calcRound.executeRound(player2, player1);
            player1.healthUpdate(attackResult);
            System.out.println(player1.getName() + " remaining HP: " + player1.getHealth());
            
            // Check if player1 is dead
            if (player1.getHealth().compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("\n🏆 " + player2.getName() + " WINS! " + player1.getName() + " has been defeated!");
                break;
            }
            
            System.out.println("\n--- End of Round " + roundNumber + " ---\n");
            roundNumber++;
        }
        
        System.out.println("=== WAR ENDED after " + (roundNumber - 1) + " rounds ===");
    }
}
