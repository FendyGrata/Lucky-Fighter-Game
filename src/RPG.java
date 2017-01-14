
/* @author Fendy & Rico
 */
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import model.*;
import util.FileUtil;
import util.RpgUtil;

public class RPG {

    static Scanner num = new Scanner(System.in);
    static Scanner word = new Scanner(System.in);
    static String saveanswer, back, answer, quitanswer, mainmenu, useTicket;
    static String firstname, lastname, gender, titlestatus;
    static int experience;
    static int choice, choice1, code, workchoice, ticketchoice, battlechoice, attackagain, relaxchoice, drinkchoice, shopchoice;//memuat nilai Scanner user
    static int ulang = 1, i;
    static int money, energy, title, upEnergy, upExp, upMoney, ticket, upTicket, hours, daysformat, hoursformat, upHours;//untuk update data pemain
    static boolean pass = false;

    public static void main(String[] args) throws InterruptedException {
//        AnsiConsole.systemInstall();
        printWelcome();//panggil method
        do {
            try {
                System.out.print("\t            Enter the Code: ");
                code = num.nextInt();
                if (code <= 0 || code > 4) {
                    throw new IllegalArgumentException();
                }
                pass = true;

                if ((code != 1) && (code != 2) && (code != 3) && (code != 4)) {
                    System.out.println("\tHoy Fighter! Please input with(1-4)!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\t   Error!! Please Input with Number(1-4)!");
            } catch (Exception e) {
                System.out.println("\t\t  Please Input With Number!");
                num.next();
            }
        } while ((code != 1) && (code != 2) && (code != 3) && (code != 4));
        if (code == 1) {//code adalah input pilihan main menu
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            code1();
        } else if (code == 2) {
            loadData();
            System.out.print(RpgUtil.ANSI_RED + "\t\tRedirecting to Menu " + RpgUtil.ANSI_CYAN);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▅ " + RpgUtil.ANSI_BLUE);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▇" + RpgUtil.ANSI_RESET);
            Fighter fighter;
            fighter = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);
            TimeUnit.MILLISECONDS.sleep(500);
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            printMenu();
        } else if (code == 3) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            code3();
        } else if (code == 4) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            RPG r1 = new RPG();// panggil method bs kek gni jg
            r1.code4();
        }
    }

    public static void printMenu() throws InterruptedException {

        System.out.println("\n=========================================================="
                + "\n---------------------------" + RpgUtil.ANSI_PURPLE + "M" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_PURPLE + "E" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_PURPLE + "N" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_PURPLE + "U" + RpgUtil.ANSI_RESET + "--------------------------"
                + "\n=========================================================="
                + "\n---" + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Quick Battle"
                + "\n---" + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Your Status"
                + "\n---" + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " Work"
                + "\n---" + RpgUtil.ANSI_YELLOW + " ❹" + RpgUtil.ANSI_RESET + " Relax"
                + "\n---" + RpgUtil.ANSI_PURPLE + " ❺" + RpgUtil.ANSI_RESET + " Shopping"
                + "\n---" + RpgUtil.ANSI_CYAN + " ❻" + RpgUtil.ANSI_RESET + " Save Journey"
                + "\n---" + RpgUtil.ANSI_RED + "❼" + RpgUtil.ANSI_RESET + " Exit Journey"
                + "\n==========================================================");
        do {
            try {
                System.out.print("\tYour Choice\t: ");
                choice = num.nextInt();
                if (choice <= 0 || choice > 7) {
                    throw new IllegalArgumentException();
                }
                pass = true;

                if ((choice != 1) && (choice != 2) && (choice != 3) && (choice != 4) && (choice != 5) && (choice != 6) && (choice != 7)) {
                    System.out.println("\tHoy Fighter! Please input with(1-7)!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\t   Error!! Please Input Number(1-7)!");
            } catch (Exception e) {
                System.out.println("\t\t  Please Input With Number!");
                num.next();
            }
        } while ((choice != 1) && (choice != 2) && (choice != 3) && (choice != 4) && (choice != 5) && (choice != 6) && (choice != 7));
        if (choice == 1) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            choice1();
        } else if (choice == 2) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            choice2();
        } else if (choice == 3) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            choice3();
        } else if (choice == 4) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            choice4();
        } else if (choice == 5) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            choice5();
        } else if (choice == 6) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            choice6();
            ulang = 2;
        } else if (choice == 7) {
            printEndStatement();
        }

    }

    public static void backMenu() throws InterruptedException {
        do {
            System.out.println("\n>>Back to Menu?(Y/N)<<");
            System.out.print("Response\t: ");
            back = word.nextLine();

            if (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N")) {
                System.out.println("\n" + gender + firstname + ", Please input with(Y/N)!");
            }
        } while (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N"));

        if (back.equals("y") || back.equals("Y")) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            printMenu();
        } else {
            printEndStatement();
        }
    }

    public static void printEndStatement() throws InterruptedException {
        Fighter fighter;
        fighter = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);
        do {
            System.out.println(">>Do you wanna save your progress first?(Y/N)<<");
            System.out.print("Response\t: ");
            saveanswer = word.nextLine();

            if (!saveanswer.equals("Y") && !saveanswer.equals("y") && !saveanswer.equals("n") && !saveanswer.equals("N")) {
                System.out.println("\n" + gender + firstname + ", Please input with(Y/N)!");
            }
        } while (!saveanswer.equals("Y") && !saveanswer.equals("y") && !saveanswer.equals("n") && !saveanswer.equals("N"));

        if (saveanswer.equals("y") || saveanswer.equals("Y")) {
            choice6();//choice6 buat save game
            printQuitGame();
            ulang = 2;
        } else if (saveanswer.equals("n") || saveanswer.equals("N")) {
            printQuitGame();
            ulang = 2;
        }
    }

    public static void printByeBye() {
        System.out.print("\n=o  o                                                o  o=");
        System.out.print("\n==o  o   OOOOO  O   O   OOO   O   O  O  O  OOOOO    o  o==");
        System.out.print("\n===o  o    O    O   O  O   O  OO  O  O O   O       o  o===");
        System.out.print("\n====o  o   O    OOOOO  OOOOO  O O O  OO    OOOOO  o  o====");
        System.out.print("\n===o  o    O    O   O  O   O  O  OO  O O       O   o  o===");
        System.out.print("\n==o  o     O    O   O  O   O  O   O  O  O  OOOOO    o  o==");
        System.out.println("\n=o  o             - -F O R- P L A Y I N G- -         o  o=");
    }

    public static void printQuitGame() throws InterruptedException {
        System.out.print("\t   Exiting Game " + RpgUtil.ANSI_PURPLE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▇ " + RpgUtil.ANSI_BLUE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▆" + RpgUtil.ANSI_RED);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("▅" + RpgUtil.ANSI_RESET);
    }

    public static void checkQualifications() throws InterruptedException {
        System.out.print("\tChecking your qualifications " + RpgUtil.ANSI_CYAN);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▇" + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(500);
    }

    public static void workSales() throws InterruptedException {//work uda beres energy, money, dan hours
        System.out.println("Sales job...");
        System.out.print("\tWorking " + RpgUtil.ANSI_CYAN);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▇" + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\n===Job Done===");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Energy-10, Life -7hours, Money+2000G, EXP+5.");
        upEnergy = energy - 10;
        energy = upEnergy;
        upHours = hours - 7;
        hours = upHours;
        upMoney = money + 2000;
        money = upMoney;
        upExp = experience + 5;
        experience = upExp;

    }

    public static void workManager() throws InterruptedException {
        System.out.println("Managing...");
        System.out.print("\tWorking " + RpgUtil.ANSI_CYAN);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▇" + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\n\t\t===Job Done===");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\tEnergy-20, Life -6hours, Money+5000G, EXP+10. ");
        upEnergy = energy - 20;
        energy = upEnergy;
        upHours = hours - 6;
        hours = upHours;
        upMoney = money + 5000;
        money = upMoney;
        upExp = experience + 10;
        experience = upExp;
    }

    public static void workBoss() throws InterruptedException {
        System.out.println("Boss job...");
        System.out.print("\tWorking " + RpgUtil.ANSI_CYAN);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▇" + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\n\t\t===Job Done===");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\tEnergy-30, Life -5hours, Money+10000G, EXP+15. ");
        upEnergy = energy - 30;
        energy = upEnergy;
        upHours = hours - 5;
        hours = upHours;
        upMoney = money + 10000;
        money = upMoney;
        upExp = experience + 15;
        experience = upExp;

    }

    public static void code1() throws InterruptedException {//method code-1

        System.out.println("\nBefore you start, would you please enter your data?");
        System.out.println(">>What is your title?<<"
                + "\n==" + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Un-Pekka Man"
                + "\n==" + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " So-Sensie Woman");
        do {
            System.out.print("Response\t: ");
            title = num.nextInt();
            if ((title != 1) && (title != 2)) {
                System.out.println("\tCome on! At least you got one. Input with(1)or(2)!");
            }
        } while ((title != 1) && (title != 2));
        if (title == 1) {
            gender = "Mr. ";
        } else {
            gender = "Mrs. ";
        }
        System.out.println(">>What is your " + RpgUtil.ANSI_CYAN + "'coolest'" + RpgUtil.ANSI_RESET + " name?<<");
        System.out.print("First Name\t: ");
        firstname = word.nextLine();
        System.out.print("Last Name\t: ");
        lastname = word.nextLine();
        System.out.print(RpgUtil.ANSI_RESET + "----------------------------------------------------------");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("\n\t   Processing your data " + RpgUtil.ANSI_CYAN);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▇" + RpgUtil.ANSI_RESET);
        System.out.print("\n\n  Hi " + RpgUtil.ANSI_BLUE + gender + firstname + RpgUtil.ANSI_RESET + ",");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("\n     Sadly I must say, your life remains " + RpgUtil.ANSI_RED + "100" + RpgUtil.ANSI_RESET + " days");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("\n   But don't worry! if you can gather " + RpgUtil.ANSI_GREEN + "money" + RpgUtil.ANSI_RESET + " and buy");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("\n  " + RpgUtil.ANSI_CYAN + "the Miracle Infinity Pill" + RpgUtil.ANSI_RESET + " within " + RpgUtil.ANSI_RED + "100 " + RpgUtil.ANSI_RESET + "days, then ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(1);
        System.out.print("\n\t\t  " + RpgUtil.ANSI_YELLOW + "¤" + RpgUtil.ANSI_RED + " Duar.rr.r ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_RED + ".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_RED + ".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_RED + ". " + RpgUtil.ANSI_YELLOW + "¤" + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("\n <==You can escape from this " + RpgUtil.ANSI_RED + "curse" + RpgUtil.ANSI_RESET + " & live " + RpgUtil.ANSI_GREEN + "eternal" + RpgUtil.ANSI_RESET + "==>");
        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.print("\n\tSystem says: Buahahaha!! ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_RED + "┹ ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_BLUE + "ʘ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_CYAN + ".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_CYAN + ".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_CYAN + ".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_BLUE + "ʘ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_RED + "┹" + RpgUtil.ANSI_RESET);
        money = 5000;
        energy = 100;
        ticket = 0;
        experience = 0;
        hours = 2400;
        Fighter fighter1 = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);

        do {
            System.out.println("\n     >>Are you " + RpgUtil.ANSI_GREEN + "lucky" + RpgUtil.ANSI_RESET + " enough to survive?(Y/N)<<");
            System.out.print("       Response\t: ");
            answer = word.nextLine();

            if (!answer.equals("Y") && !answer.equals("y") && !answer.equals("n") && !answer.equals("N")) {
                System.out.println("\n" + gender + firstname + ", Please input with(Y/N)!");
            }
        } while (!answer.equals("Y") && !answer.equals("y") && !answer.equals("n") && !answer.equals("N"));

        if (answer.equals("y") || answer.equals("Y")) {
            System.out.println("\n    Wow! You have a very Good Spirit! I like it!"
                    + RpgUtil.ANSI_GREEN + "\n\t         Good Luck " + gender + firstname + "!" + RpgUtil.ANSI_RESET);
        } else if (answer.equals("n") || answer.equals("N")) {
            System.out.println("\n\t  " + gender + firstname + ", be optimistic please!" + RpgUtil.ANSI_GREEN + "\n\t\t You can do it!" + RpgUtil.ANSI_RESET);
        }
        System.out.print("----------------------------------------------------------");
        TimeUnit.SECONDS.sleep(1);
        System.out.print("\n\t   Redirecting to Main Menu " + RpgUtil.ANSI_CYAN);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▇" + RpgUtil.ANSI_RESET);
        printMenu();
    }

    public static void code3() throws InterruptedException {
        System.out.print("\n=========================================================="
                + "\n----------------------" + RpgUtil.ANSI_GREEN + "A" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "B" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "O" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "U" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "T" + RpgUtil.ANSI_RESET + "---" + RpgUtil.ANSI_GREEN + "U" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "S" + RpgUtil.ANSI_RESET + "---------------------"
                + "\n=========================================================="
                + "\n" + RpgUtil.ANSI_GREEN + " Lucky Fighter" + RpgUtil.ANSI_RESET + " is an attractive & adventurous game that");
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.print("\n surely suits gamers who needs" + RpgUtil.ANSI_CYAN + " simple" + RpgUtil.ANSI_RESET + " but" + RpgUtil.ANSI_BLUE + " good" + RpgUtil.ANSI_RESET + " game.");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("\n Hihi ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_BLUE + "⊙");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_RED + "ɷ ");
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.print(RpgUtil.ANSI_BLUE + "⊙");
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.print(RpgUtil.ANSI_RESET + "\n\n This game is created by" + RpgUtil.ANSI_BLUE + " two" + RpgUtil.ANSI_RESET + " ordinary people who try to");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print("\n  understand how to code and " + RpgUtil.ANSI_GREEN + "luckily" + RpgUtil.ANSI_RESET + " this game can be");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print("\n    finished on time.Lol.. Yeah, at least there's ");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print("\n     something we have learnt from this " + RpgUtil.ANSI_CYAN + "game " + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.print(".");
        TimeUnit.MILLISECONDS.sleep(1800);
        System.out.print("\n\n\t And that " + RpgUtil.ANSI_BLUE + "two" + RpgUtil.ANSI_RESET + " ordinary people are ");
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.print(RpgUtil.ANSI_CYAN + ".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_BLUE + ".");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print(RpgUtil.ANSI_PURPLE + ".");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print("\n\t" + RpgUtil.ANSI_RED + " >>> ");
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.print(RpgUtil.ANSI_BLUE + "F");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "e");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "n");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "d");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "y");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print(RpgUtil.ANSI_BLUE + " G");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "r");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "a");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "t");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "a");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print(RpgUtil.ANSI_CYAN + " & ");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "R");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "i");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "c");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "o");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print(RpgUtil.ANSI_BLUE + " C");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "a");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "h");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "y");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "a");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "d");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.print(RpgUtil.ANSI_BLUE + "i");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print(RpgUtil.ANSI_RED + " <<<");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print(RpgUtil.ANSI_RESET + "\n\n\t  〖");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print("Thank you for playing this Game");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print("〗");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print("\n\t    Hope you enjoy it! ");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("<");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("-");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("-");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("⊙");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("ɷ");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("⊙");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("-");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("-");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print(">");
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.println("\n========================================================");
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.println("========================================================");
        TimeUnit.MILLISECONDS.sleep(1000);
        do {
            System.out.println("\n>>Back to Main Menu?? ");
            System.out.print("Response\t: ");
            mainmenu = word.nextLine();

            if (!mainmenu.equals("Y") && !mainmenu.equals("y") && !mainmenu.equals("n") && !mainmenu.equals("N")) {
                System.out.println("\nHoy Fighter! Please input with(Y/N)!");
            }
        } while (!mainmenu.equals("Y") && !mainmenu.equals("y") && !mainmenu.equals("n") && !mainmenu.equals("N"));

        if (mainmenu.equals("y") || mainmenu.equals("Y")) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\t     <===================================>");
            System.out.println("\t            ||       MENU       ||");
            System.out.println("\t           //  " + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Start Journey \\\\");
            System.out.println("\t          // " + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Load your Journey \\\\");
            System.out.println("\t         //   " + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " About This Game   \\\\");
            System.out.println("\t        //        " + RpgUtil.ANSI_YELLOW + " ❹" + RpgUtil.ANSI_RESET + " Exit Game      \\\\");
            System.out.println("\t        ------------------------------");
            do {
                System.out.print("\t              Enter the Code: ");
                code = num.nextInt();
                if ((code != 1) && (code != 2) && (code != 3) && (code != 4)) {
                    System.out.println("\tHoy Fighter! Please input with(1-4)!");
                }
            } while ((code != 1) && (code != 2) && (code != 3) && (code != 4));
            if (code == 1) {
                code1();
            } else if (code == 2) {

                loadData();
                System.out.print(RpgUtil.ANSI_RED + "\t\tRedirecting to Menu " + RpgUtil.ANSI_CYAN);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("▅ " + RpgUtil.ANSI_BLUE);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("▇" + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(500);
                printMenu();
            } else if (code == 3) {
                RpgUtil.clearScreen();
                TimeUnit.MILLISECONDS.sleep(500);
                code3();
            } else if (code == 4) {
                code4();
            }
        } else if (mainmenu.equals("n") || mainmenu.equals("N")) {
            printEndStatement();
        }
    }

    public static void code4() throws InterruptedException {
        do {
            System.out.println("\n\t   Are you sure wanna quit?(Y/N) (ʘ-ʘ)..");
            System.out.print("\t   >>Response\t: ");
            quitanswer = word.nextLine();
            if (!quitanswer.equals("Y") && !quitanswer.equals("y") && !quitanswer.equals("n") && !quitanswer.equals("N")) {
                System.out.println("\n Hoy Fighter! Please input with(Y/N)!");
            }
        } while (!quitanswer.equals("Y") && !quitanswer.equals("y") && !quitanswer.equals("n") && !quitanswer.equals("N"));

        if (quitanswer.equals("y") || quitanswer.equals("Y")) {
            printEndStatement();
        } else if (quitanswer.equals("n") || quitanswer.equals("N")) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("\t  ◇===================================◇");
            System.out.println("\t         ||    ⊙--MENU--⊙     ||");
            System.out.println("\t" + RpgUtil.ANSI_YELLOW + "҉" + RpgUtil.ANSI_RESET + "       //  " + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Start Journey   \\\\\t  " + RpgUtil.ANSI_RED + "҉" + RpgUtil.ANSI_RESET + "");
            System.out.println("" + RpgUtil.ANSI_BLUE + "҉" + RpgUtil.ANSI_RESET + "\t       // " + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Load your Journey  \\\\ " + RpgUtil.ANSI_PURPLE + "҉" + RpgUtil.ANSI_RESET + "");
            System.out.println("\t   " + RpgUtil.ANSI_PURPLE + "҉" + RpgUtil.ANSI_RESET + "  //   " + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " About This Game    \\\\\t         " + RpgUtil.ANSI_BLUE + "҉" + RpgUtil.ANSI_RESET + "");
            System.out.println("    " + RpgUtil.ANSI_RED + "҉" + RpgUtil.ANSI_RESET + "\t     //        " + RpgUtil.ANSI_YELLOW + " ❹" + RpgUtil.ANSI_RESET + " Exit Game       \\\\     " + RpgUtil.ANSI_YELLOW + "҉" + RpgUtil.ANSI_RESET + "");
            System.out.println("\t    〇------------------------------〇");
            do {
                System.out.print("\t              Enter the Code: ");
                code = num.nextInt();
                if ((code != 1) && (code != 2) && (code != 3) && (code != 4)) {
                    System.out.println("\tHoy Fighter! Please input with(1-4)!");
                }
            } while ((code != 1) && (code != 2) && (code != 3) && (code != 4));
            if (code == 1) {
                RpgUtil.clearScreen();
                TimeUnit.MILLISECONDS.sleep(500);
                code1();
            } else if (code == 2) {
                loadData();
                System.out.print(RpgUtil.ANSI_RED + "\t\tRedirecting to Menu " + RpgUtil.ANSI_CYAN);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("▅ " + RpgUtil.ANSI_BLUE);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("▇" + RpgUtil.ANSI_RESET);
                printMenu();
            } else if (code == 3) {
                RpgUtil.clearScreen();
                TimeUnit.MILLISECONDS.sleep(500);
                code3();
            } else if (code == 4) {
                RpgUtil.clearScreen();
                TimeUnit.MILLISECONDS.sleep(500);
                code4();
            }
        }
    }

    public static void choice1() throws InterruptedException {
        System.out.println("\n=========================================================="
                + "\n-----------------------" + RpgUtil.ANSI_GREEN + "B" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "A" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "T" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "T" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "L" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_GREEN + "E" + RpgUtil.ANSI_RESET + "------------------------"
                + "\n=========================================================="
                + "\n---" + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Easy"
                + "\n---" + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Medium"
                + "\n---" + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " Hard"
                + "\n---" + RpgUtil.ANSI_YELLOW + " ❹" + RpgUtil.ANSI_RESET + " Back"
                + "\n==========================================================");
        System.out.print("Your Choice\t: ");
        battlechoice = num.nextInt();
        if (battlechoice == 1) {
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            playgameeasy();
        } else if (battlechoice == 2) {//done
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            playgamemedium();
        } else if (battlechoice == 3) {//done
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            playgamehard();
        } else if (battlechoice == 4) {//done
            RpgUtil.clearScreen();
            TimeUnit.MILLISECONDS.sleep(500);
            printMenu();
        }
    }

    public static void choice2() throws InterruptedException {//done
        Fighter fighter;
        fighter = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);//menyimpan data array di fighter1
        fighter.printFighterStatus();
        do {
            System.out.println(">>Back to Menu?(Y/N)<<");
            System.out.print("Response\t: ");
            back = word.nextLine();

            if (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N")) {
                System.out.println("\n" + gender + firstname + ", Please input with(Y/N)!");
            }
        } while (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N"));

        if (back.equals("y") || back.equals("Y")) {
            System.out.print(RpgUtil.ANSI_RED + "\t\tRedirecting to Menu " + RpgUtil.ANSI_CYAN);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▅ " + RpgUtil.ANSI_BLUE);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▇" + RpgUtil.ANSI_RESET);
            TimeUnit.SECONDS.sleep(1);
            printMenu();
        } else if (back.equals("n") || back.equals("N")) {
            printEndStatement();
        }
    }

    public static void choice3() throws InterruptedException {// Working
        do {
            System.out.println("\t==What work do you want to apply?==");
            System.out.println("==" + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Sales  (Energy-10, Money+2000G,  Exp+5)");
            System.out.println("==" + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Manager(Energy-20, Money+5000G,  Exp+10)");
            System.out.println("==" + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " Boss   (Energy-30, Money+10000G, Exp+15)");
            System.out.print("Your Choice\t: ");
            workchoice = num.nextInt();

            if ((workchoice != 1) && (workchoice != 2) && (workchoice != 3)) {
                System.out.println("\n" + gender + firstname + ", Please input with(1-3)!");
            }
        } while ((workchoice != 1) && (workchoice != 2) && (workchoice != 3));

        if (workchoice == 1) {//sales
            if (hours < 7) {
                System.out.println("Your remaining time less than 7 hours");
                TimeUnit.MILLISECONDS.sleep(800);
                System.out.print("\tRedirecting to Menu " + RpgUtil.ANSI_CYAN);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("▅ " + RpgUtil.ANSI_BLUE);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
                TimeUnit.MILLISECONDS.sleep(700);
                System.out.print("▇" + RpgUtil.ANSI_RESET);
                TimeUnit.SECONDS.sleep(1);
                printMenu();

            } else if (hours >= 7) {
                if (energy < 10) {
                    System.out.println("==Your energy left " + energy + " %" + ". Doesn't fit this job==");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.print("\n\t\tRedirecting you to Menu" + RpgUtil.ANSI_CYAN);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("▅ " + RpgUtil.ANSI_BLUE);
                    TimeUnit.SECONDS.sleep(2);
                    System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("▇" + RpgUtil.ANSI_RESET);
                    TimeUnit.SECONDS.sleep(1);
                    printMenu();
                } else if ((energy >= 10) && (hours >= 7)) {

                    checkQualifications();
                    System.out.println("\n\t   =====You're Qualified=====");
                    workSales();
                    do {
                        backMenu();
                        if (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N")) {
                            System.out.println("\n" + gender + firstname + ", Please input with(Y/N)!");
                        }
                    } while (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N"));

                    if (back.equals("y") || back.equals("Y")) {
                        RpgUtil.clearScreen();
                        TimeUnit.MILLISECONDS.sleep(500);
                        printMenu();

                    } else {
                        RpgUtil.clearScreen();
                        TimeUnit.MILLISECONDS.sleep(500);
                        printEndStatement();
                        ulang = 2;
                    }
                }
            } else if (workchoice == 2) {//manager
                if (hours < 6) {
                    System.out.println("Your remaining time less than 6 hours");
                    TimeUnit.MILLISECONDS.sleep(800);
                    System.out.print("\tRedirecting to Menu " + RpgUtil.ANSI_CYAN);
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print("▅ " + RpgUtil.ANSI_BLUE);
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
                    TimeUnit.MILLISECONDS.sleep(700);
                    System.out.print("▇" + RpgUtil.ANSI_RESET);
                    TimeUnit.MILLISECONDS.sleep(500);
                    printMenu();
                } else if (hours >= 6) {
                    if (energy < 20) {
                        System.out.println("\t\t==Your energy left " + energy + " %" + ". Doesn't fit this job==");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print("\n\t\tRedirecting you to Menu");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print(".");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(".");
                        TimeUnit.SECONDS.sleep(1);
                        RpgUtil.clearScreen();
                        TimeUnit.MILLISECONDS.sleep(500);
                        printMenu();
                    } else if (energy >= 20) {
                        checkQualifications();
                        if (experience < 1000) {
                            System.out.print("\n  ==I'm sorry " + gender + firstname + ", I can't hire you.==");
                            TimeUnit.SECONDS.sleep(2);
                            System.out.print("\n   You haven't reached 1000EXP");
                            TimeUnit.SECONDS.sleep(2);
                            System.out.print("\n Come back when you've reached the qualifications.");
                            System.out.println("");
                            TimeUnit.SECONDS.sleep(3);
                            RpgUtil.clearScreen();
                            TimeUnit.MILLISECONDS.sleep(500);
                            printMenu();
                        } else if (experience >= 1000) {
                            System.out.println("\n\t\t=====You're Qualified=====");
                            workManager();
                        }
                        do {
                            TimeUnit.SECONDS.sleep(1);
                            backMenu();
                            if (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N")) {
                                System.out.println("\n" + gender + firstname + ", Please input with(Y/N)!");
                            }
                        } while (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N"));

                        if (back.equals("y") || back.equals("Y")) {
                            TimeUnit.SECONDS.sleep(1);
                            RpgUtil.clearScreen();
                            TimeUnit.MILLISECONDS.sleep(500);
                            printMenu();

                        } else {
                            TimeUnit.SECONDS.sleep(1);
                            RpgUtil.clearScreen();
                            TimeUnit.MILLISECONDS.sleep(500);
                            printEndStatement();
                        }
                    }
                }
            } else if (workchoice == 3) {//boss
                if (hours < 5) {
                    System.out.println("Your remaining time less than 5 hours");
                    TimeUnit.MILLISECONDS.sleep(800);
                    System.out.print("\tRedirecting to Menu " + RpgUtil.ANSI_CYAN);
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print("▅ " + RpgUtil.ANSI_BLUE);
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
                    TimeUnit.MILLISECONDS.sleep(700);
                    System.out.print("▇" + RpgUtil.ANSI_RESET);
                    TimeUnit.SECONDS.sleep(1);
                    printMenu();
                } else if (hours >= 5) {
                    if (energy < 30) {
                        System.out.println("\t\t==Your energy left " + energy + " %" + ". Doesn't fit this job==");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print("\n\t\tRedirecting you to Menu" + RpgUtil.ANSI_CYAN);
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
                        TimeUnit.SECONDS.sleep(2);
                        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print("▇" + RpgUtil.ANSI_RESET);
                        TimeUnit.SECONDS.sleep(1);
                        printMenu();
                    } else if (energy >= 30) {
                        checkQualifications();
                        if (experience < 5000) {
                            System.out.print("\n==I'm sorry " + gender + firstname + ", you're not suitable.==");
                            TimeUnit.SECONDS.sleep(2);
                            System.out.print("\n\t\tYou haven't reached 5000EXP");
                            TimeUnit.SECONDS.sleep(2);
                            System.out.print("\n Come back when you've reached the qualifications.");
                            System.out.println("");
                            TimeUnit.SECONDS.sleep(3);
                            printMenu();
                        } else if (experience >= 5000) {
                            System.out.println("\n\t\t=====You're Qualified=====");
                            workBoss();
                        }
                        do {
                            TimeUnit.SECONDS.sleep(1);
                            backMenu();
                            if (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N")) {
                                System.out.println("\n" + gender + firstname + ", Please input with(Y/N)!");
                            }
                        } while (!back.equals("Y") && !back.equals("y") && !back.equals("n") && !back.equals("N"));

                        if (back.equals("y") || back.equals("Y")) {
                            TimeUnit.SECONDS.sleep(1);
                            RpgUtil.clearScreen();
                            TimeUnit.MILLISECONDS.sleep(500);
                            printMenu();

                        } else {
                            TimeUnit.SECONDS.sleep(1);
                            RpgUtil.clearScreen();
                            TimeUnit.MILLISECONDS.sleep(500);
                            printEndStatement();
                        }
                    }
                }

            }

        }
    }

    public static void choice4() throws InterruptedException {
        do {
            System.out.println("\t==Do You Want To Relax?==");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("==" + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Nap  (Energy +10, Money-1000G,-2hours)");
            System.out.println("==" + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Salon (Energy +20, Money-2000G,-3hours)");
            System.out.println("==" + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " Swimming   (Energy +30, Money-3000G,-4hours)");
            System.out.print("Your Choice\t: ");
            relaxchoice = num.nextInt();

            if ((relaxchoice != 1) && (relaxchoice != 2) && (relaxchoice != 3)) {
                System.out.println("\n" + firstname + ", Please input with(1-3)!");
            }
        } while ((relaxchoice != 1) && (relaxchoice != 2) && (relaxchoice != 3));

        if (relaxchoice == 1) {
            System.out.print("Taking Nap " + RpgUtil.ANSI_CYAN);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("▅ " + RpgUtil.ANSI_BLUE);
            TimeUnit.SECONDS.sleep(2);
            System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("▇" + RpgUtil.ANSI_RESET);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\nEnergy boosted");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" +10");
            upEnergy = energy + 10;
            energy = upEnergy;
            upMoney = money - 1000;
            money = upMoney;
            upHours = hours - 2;
            hours = upHours;

            backMenu();

        }
        if (relaxchoice == 2) {
            System.out.print("Styling your hair " + RpgUtil.ANSI_CYAN);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("▅ " + RpgUtil.ANSI_BLUE);
            TimeUnit.SECONDS.sleep(2);
            System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("▇" + RpgUtil.ANSI_RESET);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\nEnergy boosted");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" +20");
            upEnergy = energy + 20;
            energy = upEnergy;
            upMoney = money - 2000;
            money = upMoney;
            upHours = hours - 3;
            hours = upHours;
            backMenu();

        }
        if (relaxchoice == 3) {

            System.out.print("Keep swimming " + RpgUtil.ANSI_CYAN);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("▅ " + RpgUtil.ANSI_BLUE);
            TimeUnit.SECONDS.sleep(2);
            System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("▇" + RpgUtil.ANSI_RESET);
            TimeUnit.SECONDS.sleep(1);
            System.out.print("\nEnergy boosted");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" +30");
            upEnergy = energy + 30;
            energy = upEnergy;
            upMoney = money - 3000;
            money = upMoney;
            upHours = hours - 4;
            hours = upHours;
            backMenu();
        }
    }

    public static void choice5() throws InterruptedException {
        int level;
        if (experience <= 100) {
            level = 1;
        } else {
            level = (int) Math.floor((experience / 100)); // 100 point for 1 level 
        }

        do {
            System.out.println("\t==" + RpgUtil.ANSI_RED + "F " + RpgUtil.ANSI_RESET + RpgUtil.ANSI_BLUE + "&" + RpgUtil.ANSI_RESET + RpgUtil.ANSI_RED + "R" + RpgUtil.ANSI_RESET + " Shopping Centre ==");
            System.out.println("\tWhat do you want to buy?");
            System.out.println("\t==" + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Super Energy Drink");
            System.out.println("\t==" + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Special Entrance Ticket");
            System.out.println("\t==" + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " Miracle Eternity Pill");
            System.out.println("\t==" + RpgUtil.ANSI_YELLOW + " ❹" + RpgUtil.ANSI_RESET + " Back");
            System.out.print("\tYour Choice\t: ");
            shopchoice = num.nextInt();

            if ((shopchoice != 1) && (shopchoice != 2) && (shopchoice != 3) && (shopchoice != 4)) {
                System.out.println("\n" + gender + firstname + ", Please input with(1-3)!");
            }
        } while ((shopchoice != 1) && (shopchoice != 2) && (shopchoice != 3) && (shopchoice != 4));

        if (shopchoice == 1) {

            System.out.println("Which drink do you wanna drink?");//drinkchoice 123 done!, 4 undone
            System.out.println("==" + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Soda-rkan drinkmoo(+10%) Price: 2000G");
            System.out.println("==" + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Hsyrup Khes-agar-an(+50%) Price: 8000G");
            System.out.println("==" + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " Rjamu-an Beer-kyasiet(+100%) Price: 15000G");
            System.out.println("==" + RpgUtil.ANSI_YELLOW + " ❹" + RpgUtil.ANSI_RESET + " Mysterious Water(+?%) Price:0G, Risk: 100% ");
            do {
                System.out.print("Your order please\t: ");
                drinkchoice = num.nextInt();

                if ((drinkchoice != 1) && (drinkchoice != 2) && (drinkchoice != 3) && (drinkchoice != 4)) {
                    System.out.println("\n" + gender + firstname + ", Please input with(1-4)!");
                }
            } while ((drinkchoice != 1) && (drinkchoice != 2) && (drinkchoice != 3) && (drinkchoice != 4));
            if (drinkchoice == 1) { //rico
                if (money < 2000) {
                    System.out.println("Not enough money!");//ditanya mau back menu gk kalo gk cukup duit
                    System.out.println("Remaining money is " + money + " G");
                    backMenu();
                } else if (money >= 2000) {
                    if (energy + 10 > 100) {
                        System.out.println("Energy storage can't accept more! ");
                        System.out.println("Remaining enery is " + energy + " %");
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backMenu();

                    } else {
                        System.out.print("\nEnergy added by ");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print("10 %");
                        upEnergy = energy + 10;
                        energy = upEnergy;
                        upMoney = money - 2000;
                        money = upMoney;
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backMenu();
                    }
                }
            } else if (drinkchoice == 2) {//rico
                if (money < 8000) {
                    System.out.println("Not enough money!");//ditanya mau back menu gk kalo gk cukup duit
                    System.out.println("Remaining money is " + money + " G");
                    backMenu();
                } else if (money >= 8000) {
                    if (energy + 50 > 100) {
                        System.out.println("Energy storage can't accept more! ");
                        System.out.println("Remaining enery is " + energy + " %");
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backMenu();

                    } else {
                        System.out.print("\nEnergy added by ");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print("50 %");
                        upEnergy = energy + 50;
                        energy = upEnergy;
                        upMoney = money - 8000;
                        money = upMoney;
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backMenu();
                    }
                }
            } else if (drinkchoice == 3) {//rico
                if (money < 15000) {
                    System.out.println("Not enough money!");//ditanya mau back menu gk kalo gk cukup duit
                    System.out.println("Remaining money is " + money + " G");
                    backMenu();
                } else if (money >= 15000) {
                    if (energy + 100 > 100) {
                        System.out.println("Energy storage can't accept more! ");
                        System.out.println("Remaining enery is " + energy + " %");
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backMenu();

                    } else {
                        System.out.print("\nEnergy added by ");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.print("100 %");
                        upEnergy = energy + 100;
                        energy = upEnergy;
                        upMoney = money - 15000;
                        money = upMoney;
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backMenu();
                    }
                }
            } else if (drinkchoice == 4) {//done
                if (experience <= 100) {
                    level = 1;
                } else {
                    level = (int) Math.floor((experience / 100)); // 100 point for 1 level 
                }
                if (level % 2 == 0) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n  \\“”“”““““””“”/                                            ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n  (  ʘ==ʘ )                                             ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n   (  ∆  )                                              ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n     || -o \"Go drink at yo house, freakin people!!\"   ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n    /||/       \"@%f-o*&n*n)ek!?@>..\"                  ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n     ||                                                 ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n     /\\                                                ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("\nSystem said:\" Pity you! Better luck next time!\"");
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.print(" Hihi ");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print("⊙");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print("ɷ");
                    TimeUnit.MILLISECONDS.sleep(700);
                    System.out.print("⊙");
                } else if (level % 2 == 1) {
                    System.out.print("\n  \\“”“”““““””“”/                                            ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n  (  ʘ==ʘ )                                             ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n   (  ◌  )                                              ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n     || -o \"Poor thirsty kid, here's some drink!\"   ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n    /||/                         ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n     ||                                                 ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\n     /\\                                                ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("System said:\"You're lucky, Ah Tong gives you water\"");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("\t\t\tEnergy boosted ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("+10%");
                    if (energy + 10 <= 100) {
                        upEnergy = energy + 10;
                        energy = upEnergy;
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backMenu();
                    } else {
                        System.out.println("Energy storage can't accept more! ");
                        System.out.println("Remaining enery is " + energy + " %");
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backMenu();
                    }

                }
            }
        } else if (shopchoice == 2) {//undone
            System.out.println("How many ticket(s) do you need?");
            System.out.println("==" + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Small(+1) Price: 5000G");
            System.out.println("==" + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Medium(+5) Price: 20000G");
            System.out.println("==" + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " Large(+10) Price: 30000G");
            do {
                System.out.print("Your order please\t: ");
                ticketchoice = num.nextInt();

                if ((ticketchoice != 1) && (ticketchoice != 2) && (ticketchoice != 3)) {
                    System.out.println("\n" + gender + firstname + ", Please input with(1-3)!");
                }
            } while ((ticketchoice != 1) && (ticketchoice != 2) && (ticketchoice != 3));
            if (ticketchoice == 1) { //done123
                if (money < 5000) {
                    System.out.println("Not enough money!");//ditanya mau back menu gk kalo gk cukup duit
                    backMenu();
                } else if (money >= 5000) {
                    upMoney = money - 5000;
                    money = upMoney;
                    upTicket = ticket + 1;
                    ticket = upTicket;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Ticket + 1");
                    TimeUnit.SECONDS.sleep(2);
                    backMenu();
                }
            } else if (ticketchoice == 2) {//done
                if (money < 20000) {
                    System.out.println("Not enough money!");//ditanya mau back menu gk kalo gk cukup duit
                    backMenu();
                } else if (money >= 20000) {
                    upMoney = money - 20000;
                    money = upMoney;
                    upTicket = ticket + 5;
                    ticket = upTicket;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Ticket + 5");
                    TimeUnit.SECONDS.sleep(2);
                    backMenu();
                }
            } else if (ticketchoice == 3) {//done
                if (money < 30000) {
                    System.out.println("Not enough money!");//ditanya mau back menu gk kalo gk cukup duit
                    backMenu();
                } else if (money >= 30000) {
                    upMoney = money - 30000;
                    money = upMoney;
                    upTicket = ticket + 10;
                    ticket = upTicket;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Ticket + 10");
                    TimeUnit.SECONDS.sleep(2);
                    backMenu();
                }
            }

        } else if (shopchoice == 3) {//done
            if (money < 10000000) {
                System.out.println("Not enough money!");//ditanya mau back menu gk kalo gk cukup duit
                backMenu();
            } else if (money >= 10000000) {
                System.out.print("\n");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You've Broken the Death Curse");
                TimeUnit.SECONDS.sleep(1);
                System.out.println(RpgUtil.ANSI_YELLOW + "\t\t*" + RpgUtil.ANSI_RESET);
                TimeUnit.SECONDS.sleep(1);
                System.out.println(RpgUtil.ANSI_YELLOW + "\t\t*" + RpgUtil.ANSI_RESET);
                TimeUnit.SECONDS.sleep(1);
                System.out.println(RpgUtil.ANSI_YELLOW + "\t\t*" + RpgUtil.ANSI_RESET);
                TimeUnit.SECONDS.sleep(1);
                System.out.println(RpgUtil.ANSI_BLUE + "\t==You've Become Eternal==" + RpgUtil.ANSI_RESET);
                TimeUnit.SECONDS.sleep(1);
                System.out.println(RpgUtil.ANSI_RED + "\tNow, Look Around" + RpgUtil.ANSI_RESET);
                TimeUnit.SECONDS.sleep(1);
                System.out.println(RpgUtil.ANSI_CYAN + "\tThat's Your New Journey" + RpgUtil.ANSI_RESET);
                TimeUnit.SECONDS.sleep(1);
                System.out.println(RpgUtil.ANSI_GREEN + "\t==Fight Against Reality==" + RpgUtil.ANSI_RESET);
                TimeUnit.SECONDS.sleep(1);

                if (title == 1) {
                    gender = "Mr. ";
                    titlestatus = "Un-Pekka Man";
                } else if (title == 2) {
                    gender = "Mrs. ";
                    titlestatus = "So-Sensie Woman";
                }
                Fighter fighter1 = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);
                daysformat = ((int) (Math.floor((hours / 24))));
                hoursformat = ((int) hours - (daysformat * 24));
                System.out.println("\n=========================================================="
                        + "\n------------------------" + RpgUtil.ANSI_BLUE + "S" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_BLUE + "T" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_BLUE + "A" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_BLUE + "T" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_BLUE + "U" + RpgUtil.ANSI_RESET + "-" + RpgUtil.ANSI_BLUE + "S" + RpgUtil.ANSI_RESET + "-----------------------"
                        + "\n==========================================================");
                System.out.println("Fighter Name\t: " + gender + firstname + " " + lastname);
                System.out.println("Title\t\t: " + titlestatus);
                System.out.println("Level\t\t: " + level + "\t\tExp:" + experience + " EXP");
                System.out.println("HP\t\t: " + fighter1.getHp() + "\t\tATK:" + fighter1.getAttack());
                System.out.println("Money\t\t: 999999999+" + " G");
                System.out.println("Energy\t\t: 999999999+" + " %");
                System.out.println("Ticket\t\t: 999999999+" + " ticket(s)");
                System.out.println("Time remaining\t: 999999999+" + " days & 999999999+" + " hours");
                System.out.println("==========================================================");
                printByeBye();
                ulang = 2;
            }
        } else if (shopchoice == 4) {
            System.out.print(RpgUtil.ANSI_RED + "\t\tRedirecting to Menu " + RpgUtil.ANSI_CYAN);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▅ " + RpgUtil.ANSI_BLUE);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print("▇" + RpgUtil.ANSI_RESET);
            printMenu();
        }

    }

    public static void choice6() throws InterruptedException {

        FileUtil futil = new FileUtil();
        Fighter fighter = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);
        String s1 = futil.openWriteFile("rpg.txt");
        String txtFormat = "%s,%s,%d,%d,%d,%d,%d,%d%n";
        String firstname1 = firstname;
        String lastname1 = lastname;
        int experience1 = experience;
        int energy1 = energy;
        int money1 = money;
        int title1 = title;
        int ticket1 = ticket;
        int hours1 = hours;
        Fighter fighter1 = new Fighter(firstname1, lastname1, experience1, energy1, money1, title1, ticket1, hours1);
        String s2 = futil.addWriteRecord(txtFormat, firstname1, lastname1, experience1, energy1, money1, title1, ticket1, hours1);
        String s4 = futil.closeWriteFile();

        System.out.print(RpgUtil.ANSI_RED + "\tSaving your progress " + RpgUtil.ANSI_CYAN);
        TimeUnit.SECONDS.sleep(1);
        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
        TimeUnit.SECONDS.sleep(1);
        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
        TimeUnit.SECONDS.sleep(1);
        System.out.print("▇" + RpgUtil.ANSI_RESET);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("\n\t--Data saved successfully--");

    }

    public static void loadData() throws InterruptedException {
        FileUtil futil = new FileUtil();
        String s1 = futil.openReadFile("rpg.txt");
        String firstname2 = "";
        String lastname2 = "";
        int experience2 = 0;
        int energy2 = 0;
        int money2 = 0;
        int title2 = 0;
        int ticket2 = 0;
        int hours2 = 0;

        String titlestatus = null;
        int daysformat2, hoursformat2;

        System.out.print(RpgUtil.ANSI_RED + "\n\t\t GETTING YOUR DATA " + RpgUtil.ANSI_CYAN);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▅ " + RpgUtil.ANSI_BLUE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▆ " + RpgUtil.ANSI_PURPLE);
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("▇" + RpgUtil.ANSI_RESET);
        TimeUnit.SECONDS.sleep(1);
        while (futil.getReadScanner().hasNext()) {
            // read line per line, split line by comma delimiter
            String[] readLine = futil.getReadScanner().next().split(",");

            // printout per line
            firstname2 = readLine[0];
            lastname2 = readLine[1];
            experience2 = Integer.parseInt(readLine[2]);
            energy2 = Integer.parseInt(readLine[3]);
            money2 = Integer.parseInt(readLine[4]);
            title2 = Integer.parseInt(readLine[5]);
            ticket2 = Integer.parseInt(readLine[6]);
            hours2 = Integer.parseInt(readLine[7]);
            daysformat2 = ((int) (Math.floor((hours2 / 24))));
            hoursformat2 = ((int) hours2 - (daysformat2 * 24));
            if (title2 == 1) {
                gender = "Mr. ";
                titlestatus = "Un-Pekka Man";
            } else if (title2 == 2) {
                gender = "Mrs. ";
                titlestatus = "So-Sensie Woman";
            }
            System.out.println("\n==========================================================");
            System.out.println("== Applying name\t\t= " + gender + firstname2 + " " + lastname2);
            System.out.println("== Applying experience\t\t= " + experience2 + " EXP");
            System.out.println("== Applying energy\t\t= " + energy2 + " %");
            System.out.println("== Applying money\t\t= " + money2 + " G");
            System.out.println("== Applying title\t\t= " + titlestatus);
            System.out.println("== Applying ticket number\t= " + ticket2);
            System.out.println("== Applying times remaining\t= " + daysformat2 + " days & " + hoursformat2 + " hours");
        }
        // close opening read file\

        String s3;
        s3 = futil.closeReadFile();

        TimeUnit.MILLISECONDS.sleep(500);
        System.out.print("==============");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("==============");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("==============");
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.print("================");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("");
        // create object hero, load name & experience
        firstname = firstname2;
        lastname = lastname2;
        experience = experience2;
        energy = energy2;
        money = money2;
        title = title2;
        ticket = ticket2;
        hours = hours2;
        Fighter fighter;
        fighter = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);
    }

    public static void printWelcome() {
        System.out.println("ꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾ"
                + "\nꜾ     " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "      " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "   " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "   " + RpgUtil.ANSI_GREEN + "֎֎֎֎" + RpgUtil.ANSI_RESET + "  "
                + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "  " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "  "
                + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "   " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "           " + RpgUtil.ANSI_CYAN + "© 2016" + RpgUtil.ANSI_RESET + "  Ꜿ"
                + "\nꜾ     " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "      " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "   " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "  " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "      " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + " " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "    " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + " " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "                    Ꜿ"
                + "\nꜾ     " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "      " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "   " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "  " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "      " + RpgUtil.ANSI_GREEN + "֎֎" + RpgUtil.ANSI_RESET + "      " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "    " + RpgUtil.ANSI_BLUE + "FIGHTER" + RpgUtil.ANSI_RESET + "          Ꜿ"
                + "\nꜾ     " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "      " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "   " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "  " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "      " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + " " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "     " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "         " + RpgUtil.ANSI_PURPLE + " by" + RpgUtil.ANSI_RESET + "         Ꜿ"
                + "\nꜾ     " + RpgUtil.ANSI_GREEN + "֎֎֎֎֎" + RpgUtil.ANSI_RESET + "   " + RpgUtil.ANSI_GREEN + "֎֎֎" + RpgUtil.ANSI_RESET
                + "    " + RpgUtil.ANSI_GREEN + "֎֎֎֎" + RpgUtil.ANSI_RESET + "  " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "  " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET + "    " + RpgUtil.ANSI_GREEN + "֎" + RpgUtil.ANSI_RESET
                + "            " + RpgUtil.ANSI_BG_RED + RpgUtil.ANSI_WHITE + "【F" + RpgUtil.ANSI_BG_RED + RpgUtil.ANSI_YELLOW + "&" + RpgUtil.ANSI_BG_RED + RpgUtil.ANSI_WHITE + "R】" + RpgUtil.ANSI_RESET + "   Ꜿ"
                + "\nꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾꜾ");
        System.out.println("\n\t    Hey yo! Welcome to " + RpgUtil.ANSI_GREEN + "Lucky Fighter" + RpgUtil.ANSI_RESET + "! ");
        System.out.println("\t  ◇===================================◇");
        System.out.println("\t         ||    ⊙--MENU--⊙     ||");
        System.out.println("\t" + RpgUtil.ANSI_YELLOW + "҉" + RpgUtil.ANSI_RESET + "       //  " + RpgUtil.ANSI_RED + "❶" + RpgUtil.ANSI_RESET + " Start Journey   \\\\\t  " + RpgUtil.ANSI_RED + "҉" + RpgUtil.ANSI_RESET + "");
        System.out.println("" + RpgUtil.ANSI_BLUE + "҉" + RpgUtil.ANSI_RESET + "\t       // " + RpgUtil.ANSI_BLUE + " ❷" + RpgUtil.ANSI_RESET + " Load your Journey  \\\\ " + RpgUtil.ANSI_PURPLE + "҉" + RpgUtil.ANSI_RESET + "");
        System.out.println("\t   " + RpgUtil.ANSI_PURPLE + "҉" + RpgUtil.ANSI_RESET + "  //   " + RpgUtil.ANSI_GREEN + " ❸" + RpgUtil.ANSI_RESET + " About This Game    \\\\\t         " + RpgUtil.ANSI_BLUE + "҉" + RpgUtil.ANSI_RESET + "");
        System.out.println("    " + RpgUtil.ANSI_RED + "҉" + RpgUtil.ANSI_RESET + "\t     //        " + RpgUtil.ANSI_YELLOW + " ❹" + RpgUtil.ANSI_RESET + " Exit Game       \\\\     " + RpgUtil.ANSI_YELLOW + "҉" + RpgUtil.ANSI_RESET + "");
        System.out.println("\t    〇------------------------------〇");
    }

    public void SpecialCharacter() {
        System.out.println("⺌〖〗】〒⊙⊕①②〣┹┺┿¤●◇▄▅▆▇█▓【】¤¢[$#\"»§ŒИ֏Օ۝߷߷߷Û〄〇öö֍֎∙•¤∞≥◊‡†…¡∆Ω∫§¦«±°÷’‘“”¡∆Ω∫§¦«±°÷’‘“”┹ʘ...ʘ┹ɷʬѼѽѾ҉҈؜ᴥẟὠ⃝①❶❷❸❹❺❻❼❽❾❿ꜾꜾⱯꜪ◊◌");
    }

    public static void printDeath() {
        System.out.println("==You're Dead==");
        System.out.println("Hiks.. Hikss..");
        System.out.println("Bye-bye!");
        ulang = 2;
    }

    public static void playgameeasy() throws InterruptedException {
        Fighter fighter1 = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);
        daysformat = ((int) (Math.floor((hours / 24))));
        hoursformat = ((int) hours - (daysformat * 24));
        int score = 0;
        System.out.println("\n=========================================================="
                + "\n--------------------------E-A-S-Y-------------------------"
                + "\n==========================================================");
        System.out.println(RpgUtil.ANSI_BLUE + " 【Your Status】" + RpgUtil.ANSI_RESET);
        System.out.println("Fighter Name\t: " + gender + firstname + " " + lastname);
        System.out.println("Level\t\t: " + fighter1.getLevel() + "\t\tExp : " + experience + " EXP");
        System.out.println("HP\t\t: " + fighter1.getHp());
        System.out.println("ATK\t\t: " + fighter1.getAttack() + "\t\tDEF : " + fighter1.getDefend());
        TimeUnit.MILLISECONDS.sleep(1000);
        Koranichi kora1 = new Koranichi(RpgUtil.randInt(600, 800) - 100);
        kora1.printKoranichiStatus();
        System.out.println("");

        int bround = 1;
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print(RpgUtil.ANSI_GREEN + "\t\tBegin Battle" + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.print(RpgUtil.ANSI_CYAN + "." + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.print(RpgUtil.ANSI_BLUE + "." + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.println(RpgUtil.ANSI_PURPLE + ".\n");
        do {
            if (kora1.getHp() - fighter1.getAttack() > 0) {
                System.out.println(RpgUtil.ANSI_CYAN + "==Round-" + bround + "==" + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(1000);
                kora1.hitToKoranichi(fighter1.getAttack());
                System.out.println("");
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(RpgUtil.ANSI_BLUE + "=You win!!=" + RpgUtil.ANSI_RESET);
                System.out.println("Money +5000, EXP+10");
                upEnergy = energy - 10;
                energy = upEnergy;
                upMoney = money + 5000;
                money = upMoney;
                upExp = experience + 10;
                experience = upExp;
                upHours = hours - 1;
                hours = upHours;
                TimeUnit.MILLISECONDS.sleep(500);
                backMenu();
            }

            if (fighter1.getHp() - kora1.getAttack() > 0) {
                TimeUnit.MILLISECONDS.sleep(1000);
                fighter1.hitToFighter(kora1.getAttack());

            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(RpgUtil.ANSI_RED + "=You lose!!=" + RpgUtil.ANSI_RESET);
                System.out.println("Money +0, EXP+0");
                upEnergy = energy - 10;
                energy = upEnergy;
                upMoney = money + 0;
                money = upMoney;
                upExp = experience + 0;
                experience = upExp;
                upHours = hours - 1;
                hours = upHours;
                TimeUnit.MILLISECONDS.sleep(500);
                backMenu();
            }

            System.out.println("");
            bround++;
            TimeUnit.MILLISECONDS.sleep(1000);
            score = score + 10;
            System.out.println("Your Score\t: " + score + " points");
            System.out.print(RpgUtil.ANSI_GREEN + ">>What do you wanna do?<<"
                    + RpgUtil.ANSI_RESET + "\n ==❶ Attack");
            System.out.println(RpgUtil.ANSI_RESET + "\n ==❷ Give Up");
            System.out.print(RpgUtil.ANSI_RESET + "Response\t: ");
            attackagain = num.nextInt();
            System.out.println("");
            if (attackagain == 2) {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(RpgUtil.ANSI_PURPLE + "=So weak!!=" + RpgUtil.ANSI_RESET);
                System.out.println("EXP-10");
                upEnergy = energy - 10;
                energy = upEnergy;
                upExp = experience - 10;
                experience = upExp;
                upHours = hours - 1;
                hours = upHours;
                TimeUnit.MILLISECONDS.sleep(500);
                backMenu();
            }

        } while ((attackagain != 2) && (kora1.getHp() > 0) && (fighter1.getHp() > 0));

    }

    public static void playgamemedium() throws InterruptedException {
        Fighter fighter1 = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);
        daysformat = ((int) (Math.floor((hours / 24))));
        hoursformat = ((int) hours - (daysformat * 24));
        int score = 0;
        System.out.println("\n=========================================================="
                + "\n------------------------M-E-D-I-U-M-----------------------"
                + "\n==========================================================");
        System.out.println(RpgUtil.ANSI_BLUE + " 【Your Status】" + RpgUtil.ANSI_RESET);
        System.out.println("Fighter Name\t: " + gender + firstname + " " + lastname);
        System.out.println("Level\t\t: " + fighter1.getLevel() + "\t\tExp : " + experience + " EXP");
        System.out.println("HP\t\t: " + fighter1.getHp());
        System.out.println("ATK\t\t: " + fighter1.getAttack() + "\t\tDEF : " + fighter1.getDefend());
        TimeUnit.MILLISECONDS.sleep(1000);
        Koranichi kora1 = new Koranichi(RpgUtil.randInt(700, 1000));
        kora1.printKoranichiStatus();
        System.out.println("");

        int bround = 1;

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.print(RpgUtil.ANSI_GREEN + "\t\tBegin Battle" + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.print(RpgUtil.ANSI_CYAN + "." + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.print(RpgUtil.ANSI_BLUE + "." + RpgUtil.ANSI_RESET);
        TimeUnit.MILLISECONDS.sleep(700);
        System.out.println(RpgUtil.ANSI_PURPLE + ".\n");
        do {
            if (kora1.getHp() - fighter1.getAttack() > 0) {
                System.out.println(RpgUtil.ANSI_CYAN + "==Round-" + bround + "==" + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(1000);
                kora1.hitToKoranichi(fighter1.getAttack());
                System.out.println("");
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(RpgUtil.ANSI_BLUE + "=You win!!=" + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Money +7000, EXP+15");
                upEnergy = energy - 10;
                energy = upEnergy;
                upMoney = money + 7000;
                money = upMoney;
                upExp = experience + 15;
                experience = upExp;
                upHours = hours - 2;
                hours = upHours;
                TimeUnit.MILLISECONDS.sleep(500);
                backMenu();
            }

            if (fighter1.getHp() - kora1.getAttack() > 0) {
                TimeUnit.MILLISECONDS.sleep(1000);
                fighter1.hitToFighter(kora1.getAttack());

            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(RpgUtil.ANSI_RED + "=You lose!!=" + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("Money +0, EXP+0");
                upEnergy = energy - 10;
                energy = upEnergy;
                upMoney = money + 0;
                money = upMoney;
                upExp = experience + 0;
                experience = upExp;
                upHours = hours - 2;
                hours = upHours;
                TimeUnit.MILLISECONDS.sleep(500);
                backMenu();
            }

            System.out.println("");
            bround++;
            TimeUnit.MILLISECONDS.sleep(1000);
            score = score + 15;
            System.out.println("Your Score\t: " + score + " points");
            System.out.print(RpgUtil.ANSI_GREEN + ">>What do you wanna do?<<"
                    + RpgUtil.ANSI_RESET + "\n ==❶ Attack");
            System.out.println(RpgUtil.ANSI_RESET + "\n ==❷ Give Up");
            System.out.print(RpgUtil.ANSI_RESET + "Response\t: ");

            attackagain = num.nextInt();
            System.out.println("");
            if (attackagain == 2) {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println(RpgUtil.ANSI_PURPLE + "=So weak!!=" + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("EXP-15");
                upEnergy = energy - 10;
                energy = upEnergy;
                upExp = experience - 15;
                experience = upExp;
                upHours = hours - 2;
                hours = upHours;
                TimeUnit.MILLISECONDS.sleep(500);
                backMenu();
            }

        } while ((attackagain != 2) && (kora1.getHp() > 0) && (fighter1.getHp() > 0));

    }

    public static void playgamehard() throws InterruptedException {
        if (ticket < 1) {
            System.out.println("You don't have Special Entrance Ticket");
            TimeUnit.SECONDS.sleep(1);
            printMenu();
        } else if (ticket >= 1) {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println(">>Do you want to use your ticket?(Y/N) " + "( " + ticket + " tickets left)<<");

            do {
                TimeUnit.SECONDS.sleep(1);
                System.out.print("Response\t: ");
                useTicket = word.nextLine();
                if (!useTicket.equals("Y") && !useTicket.equals("y") && !useTicket.equals("n") && !useTicket.equals("N")) {
                    System.out.println("\n" + gender + firstname + ", Please input with(Y/N)!");
                }
            } while (!useTicket.equals("Y") && !useTicket.equals("y") && !useTicket.equals("n") && !useTicket.equals("N"));

            if (useTicket.equals("y") || useTicket.equals("Y")) {
                upTicket = ticket - 1;
                ticket = upTicket;
                Fighter fighter1 = new Fighter(firstname, lastname, experience, energy, money, title, ticket, hours);
                daysformat = ((int) (Math.floor((hours / 24))));
                hoursformat = ((int) hours - (daysformat * 24));
                int score = 0;
                System.out.println("\n=========================================================="
                        + "\n--------------------------H-A-R-D-------------------------"
                        + "\n==========================================================");
                System.out.println(RpgUtil.ANSI_BLUE + " 【Your Status】" + RpgUtil.ANSI_RESET);
                System.out.println("Fighter Name\t: " + gender + firstname + " " + lastname);
                System.out.println("Level\t\t: " + fighter1.getLevel() + "\t\tExp : " + experience + " EXP");
                System.out.println("HP\t\t: " + fighter1.getHp());
                System.out.println("ATK\t\t: " + fighter1.getAttack() + "\t\tDEF : " + fighter1.getDefend());
                TimeUnit.MILLISECONDS.sleep(1000);
                Koranichi kora1 = new Koranichi(RpgUtil.randInt(900, 1500) - 300);
                kora1.printKoranichiStatus();
                System.out.println("");

                int bround = 1;
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.print(RpgUtil.ANSI_GREEN + "\t\tBegin Battle" + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(700);
                System.out.print(RpgUtil.ANSI_CYAN + "." + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(700);
                System.out.print(RpgUtil.ANSI_BLUE + "." + RpgUtil.ANSI_RESET);
                TimeUnit.MILLISECONDS.sleep(700);
                System.out.println(RpgUtil.ANSI_PURPLE + ".\n");
                do {
                    if (kora1.getHp() - fighter1.getAttack() > 0) {
                        System.out.println(RpgUtil.ANSI_CYAN + "==Round-" + bround + "==" + RpgUtil.ANSI_RESET);
                        TimeUnit.MILLISECONDS.sleep(1000);
                        kora1.hitToKoranichi(fighter1.getAttack());
                        System.out.println("");
                    } else {
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println(RpgUtil.ANSI_BLUE + "=You win!!=" + RpgUtil.ANSI_RESET);
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println("Money +20000, EXP+25");
                        upEnergy = energy - 10;
                        energy = upEnergy;
                        upMoney = money + 20000;
                        money = upMoney;
                        upExp = experience + 25;
                        experience = upExp;
                        upHours = hours - 3;
                        hours = upHours;
                        TimeUnit.MILLISECONDS.sleep(500);
                        backMenu();
                    }

                    if (fighter1.getHp() - kora1.getAttack() > 0) {
                        TimeUnit.MILLISECONDS.sleep(1000);
                        fighter1.hitToFighter(kora1.getAttack());

                    } else {
                        TimeUnit.MILLISECONDS.sleep(500);

                        System.out.println(RpgUtil.ANSI_RED + "=You lose!!=" + RpgUtil.ANSI_RESET);
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println("Money +0, EXP+0");
                        upEnergy = energy - 10;
                        energy = upEnergy;
                        upMoney = money + 0;
                        money = upMoney;
                        upExp = experience + 0;
                        experience = upExp;
                        upHours = hours - 3;
                        hours = upHours;
                        TimeUnit.MILLISECONDS.sleep(500);
                        backMenu();
                    }

                    System.out.println("");
                    bround++;
                    TimeUnit.MILLISECONDS.sleep(1000);
                    score = score + 20;
                    System.out.println("Your Score\t: " + score + " points");
                    System.out.print(RpgUtil.ANSI_GREEN + ">>What do you wanna do?<<"
                            + RpgUtil.ANSI_RESET + "\n ==❶ Attack");
                    System.out.println(RpgUtil.ANSI_RESET + "\n ==❷ Give Up");
                    System.out.print(RpgUtil.ANSI_RESET + "Response\t: ");
                    attackagain = num.nextInt();
                    System.out.println("");
                    if (attackagain == 2) {
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println(RpgUtil.ANSI_PURPLE + "=So weak!!=" + RpgUtil.ANSI_RESET);
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println("EXP-25");
                        upEnergy = energy - 10;
                        energy = upEnergy;
                        upExp = experience - 25;
                        experience = upExp;
                        upHours = hours - 3;
                        hours = upHours;
                        TimeUnit.MILLISECONDS.sleep(500);
                        backMenu();
                    }

                } while ((attackagain != 2) && (kora1.getHp() > 0) && (fighter1.getHp() > 0));
            } else if (useTicket.equals("n") || useTicket.equals("N")) {
                TimeUnit.MILLISECONDS.sleep(500);
                backMenu();
            }

        }
    }
}
