package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    int rounds;
    int players;
    private ArrayList<Player> playerList = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    Store store = new Store();



    public void run(){
        System.out.println("How many people will be playing?(1-4)");
        int players = scan.nextInt();
        for(int i = 1; i <= players; i++){
            String name = ("player" + i);
            Player player = new Player(name, 500);
            playerList.add(player);
        }
        System.out.println("How many rounds would you like to play?(5-30)");
        int rounds = scan.nextInt();
        scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.
        for(int i = 0; i < rounds; i++){
            for(int j = 0; j < players; j++){
                showPlayerInventory(playerList.get(j));
                whatFoodToBuy(playerList.get(j));



            }
        }
}

    public void whatAnimalToBuy(Player player) {

        while(true){
        System.out.println("Choose the animal you want to buy or type in \"-\" to finish your turn");
        String buyAnimalMenu = scan.nextLine().toLowerCase();
        if(buyAnimalMenu.equals("-")){
            break;
        }

        System.out.println("How many animals would you like to buy?");
        int buyAnimalAmount = scan.nextInt();
        scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.

        if(checkIfPlayerHasEnoughMoney(buyAnimalMenu, buyAnimalAmount, player)){
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

            if(checkIfPlayerHasEnoughMoney(buyFoodMenu, buyFoodAmount, player)) {
                System.out.println("You dont have enough money for this. Redo you decisions and make sure you have enough money in the bank for it.");
                continue;
            }
            switch(buyFoodMenu){
                case "meat":
                    for (int i = 0; i < buyFoodAmount; i++) {
                        Meat meat = new Meat();
                        player.addFood(meat);
                        updateWallet("meat", player);
                    }
                    break;
                case "grain":
                    for (int i = 0; i < buyFoodAmount; i++) {
                        Grain grain = new Grain();
                        player.addFood(grain);
                        updateWallet("grain", player);
                    }
            }
        }
    }

    public void feedAnimal(){   //Not ready yet!
        while(true) {
            System.out.println("Choose what animal you want to feed.");
        }

    }
    public void showPlayerInventory(Player player){
        System.out.println("Player: " + player.getName());
        System.out.println("Money: " + player.getMoney());
        player.animalsOwned();
        player.foodOwned();

    }
    public void updateWallet(String animalOrFood, Player player){
        player.setmoney(player.getMoney() - store.getCostOfAnimalOrFood(animalOrFood));
}
    public boolean checkIfPlayerHasEnoughMoney(String animalOrFood, int buyamount, Player player){
        if(player.getMoney() <= buyamount* store.getCostOfAnimalOrFood(animalOrFood)){
            return true;
        }
        return false;
    }

        }
