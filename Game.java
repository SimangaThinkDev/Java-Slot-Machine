/*
 🍒 🍉 🍋 🔔 ⭐
 */

import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        String[] roulette = {"🍒", "🍉", "🍋", "🔔", "⭐"};

        Random random = new Random();

        String[] rolls = {roulette[random.nextInt(5)], 
                        roulette[random.nextInt(5)], 
                        roulette[random.nextInt(5)]};

        for (String each: rolls) {
            System.out.print(each + " ");
        }

        System.out.println();
        scanner.close();
    }

 }