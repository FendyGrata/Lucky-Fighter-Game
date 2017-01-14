package model;

import util.RpgUtil;

public class Koranichi {

    private int attack;
    private int hp;
    private int defend;
    private int level;
    private int experience;
    public double getHp;
    
    public Koranichi(int experience) {
        int e = 100;        
        this.experience = experience;
        if (this.experience <= 100) {
            this.level = 1;
        } else {
            this.level = (int) Math.floor((experience / e)); // 100 point for 1 level 
        }
        this.attack = 20+(level * 3);
        this.hp = 60*level;
        this.defend = level +5;
        
    }
    
    public void printKoranichiStatus() { 
        System.out.println(RpgUtil.ANSI_RED+"【Koranichi Status】"+RpgUtil.ANSI_RESET);
        System.out.println("Enemy Name\t: Koranichi (Level "+level+" )");
        System.out.println("Exp\t\t: " + experience + " EXP");
        System.out.println("HP\t\t: " + hp+ "\nATK\t\t: " + attack+ "\t\tDEF : "+defend);
    }
    
    public void hitToKoranichi(int heroattack) {
        System.out.println(RpgUtil.ANSI_RED+"H"+RpgUtil.ANSI_RESET+" |Koranichi Whacked!! Hitpoint drained by " + heroattack+" points"+" ("+defend+" points defended)");
        hp = hp - (heroattack)+defend;
        int damage=heroattack-defend;
        System.out.println(RpgUtil.ANSI_RED+"I"+RpgUtil.ANSI_RESET+" |Koranichi HP -"+damage+" points");
        System.out.println(RpgUtil.ANSI_RED+"M"+RpgUtil.ANSI_RESET+" |Koranichi HP left: " + hp+" points");
    }
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public double getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }    
}
