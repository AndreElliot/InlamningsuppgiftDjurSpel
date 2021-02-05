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
    GameTools gameTools = new GameTools();


    public void run() {
        System.out.println("How many people will be playing?(1-4)");
        int players = gameTools.userNumberChoice(1, 4);

        for (int i = 1; i <= players; i++) {
            String name = ("player" + i);
            Player player = new Player(name, 3000);
            playerList.add(player);
        }
        System.out.println("How many rounds would you like to play?(5-30)");
        int rounds = gameTools.userNumberChoice(5, 30);
        //scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < playerList.size(); j++) {
                System.out.println("Round: " + (i + 1));
                showPlayerInventory(playerList.get(j));
                playerList.get(j).killPlayersAnimalBelowOneHp(playerList.get(j)); //test
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
            removePlayersWithoutMoneyAndAnimals();


        }
        for (int i = 0; i < playerList.size(); i++) {
            store.sellAllAnimals(playerList.get(i));
        }
        declareWinner();
    }

    public void showPlayerInventory(Player player) {
        System.out.print("Player: " + player.getName());
        System.out.println("     |     Money: $" + player.getMoney());
        System.out.println("------------------------------------------");
        System.out.print("Food owned: ");
        System.out.println("Beef: " + player.howMuchFood("beef") + "kg");
        System.out.println("Corn: " + player.howMuchFood("corn") + "kg");
        System.out.println("------------------------------------------");
        player.animalsOwned();
        System.out.println("\n");


    }

    public void removePlayersWithoutMoneyAndAnimals() {
        for (int j = playerList.size() - 1; j >= 0; j--) {
            if (playerList.get(j).getMoney() < 50 && playerList.get(j).getAnimalList().size() < 1) {
                System.out.println(playerList.get(j).getName() + " dont have enough money to keep on playing and has been kicked out of the game. Press \"-\" to continue playing. ");
                gameTools.pressToContinueLoop();
                playerList.remove(j);

            }

        }
    }

    public void declareWinner() {
        Player tempWinner = playerList.get(0);
        for (int i = 0; i < playerList.size() - 1; i++) {
            if (tempWinner.getMoney() < playerList.get(i + 1).getMoney()) {
                tempWinner = playerList.get(i + 1);
            }
        }
        System.out.println("The Game is now finished.\n");
        System.out.println("And the winner is..... " + tempWinner.getName() + " with " + tempWinner.getMoney() + "$. Thanks for playing.");
    }


}




