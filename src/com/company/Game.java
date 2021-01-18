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
            for (int j = 0; j < players; j++) {
                showPlayerInventory(playerList.get(j));
                menu.mainMenu();
                String menuChoice = scan.nextLine();
                switch (menuChoice) {
                    case "1":
                        menu.animalMenu();
                        whatAnimalToBuy(playerList.get(j));
                        break;
                    case "2":
                        menu.foodMenu();
                        whatFoodToBuy(playerList.get(j));
                }
                playerList.get(j).decraseAllAnimalsHealth();

            }
        }
    }


    public void whatAnimalToBuy(Player player) {

        while (true) {
            System.out.println("Choose the animal you want to buy or type in \"-\" to finish your turn");
            String buyAnimalMenu = scan.nextLine().toLowerCase();
            if (buyAnimalMenu.equals("-")) {
                break;
            }

            System.out.println("How many animals would you like to buy?");
            int buyAnimalAmount = scan.nextInt();
            scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.

            if (checkIfPlayerHasEnoughMoney(buyAnimalMenu, buyAnimalAmount, player)) {
                System.out.println("You dont have enough money for this. Redo you decisions and make sure you have enough money in the bank for it.");
                continue;
            }
            switch (buyAnimalMenu) {
                case "tiger":
                    for (int i = 0; i < buyAnimalAmount; i++) {
                        System.out.println("What Gender do you want to buy?");
                        String gender = scan.nextLine();
                        System.out.println("Give the animal a name:");
                        String name = scan.nextLine();
                        Tiger tiger = new Tiger(name, 100, gender);
                        player.addAnimal(tiger);
                        updateWallet("tiger", player);
                    }
                    break;
                case "chicken":
                    for (int i = 0; i < buyAnimalAmount; i++) {
                        System.out.println("What Gender do you want to buy?");
                        String gender = scan.nextLine();
                        System.out.println("Give the animal a name:");
                        String name = scan.nextLine();
                        Chicken chicken = new Chicken(name, 100, gender);
                        player.addAnimal(chicken);
                        updateWallet("chicken", player);
                    }
                    break;
            }
        }
    }

    public void whatFoodToBuy(Player player) {
        while (true) {
            System.out.println("Choose what food you want to buy or type in \"-\" to finish your turn");
            String buyFoodMenu = scan.nextLine().toLowerCase();
            if (buyFoodMenu.equals("-")) {
                break;
            }
            System.out.println("How many kg food would you like to buy?");
            int buyFoodAmount = scan.nextInt();
            scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.

            if (checkIfPlayerHasEnoughMoney(buyFoodMenu, buyFoodAmount, player)) {
                System.out.println("You dont have enough money for this. Redo you decisions and make sure you have enough money in the bank for it.");
                continue;
            }
            switch (buyFoodMenu) {
                case "beef":
                    for (int i = 0; i < buyFoodAmount; i++) {
                        Beef beef = new Beef();
                        player.addFood(beef);
                        updateWallet("beef", player);
                    }
                    break;
                case "corn":
                    for (int i = 0; i < buyFoodAmount; i++) {
                        Corn corn = new Corn();
                        player.addFood(corn);
                        updateWallet("corn", player);
                    }
            }
        }
    }

    public void feedAnimal() {   //Not ready yet!
        while (true) {
            System.out.println("Choose what animal you want to feed.");
        }

    }

    public void showPlayerInventory(Player player) {
        System.out.print("Player: " + player.getName());
        System.out.println("     |     Money: " + player.getMoney());
        System.out.println();
        System.out.println("Food owned: ");
        player.howMuchBeef();
        player.howMuchCorn();
        player.animalsOwned();

    }

    public void updateWallet(String animalOrFood, Player player) {
        player.setmoney(player.getMoney() - store.getCostOfAnimalOrFood(animalOrFood));
    }

    public boolean checkIfPlayerHasEnoughMoney(String animalOrFood, int buyamount, Player player) {
        if (player.getMoney() < buyamount * store.getCostOfAnimalOrFood(animalOrFood)) {
            return true;
        }
        return false;

    }

}
