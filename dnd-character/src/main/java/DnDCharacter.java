import java.util.*;

class DnDCharacter {
    private int hitpoints = 10;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    int ability() {
        return new Random().nextInt(16) + 3;
    }

    int modifier(int input) {
        int modifier = (int) Math.floor((((double) input - 10.0) / 2));
        return modifier;
    }

    int getStrength() {
        if (strength == 0) {
            strength = ability();
        }
        return strength;
    }

    int getDexterity() {
        if (dexterity == 0) {
            dexterity = ability();
        }
        return dexterity;
    }

    int getConstitution() {
        if (constitution == 0) {
            constitution = ability();
            this.hitpoints += modifier(constitution);
        }
        return constitution;
    }

    int getIntelligence() {
        if (intelligence == 0) {
            intelligence = ability();
        }
        return strength;
    }

    int getWisdom() {
        if (wisdom == 0) {
            wisdom = ability();
        }
        return wisdom;
    }

    int getCharisma() {
        if (charisma == 0) {
            charisma = ability();
        }
        return charisma;
    }

    int getHitpoints() {
        return this.hitpoints;
    }

}
