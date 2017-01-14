package model;

import util.RpgUtil;

public class Fighter {

    private String firstname, lastname, gender, titlestatus;
    private int title;
    private int level;
    private int money ;
    private int energy, upEnergy;
    public int experience, upMoney, upExp, ticket, upTicket,hours,upHours,hoursformat,daysformat;
    private int hp;
    private int attack,defend;
    private int getHp;

    public Fighter(String firstname,String lastname, int experience, int energy, int money, int title, int ticket, int hours) {

        double e = 100;
        this.firstname = firstname;
        this.lastname = lastname;
        this.money = money;
        this.energy = energy;
        this.experience = experience;
        this.title = title;
        this.ticket=ticket;
        this.hours=hours;
        if (title == 1) {
            gender = "Mr. ";
            titlestatus = "Un-Pekka Man";
        } else if (title == 2) {
            gender = "Mrs. ";
            titlestatus = "So-Sensie Woman";
        }
        if (this.experience <= 100) {
            this.level = 1;
        } else {
            this.level = (int) Math.floor((experience / e)); // 100 point for 1 level 
        }
        this.hp = 500 + (level * 5);
        this.attack = 30 + (level * 3);
        this.defend=level+7;

    }

    public int getDefend() {
        return defend;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }

    public int getUpEnergy() {
        return upEnergy;
    }

    public void setUpEnergy(int upEnergy) {
        this.upEnergy = upEnergy;
    }

    public int getUpMoney() {
        return upMoney;
    }

    public void setUpMoney(int upMoney) {
        this.upMoney = upMoney;
    }

    public int getUpExp() {
        return upExp;
    }

    public void setUpExp(int upExp) {
        this.upExp = upExp;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getUpTicket() {
        return upTicket;
    }

    public void setUpTicket(int upTicket) {
        this.upTicket = upTicket;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getUpHours() {
        return upHours;
    }

    public void setUpHours(int upHours) {
        this.upHours = upHours;
    }

    public void printFighterStatus() {
        Fighter fighter1 = new Fighter(firstname, lastname, experience, energy, money, title,ticket, hours);
        daysformat = ((int)(Math.floor((hours/ 24))));
        hoursformat = ((int)hours-(daysformat*24));
        System.out.println("\n=========================================================="
                + "\n------------------------"+RpgUtil.ANSI_BLUE+"S"+RpgUtil.ANSI_RESET+"-"+RpgUtil.ANSI_BLUE+"T"+RpgUtil.ANSI_RESET+"-"+RpgUtil.ANSI_BLUE+"A"+RpgUtil.ANSI_RESET+"-"+RpgUtil.ANSI_BLUE+"T"+RpgUtil.ANSI_RESET+"-"+RpgUtil.ANSI_BLUE+"U"+RpgUtil.ANSI_RESET+"-"+RpgUtil.ANSI_BLUE+"S"+RpgUtil.ANSI_RESET+"-----------------------"
                + "\n==========================================================");
        System.out.println("Fighter Name\t: " + gender + firstname+ " "+lastname);
        System.out.println("Title\t\t: " + titlestatus);
        System.out.println("Level\t\t: " + level + "\t\tExp:" + experience+" EXP");
        System.out.println("HP\t\t: " + hp + "\t\tATK:" + attack);
        System.out.println("Money\t\t: "+money+" G");
        System.out.println("Energy\t\t: " + energy+" %");
        System.out.println("Ticket\t\t: " + ticket+" ticket(s)");
        System.out.println("Life remaining\t: "+daysformat+" days & "+hoursformat+" hours");
        System.out.println("==========================================================");
    }

    public void hitToFighter(int enemyattack) {
        System.out.println(RpgUtil.ANSI_BLUE+" Y"+RpgUtil.ANSI_RESET+" |Fighter Whacked!! Hitpoint drained by " + enemyattack+" points"+" ("+defend+" points defended)");
        hp = hp - (enemyattack)+defend;
        int damage=enemyattack-defend;
        System.out.println(RpgUtil.ANSI_BLUE+" O"+RpgUtil.ANSI_RESET+" |Fighter HP -"+damage+" points");
        System.out.println(RpgUtil.ANSI_BLUE+" U"+RpgUtil.ANSI_RESET+" |FIghter HP left: " + hp+" points");
    }
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

   
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
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

    public int getGetHp() {
        return getHp;
    }

    public void setGetHp(int getHp) {
        this.getHp = getHp;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTitlestatus(String titlestatus) {
        this.titlestatus = titlestatus;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}
