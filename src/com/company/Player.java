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
    Game game = new Game();
    GameTools gameTools = new GameTools();

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setmoney(int money) {
        this.money = money;
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

    public ArrayList<Animal> getAnimalList() {
        return animalList;
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

    public void decraseHealthAndAddAgeAllAnimals() {
        for (Animal animal : animalList) {
            animal.decreaseHealth();
            animal.increaseAgeBy1();
        }
    }


    public int howMuchFood(String foodToCheck) {
        int foodCount = 0;
        for (Food food : foodList) {
            if (food.getFoodName().equalsIgnoreCase(foodToCheck)) {
                foodCount++;
            }
        }
        return foodCount;

    }


    public Animal userChooseAnimal() {
        Scanner scan = new Scanner(System.in);
        String animalName = "";
        Animal animal = null;
        while (animal == null && (!animalName.equals("-"))) {
            animalName = scan.nextLine();
            for (Animal everyAnimal : getAnimalList()) {
                if (everyAnimal.getName().equalsIgnoreCase(animalName)) {
                    animal = everyAnimal;


                }
            }
            if (animal == null && !animalName.equals("-")) {
                System.out.println("You dont have a animal named: " + animalName + ". Try typing in the name of the animal again.");
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

            Animal animalTemp = player.userChooseAnimal();
            if (animalTemp == null) {
                break;
            }
            System.out.println("Type in the food you want to give the animal. or type in \"-\" to finish your turn.");
            String foodName = gameTools.userChooseFood();
            if (foodName.equals("-")) {
                break;
            }
            if ((animalTemp.getAnimalFoodType()) == (getFoodType(foodName))) {
                System.out.println("How many KG " + foodName + " would you like to give the animal (+10hp per kg)?");
                int amountFoodToGive = gameTools.userInputToInt();
                if (amountFoodToGive <= player.howMuchFood(foodName)) {
                    for (int i = 0; i < amountFoodToGive; i++) {
                        animalTemp.increaseHealthBy10();
                        removeFood(foodName);
                        System.out.println(animalTemp.getName() + " is eating the " + foodName + "... nam nam.. Health: " + animalTemp.health + "(+10)");

                    }

                } else {
                    System.out.println("You do not have enough " + foodName + " to feed your animal this much food.\n");
                    gameTools.newLine();
                }

            } else {
                if (getFoodType(foodName) == null) {
                    System.out.println("You do not have any of this food avaible.");
                    gameTools.newLine();
                } else {
                    System.out.println("The animal does not like this foodtype.. Try feeding it something more appropriate");
                    gameTools.newLine();
                }
            }

        }
    }

    public void killPlayersAnimal(Player player) {
        for (int i = player.getAnimalList().size() - 1; i >= 0; i--) {
            if (player.getAnimalList().get(i).age > 20) {
                System.out.println("Bad news.." + player.getAnimalList().get(i).name + " died from old age.. RIP ");
                player.getAnimalList().remove(i);
            } else if (player.getAnimalList().get(i).health < 1) {
                System.out.println("Bad news.." + player.getAnimalList().get(i).name + " died from hunger.. RIP ");
                player.getAnimalList().remove(i);
            }
        }
    }

    public void breedAnimals(Player player) {

        while (true) {
            System.out.println("Type in the name of the first animal you want to try breed. or type in \"-\" to finish your turn.");
            Animal animalTemp1 = player.userChooseAnimal();
            if (animalTemp1 == null) {
                break;
            }
            System.out.println("Type in the name of the second animal you want to try breed. or type in \"-\" to finish your turn.");
            Animal animalTemp2 = player.userChooseAnimal();
            if (animalTemp2 == null) {
                break;
            }
            String animalSpecie = animalTemp2.getTheAnimalType();
            if (animalTemp1.getTheAnimalType().equalsIgnoreCase(animalTemp2.getTheAnimalType())) {
                if (animalTemp1.getGender() != animalTemp2.getGender()) {
                    System.out.println("Attempting to make baby....");
                    int randnumb = rand.nextInt(2);
                    if (randnumb == 1) {

                        animalTemp1.createNewBornAnimals(animalSpecie, player);
                        gameTools.pressToContinueLoop();
                        break;
                    } else {
                        System.out.println("Sorry, the animals did not manage to make babies..");
                        gameTools.pressToContinueLoop();
                        break;
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




