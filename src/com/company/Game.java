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
        players = gameTools.userNumberChoice(1, 4);

        for (int i = 1; i <= players; i++) {
            String name = ("player" + i);
            Player player = new Player(name, 3000);
            playerList.add(player);
        }
        System.out.println("How many rounds would you like to play?(5-30)");
        rounds = gameTools.userNumberChoice(5, 30);
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < playerList.size(); j++) {
                gameTools.clear();
                System.out.println("Round: " + (i + 1) + " (out of " + rounds + ")");
                showPlayerInventory(playerList.get(j));
                playerList.get(j).killPlayersAnimalBelowOneHp(playerList.get(j)); //test
                menu.mainMenu();
                String menuChoice = gameTools.userMainMenuChoice();
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
                    case "6":
                    case "-":
                        break;
                }
                playerList.get(j).decraseAllAnimalsHealth();

            }
            removePlayersWithoutMoneyAndAnimals();
            gameTools.clear();

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
        System.out.println("Food owned: ");
        System.out.println("Beef: " + player.howMuchFood("beef") + "kg");
        System.out.println("Corn: " + player.howMuchFood("corn") + "kg");
        System.out.println("Hay: " + player.howMuchFood("hay") + "kg");
        System.out.println("------------------------------------------");
        player.animalsOwned();
        gameTools.newLine();


    }

    public void removePlayersWithoutMoneyAndAnimals() {
        for (int j = playerList.size() - 1; j >= 0; j--) {
            if (playerList.get(j).getMoney() < 50 && playerList.get(j).getAnimalList().size() < 1) {
                gameTools.clear();
                System.out.println(playerList.get(j).getName() + " dont have enough money to keep on playing and has been kicked out of the game.");
                gameTools.pressToContinueLoop();
                playerList.remove(j);

            }

        }

         if(playerList.size() == 1 && players > 1){
             gameTools.clear();
            System.out.println(playerList.get(0).getName() + " has won the game since there are no other players remaining. Thanks for playing.");
            System.exit(0);
        }
         else if(playerList.size() < 1 && players == 1){
             gameTools.clear();
             System.out.println("GAME OVER");
             System.exit(0);
         }
        else if(playerList.size() < 1){
            gameTools.clear();
            System.out.println("There are no more players remaining.. Nobody finished the game.. Therefore nobody won.. GAME OVER");
            System.exit(0);
        }
    }

    public void declareWinner() {
        Player tempWinner = playerList.get(0);
        for (int i = 0; i < playerList.size() - 1; i++) {
            if (tempWinner.getMoney() < playerList.get(i + 1).getMoney()) {
                tempWinner = playerList.get(i + 1);
            }
        }
        gameTools.clear();
        System.out.println("The Game is now finished.\n");
        System.out.println("And the winner is..... " + tempWinner.getName() + " with " + tempWinner.getMoney() + "$. Thanks for playing.");
    }


}




