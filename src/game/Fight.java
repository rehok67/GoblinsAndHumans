package src.game;

import java.math.BigDecimal;
import java.util.Random;
import src.characters.Characters;
import src.GameCommand.CommandFactory;
import src.GameCommand.GameCommand;
import src.Turn.AutoTurnSelector;
import src.Turn.TurnType;
import src.Turn.UserTurnSelector;
// Fight class uses CalcRound to simulate turn-based combat
public class Fight {
    
    // Simulate multiple rounds until one player dies
    public void simulateWar(Characters player1, Characters player2) {
        // Better approach: Single Random instance, properly seeded
        Random gameRandom = new Random();
        CalcAttackRound calcRound = new CalcAttackRound(gameRandom, gameRandom);
        int roundNumber = 1;
        UserTurnSelector userTurn = new UserTurnSelector();
        AutoTurnSelector autoTurn = new AutoTurnSelector();
        
        System.out.println("=== WAR BEGINS (AI ENEMY) ===");
        System.out.println(player1.getName() + " (HP: " + player1.getHealth() + ") vs " + 
                          player2.getName() + " (HP: " + player2.getHealth() + ")");
        System.out.println();
        TurnType player2Choice = autoTurn.selectTurn(player2);
        GameCommand player2Command = CommandFactory.createCommand(player2Choice, player2, player1);
        
        while (player1.getHealth().compareTo(BigDecimal.ZERO) > 0 && 
               player2.getHealth().compareTo(BigDecimal.ZERO) > 0) {
            
            
            System.out.println("=== ROUND " + roundNumber + " ===");
            TurnType player1Choice = userTurn.selectTurn(player1);
            GameCommand player1Command = CommandFactory.createCommand(player1Choice, player1, player2);
            player1Command.execute(); // Bu kadar! If-else'e gerek yok!
            if (player2.getHealth().compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println(player2.getName() + " has been defeated!");
                break;
            }

            // Player 2's turn
        
            player2Command.execute();
            if (player1.getHealth().compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println(player1.getName() + " has been defeated!");
                break;
            }
            roundNumber++;
        }
    
    }
}
