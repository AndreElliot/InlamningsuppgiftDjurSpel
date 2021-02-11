package com.company;

import java.util.Scanner;

public class GameTools {


    public void clear() {
        System.out.println("\n".repeat(40));
    }

    public void newLine() {
        System.out.println("\n");
    }

    public int userNumberChoice(int lowestNumber, int highestNumber) {
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

    public String userAnimalToBuy() {
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.nextLine().toLowerCase();

        while (!(playersChoice.equals("lion") || playersChoice.equals("tiger") || playersChoice.equals("horse") || playersChoice.equals("cow") || playersChoice.equals("chicken") || playersChoice.equals("-"))) {
            System.out.println("invalid input, please try again.");
            playersChoice = scan.nextLine().toLowerCase();


        }
        return playersChoice;
    }

    public String userChooseGender() {
        Scanner scan = new Scanner(System.in);
        String gender = scan.nextLine().toLowerCase();

        while (!(gender.equals("female") || gender.equals("male"))) {
            System.out.println("invalid gender, please try again.");
            gender = scan.nextLine().toLowerCase();


        }
        return gender;
    }

    public String userChooseFood() {
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.nextLine().toLowerCase();

        while (!(playersChoice.equals("beef") || playersChoice.equals("hay") || playersChoice.equals("corn") || playersChoice.equals("-"))) {
            System.out.println("invalid input, please try again.");
            playersChoice = scan.nextLine().toLowerCase();


        }
        return playersChoice;
    }
    public Animal userChooseAnimal(Player player) {
        Scanner scan = new Scanner(System.in);
        String animalName = "";
        Animal animal = null;
        while (animal == null && (!animalName.equals("-"))) {
            animalName = scan.nextLine();
            for (Animal everyAnimal : player.getAnimalList()) {
                if (everyAnimal.getName().equalsIgnoreCase(animalName)) {
                    animal = everyAnimal;


                }
            }
            if (animal == null && !animalName.equals("-")){
                System.out.println("You dont have a animal named: " + animalName + ". Try typing in the name of the animal again.");
            }


        }
        return animal;
    }

    public String userMainMenuChoice() {
        Scanner scan = new Scanner(System.in);
        String playersChoice = scan.nextLine();

        while (!(playersChoice.equals("1") || playersChoice.equals("2") || playersChoice.equals("3") || playersChoice.equals("4")
                || playersChoice.equals("5") || playersChoice.equals("6") || playersChoice.equals("-"))) {
            System.out.println("invalid input, try again.");
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


}
