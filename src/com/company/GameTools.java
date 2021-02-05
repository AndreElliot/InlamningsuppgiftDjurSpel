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


}
