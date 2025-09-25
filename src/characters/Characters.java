package src.characters;
import src.CharacterFactory.*;
import java.math.BigDecimal;

public abstract class Characters {
    protected String name;

    public String getName() {
        return name;
    }

    // Factory Method
    abstract public Characters createCharacter(String name);
    
    // Template Method
    public Characters deployForBattle(String name) {
        Characters character = createCharacter(name);
        System.out.println("🛡️ " + character.getName() + " has been deployed for battle!");
        return character;
    }

    abstract public BigDecimal getDamage();
    abstract public BigDecimal getHealth();
    abstract public BigDecimal getDefense();
    abstract public BigDecimal healthUpdate(BigDecimal damage);
}