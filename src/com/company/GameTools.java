package com.company;

import java.util.Scanner;

public class GameTools {


    public void clear() {
        System.out.println("\n".repeat(40));
    }
    public void newLine(){
        System.out.println("\n");
    }

    public int userNumberChoice(int lowestNumber, int highestNumber) { //not READY
        Scanner scan = new Scanner(System.in);
        int playersChoice = 0;

        while (true) {
            try {
                playersChoice = Integer.parseInt(scan.nextLine());

            } catch (Exception exception) {

            }
            if (playersChoice < lowestNumber || playersChoice > highestNumber) {
                System.out.println("Invalid choice, please try again");
            } else return playersChoice;
        }

    }

    public int userInputToInt() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (Exception exception) {
                System.out.println("Wrong character input, try again");
            }
        }
    }
    public String userAnimalToBuy(){   //not working yet
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.nextLine();

        while (!(playersChoice.equals("lion") || playersChoice.equals("tiger") || playersChoice.equals("horse") || playersChoice.equals("cow") || playersChoice.equals("chicken") || playersChoice.equals("-"))){
            System.out.println("invalid input, please try again.");
            playersChoice = scan.nextLine();



        }
        return playersChoice;
        }




    public void pressToContinueLoop() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nPress \"-\" to continue");
            String finishturn = scan.nextLine();
            if (finishturn.equals("-")) {
                break;
            }
        }
    }
    public String NumberChoice() { //not READY
        Scanner scan = new Scanner(System.in);
        String playersChoice = "";

        while (true) {
            try {
                playersChoice = scan.nextLine();

            } catch (Exception exception) {

            }
            if (!(playersChoice.equals("lion") || playersChoice.equals("tiger") || playersChoice.equals("horse") || playersChoice.equals("cow") || playersChoice.equals("chicken"))) {
                System.out.println("Invalid choice, please try again");
            } else return playersChoice;
        }

    }


}
