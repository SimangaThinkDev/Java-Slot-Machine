/*
 🍒 🍉 🍋 🔔 ⭐
 */

import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static int Balance = 100;
    
    public static void main(String[] args) throws InterruptedException {

        String[] roulette = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        int bet;

        Random random = new Random();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("      Welcome to The Slot Game      ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("Your current balance: %d\n", Balance);
        System.out.println("What is your bet amount?");
        System.out.print(">> ");
        bet = scanner.nextInt(); scanner.nextLine();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (bet > Balance) {
            System.out.println("You don't have the funds for this \n         Please reconsider you bet");
            Thread.sleep(2000);
            main(args);
        }

        String[] rolls = {roulette[random.nextInt(5)], 
                        roulette[random.nextInt(5)], 
                        roulette[random.nextInt(5)],};

        System.out.println("Spinning...");
        Thread.sleep(3000);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("       |  ");
        for (String each: rolls) {
            System.out.print(each + "  |  ");
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Thread.sleep(500);

        if (rolls[0].equals(rolls[1]) && rolls[0].equals(rolls[2])) {
            // Increment Balance
            System.out.println("~~~~~~~~~~YOU HIT THE BONUS~~~~~~~~~");
            System.out.println("            YOU WIN R"+ bet * 4);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            Balance += bet * 4;
        } else if (rolls[0].equals(rolls[1]) || 
                    rolls[0].equals(rolls[2]) ||
                    rolls[1].equals(rolls[2])) {
                        System.out.println("~~~~~~~~YOU HIT THE Semi_BONUS~~~~~~");
                        System.out.println("            YOU WIN R"+ bet * 2);
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        Balance += bet * 2;
        } else {
            System.out.println("Trrrr, money out R" + bet);
            Balance -= bet;
        }

        System.out.println();
        gameState();
        scanner.close();
    }
    private static void gameState() throws InterruptedException {
        System.out.println("Do you want to continue?");
        System.out.print(">> ");
        String response = scanner.nextLine();

        if (response.toLowerCase().equals("yes")) {
            main(null);
        }
    }
}