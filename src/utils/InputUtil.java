package src.utils;
import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Kullanıcıdan belirli aralıkta integer input alır
     * @param prompt Kullanıcıya gösterilecek mesaj
     * @param min Minimum değer (dahil)
     * @param max Maximum değer (dahil)
     * @return Geçerli integer değer
     */
    public static int readInt(String prompt, int min, int max) {
        int input;
        
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                
                // Range kontrolü
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("❌ Please enter a number between " + min + " and " + max);
                }
                
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Buffer'ı temizle
            }
        }
    }
    
    /**
     * Scanner'ı kapatır (program sonunda kullanılabilir)
     */
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
