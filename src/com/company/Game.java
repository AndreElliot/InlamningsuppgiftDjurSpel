package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    int rounds;
    int players;
    private ArrayList<Player> playerList = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    Store store = new Store();
    Menu menu = new Menu();


    public void run() {
        System.out.println("How many people will be playing?(1-4)");
        int players = scan.nextInt();
        for (int i = 1; i <= players; i++) {
            String name = ("player" + i);
            Player player = new Player(name, 3000);
            playerList.add(player);
        }
        System.out.println("How many rounds would you like to play?(5-30)");
        int rounds = scan.nextInt();
        scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.
        for (int i = 0; i < rounds; i++) {
            System.out.println("Round: " + (i+1));
            for (int j = 0; j < players; j++) {
                showPlayerInventory(playerList.get(j));
                menu.mainMenu();
                String menuChoice = scan.nextLine();
                switch (menuChoice) {
                    case "1":
                        menu.animalMenu();
                        store.whatAnimalToBuy(playerList.get(j));
                        break;
                    case "2":
                        menu.foodMenu();
                        store.whatFoodToBuy(playerList.get(j));
                        break;
                    case "3":
                        playerList.get(j).feedAnimal(playerList.get(j));
                        break;
                    case "4":
                        playerList.get(j).breedAnimals(playerList.get(j));
                        break;
                    case "5":
                        store.sellAnimals(playerList.get(j));
                        break;
                }
                playerList.get(j).decraseAllAnimalsHealth();
                System.out.println("\n".repeat(20));

            }
        }
    }


    public void showPlayerInventory(Player player) {
        System.out.print("Player: " + player.getName());
        System.out.println("     |     Money: " + player.getMoney());
        System.out.println("------------------------------------------");
        System.out.print("Food owned: ");
        System.out.println("Beef: " + player.howMuchFood("beef") + "kg");
        System.out.println("Corn: " + player.howMuchFood("corn") + "kg");
        System.out.println("------------------------------------------");
        player.animalsOwned();

    }



}
