package src.characters;

import java.math.BigDecimal;

public class Human extends Characters {
    private BigDecimal damage;
    private BigDecimal health;
    private BigDecimal defense;

    public Human(String name, BigDecimal damage, BigDecimal health, BigDecimal defense) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defense = defense;
    }
    
    public BigDecimal getDamage() {
        return damage;
    }
    
    public BigDecimal getHealth() {
        return health;
    }
    
    public BigDecimal getDefense() {
        return defense;
    }
    @Override
    public Characters createCharacter(String name){
        return new Human(name, BigDecimal.valueOf(30), BigDecimal.valueOf(100), BigDecimal.valueOf(10));
    }
    
    public BigDecimal healthUpdate(BigDecimal damage) {
        health = health.subtract(damage);
        // Can negatif olamaz
        if (health.compareTo(BigDecimal.ZERO) < 0) {
            health = BigDecimal.ZERO;
        }
        return health;
    }
}