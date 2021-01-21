package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Player {

    private ArrayList<Animal> animalList = new ArrayList<>();
    private ArrayList<Food> foodList = new ArrayList<>();

    private String name;
    private int money;
    Store store = new Store();
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setmoney(int money) {
        this.money = money;
        System.out.println("Current money: $" + money); //Will be deleted later.
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;

    }

    public void removeAnimal(Animal animal) {
        animalList.remove(animal);
    }

    public void removeFood(String foodType) {

        Food foodToRemove = null;
        for (Food food : foodList) {
            if (food.getFoodName().equalsIgnoreCase(foodType)) {
                foodToRemove = food;
                break;
            } else if (food.getFoodName().equalsIgnoreCase(foodType)) {
                foodToRemove = food;
                break;
            }


        }
        foodList.remove(foodToRemove);
    }


    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void animalsOwned() {
        System.out.println("            Animals owned: ");
        for (Animal animals : animalList) {
            animals.printOutValues();
        }
    }

    public void decraseAllAnimalsHealth() {
        for (Animal animal : animalList) {
            animal.decreaseHealth();
        }
    }


    public int howMuchFood(String foodToCheck) {
        int CornCount = 0;
        for (Food food : foodList) {
            if (food.getFoodName().equalsIgnoreCase(foodToCheck)) {
                CornCount++;
            }
        }
        return CornCount;

    }

    public Animal getAnimal(String animalName) {
        Animal animal = null;
        for (Animal everyAnimal : animalList) {
            if (everyAnimal.getName().equalsIgnoreCase(animalName)) {
                animal = everyAnimal;

            }
        }
        return animal;
    }

    public FoodType getFoodType(String foodName) {
        FoodType foodtype = null;
        for (Food allfood : foodList) {
            if (allfood.getFoodName().equalsIgnoreCase(foodName)) {
                foodtype = allfood.getFoodType();
            }
        }
        return foodtype;
    }

    public void updateWalletAfterBuying(String animalOrFood, Player player) {
        player.setmoney(player.getMoney() - store.getCostOfAnimalOrFood(animalOrFood));
    }

    public boolean checkIfPlayerHasEnoughMoney(String animalOrFood, int buyamount, Player player) {
        if (player.getMoney() < buyamount * store.getCostOfAnimalOrFood(animalOrFood)) {
            return true;
        }
        return false;

    }

    public void feedAnimal(Player player) {
        while (true) {
            System.out.println("Choose what animal you want to feed by typing in the name of it. or type in \"-\" to finish your turn");
            String animalName = scan.nextLine();
            Animal animaltemp = player.getAnimal(animalName);
            if (animalName.equals("-")) {
                break;
            }
            System.out.println("What type of food would you like to give the animal?");
            String foodName = scan.nextLine();
            if ((animaltemp.getAnimalFoodType()) == (player.getFoodType(foodName))) {
                System.out.println("How many KG " + foodName + " would you like to give the animal (+10hp per kg)?");
                int amountFoodToGive = scan.nextInt();
                scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.
                if (amountFoodToGive <= player.howMuchFood(foodName)) {
                    for (int i = 0; i < amountFoodToGive; i++) {
                        animaltemp.increaseHealthBy10();
                        removeFood(foodName);
                        System.out.println(animalName + " is eating his " + foodName + "... nam nam.. Health: " + animaltemp.health + "(+10)");

                    }

                } else {
                    System.out.println("You do not have enough " + foodName + " to feed your animal this much food.\n");
                }

            }
        }

    }

    public void breedAnimals(Player player) {

        System.out.println("Type in the name of the first animal you want to try breed. or type in \"-\" to finish your turn.");
        String animalName1 = scan.nextLine();
        if (animalName1.equals("-")) {
        } else {
            System.out.println("Type in the name of the second animal you want to try breed.");
            String animalName2 = scan.nextLine();
            Animal animalTemp1 = player.getAnimal(animalName1);
            Animal animalTemp2 = player.getAnimal(animalName2);
            String animalSpecie = animalTemp2.getTheAnimalType();
            if (animalTemp1.getTheAnimalType().equalsIgnoreCase(animalTemp2.getTheAnimalType())) {
                if (animalTemp1.getGender() != animalTemp2.getGender()) {
                    System.out.println("Attempting to make baby....");
                    int randnumb = rand.nextInt(100);
                    if (randnumb > 50) {

                        animalTemp1.createNewBornAnimals(animalSpecie, player);
                    } else {
                        System.out.println("Sorry, the animals did not manage to make babies..");
                    }

                } else {
                    System.out.println("Sorry, you can not breed 2 animals of the same sex.");
                }

            } else {
                System.out.println("Sorry, you can not breed 2 different species.");
            }

        }


    }

}




