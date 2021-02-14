package com.company;

import java.util.Scanner;


public class Store {
    enum animalAndFoodShop {
        LION(750),
        TIGER(500),
        HORSE(350),
        COW(300),
        CHICKEN(50),

        BEEF(50),
        HAY(50),
        CORN(50);


        int p;

        animalAndFoodShop(int price) {
            p = price;
        }

    }

    Scanner scan = new Scanner(System.in);
    GameTools gameTools = new GameTools();

    public int getCostOfAnimalOrFood(String animal) {
        return animalAndFoodShop.valueOf(animal.toUpperCase()).p;
    }

    public void whatAnimalToBuy(Player player) {

        while (true) {
            System.out.println("Type in the animal you want to buy or type in \"-\" to finish your turn");
            String buyAnimalMenu = gameTools.userAnimalToBuy();
            if (buyAnimalMenu.equals("-")) {
                break;
            }

            System.out.println("How many animals would you like to buy?");
            int buyAnimalAmount = gameTools.userInputToInt();

            if (player.checkIfPlayerHasEnoughMoney(buyAnimalMenu, buyAnimalAmount, player)) {
                System.out.println("You do not have enough money for this. Redo you decisions and make sure you have enough money for it.");
                continue;
            }
            switch (buyAnimalMenu) {
                case "lion":
                    for (int i = 0; i < buyAnimalAmount; i++) {
                        System.out.println("Type in what Gender you want to buy? (Female or Male)");
                        String gender = gameTools.userChooseGender();
                        System.out.println("Give the animal a name:");
                        String name = scan.nextLine();
                        Lion lion = new Lion(name, 100, gender);
                        player.addAnimal(lion);
                        player.updateWalletAfterBuying("lion", player);
                    }
                    break;
                case "tiger":
                    for (int i = 0; i < buyAnimalAmount; i++) {
                        System.out.println("Type in what Gender you want to buy? (Female or Male)");
                        String gender = gameTools.userChooseGender();
                        System.out.println("Give the animal a name:");
                        String name = scan.nextLine();
                        Tiger tiger = new Tiger(name, 100, gender);
                        player.addAnimal(tiger);
                        player.updateWalletAfterBuying("tiger", player);
                    }
                    break;
                case "horse":
                    for (int i = 0; i < buyAnimalAmount; i++) {
                        System.out.println("Type in what Gender you want to buy? (Female or Male)");
                        String gender = gameTools.userChooseGender();
                        System.out.println("Give the animal a name:");
                        String name = scan.nextLine();
                        Horse horse = new Horse(name, 100, gender);
                        player.addAnimal(horse);
                        player.updateWalletAfterBuying("horse", player);
                    }
                    break;
                case "cow":
                    for (int i = 0; i < buyAnimalAmount; i++) {
                        System.out.println("Type in what Gender you want to buy? (Female or Male)");
                        String gender = gameTools.userChooseGender();
                        System.out.println("Give the animal a name:");
                        String name = scan.nextLine();
                        Cow cow = new Cow(name, 100, gender);
                        player.addAnimal(cow);
                        player.updateWalletAfterBuying("cow", player);
                    }
                    break;
                case "chicken":
                    for (int i = 0; i < buyAnimalAmount; i++) {
                        System.out.println("Type in what Gender you want to buy? (Female or Male)");
                        String gender = gameTools.userChooseGender();
                        System.out.println("Give the animal a name:");
                        String name = scan.nextLine();
                        Chicken chicken = new Chicken(name, 100, gender);
                        player.addAnimal(chicken);
                        player.updateWalletAfterBuying("chicken", player);
                    }
                    break;
            }
        }
    }

    public void whatFoodToBuy(Player player) {
        while (true) {
            System.out.println("Type in what food you want to buy or type in \"-\" to finish your turn");
            String buyFoodMenu = gameTools.userChooseFood();
            if (buyFoodMenu.equals("-")) {
                break;
            }
            System.out.println("How many kg food would you like to buy?");
            int buyFoodAmount = gameTools.userInputToInt();

            if (player.checkIfPlayerHasEnoughMoney(buyFoodMenu, buyFoodAmount, player)) {
                System.out.println("You dont have enough money for this. Redo you decisions and make sure you have enough money in the bank for it.");
                continue;
            }
            switch (buyFoodMenu) {
                case "beef":
                    for (int i = 0; i < buyFoodAmount; i++) {
                        Beef beef = new Beef();
                        player.addFood(beef);
                        player.updateWalletAfterBuying("beef", player);
                    }
                    break;
                case "hay":
                    for (int i = 0; i < buyFoodAmount; i++) {
                        Hay hay = new Hay();
                        player.addFood(hay);
                        player.updateWalletAfterBuying("hay", player);
                    }
                    break;
                case "corn":
                    for (int i = 0; i < buyFoodAmount; i++) {
                        Corn corn = new Corn();
                        player.addFood(corn);
                        player.updateWalletAfterBuying("corn", player);
                    }
                    break;
            }
        }
    }

    public void sellAnimals(Player player) {
        while (true) {
            System.out.println("Type in the name of the animal you would like to sell. Or type in \"-\" to finish your turn");
            Animal animalTemp = player.userChooseAnimal();
            if (animalTemp == null) {
                break;
            }
            System.out.println(animalTemp.getName() + " was successfully sold for $" + animalTemp.animalWorthWhenSold(animalTemp.getTheAnimalType()));
            gameTools.newLine();
            player.setmoney(player.getMoney() + animalTemp.animalWorthWhenSold(animalTemp.getTheAnimalType()));
            player.removeAnimal(animalTemp);

        }
    }

    public void sellAllAnimals(Player player) {
        for (int i = player.getAnimalList().size() - 1; i >= 0; i--) {
            Animal animalTemp = player.getAnimalList().get(i);
            player.setmoney(player.getMoney() + animalTemp.animalWorthWhenSold(animalTemp.getTheAnimalType()));
            player.getAnimalList().remove(i);

        }
    }
}

