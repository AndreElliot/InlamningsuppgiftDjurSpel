package com.company;

import java.util.Random;
import java.util.Scanner;


enum Gender {
    MALE,
    FEMALE
}

abstract class Animal {

    protected String name;
    protected int health;
    protected int healthLastRound;
    protected Gender gender;
    protected FoodType foodType;
    Random rand = new Random();
    Store store = new Store();
    Scanner scan = new Scanner(System.in);

    public Animal(String name, int health, String gender, FoodType foodType) {
        this.name = name;
        this.health = health;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.foodType = foodType;

    }

    public void animalDiesOfLowHealth(Player player){ //test
        for(int i = player.getAnimalList().size() - 1; i >= 0; i--){
            if(player.getAnimalList().get(i).health < 1){
                System.out.println("Bad news.." + player.getAnimalList().get(i).name + " died from hunger.. RIP ");
               player.getAnimalList().remove(i);
            }
        }
    }

    public void createNewBornAnimals(String animalspecie, Player player) {
        int numberOfBabies = (1 + rand.nextInt(5));
        System.out.println("Success!! " + numberOfBabies + " new born babies!!");
        for (int i = 0; i < numberOfBabies; i++) {
            System.out.println(i);
            System.out.println("numberofbabies: " + numberOfBabies);
            String gender = "female";
            int randgender = rand.nextInt(2);
            if (randgender == 1) {
                gender = "male";
            }
            System.out.println("Its a " + gender + "!! What would you like to name it?");
            String name = scan.nextLine();
            switch (animalspecie) {
                case "tiger":
                    Tiger tiger = new Tiger(name, 100, gender);
                    player.addAnimal(tiger);
                    break;
                case "chicken":
                    Chicken chicken = new Chicken(name, 100, gender);
                    player.addAnimal(chicken);
                    break;
            }
        }
    }


    public void decreaseHealth() {
        int n = 10 + rand.nextInt(21);
        healthLastRound = health;
        this.health -= n;
    }

    public void increaseHealthBy10() {
        this.health += 10;
        if(this.health > 100){
            this.health = 100;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public int getHealthLastRound() {
        return healthLastRound;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int animalWorthWhenSold(String animalName) {
        return (store.getCostOfAnimalOrFood(animalName) * health / 100);
    }

    public abstract String getTheAnimalType();

    public abstract void printOutValues();

    public abstract FoodType getAnimalFoodType();


}
