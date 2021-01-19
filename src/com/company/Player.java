package com.company;

import java.util.ArrayList;

public class Player {

    private ArrayList<Animal> animalList = new ArrayList<>();
    private ArrayList<Food> foodList = new ArrayList<>();

    private String name;
    private int money;
    Store store = new Store();

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void setmoney(int money) {
        this.money = money;
        System.out.println("Money left: " + money); //Will be deleted later.
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;

    }

    public void removeFood(String foodType) {  //not tested yet

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
    public FoodType getFoodType(String foodName){
        FoodType foodtype = null;
        for(Food allfood : foodList){
            System.out.println(allfood.getFoodName());
            if(allfood.getFoodName().equalsIgnoreCase(foodName)){
                foodtype = allfood.getFoodType();
            }
        }
        return foodtype;
    }

}



