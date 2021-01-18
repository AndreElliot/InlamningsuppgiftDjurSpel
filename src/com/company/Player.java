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

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void animalsOwned() {
        System.out.println("Animals owned: ");
        for (Animal animals : animalList) {
            animals.printOutValues();
        }
    }

    public void decraseAllAnimalsHealth() {
        for (Animal animal : animalList) {
            animal.decreaseHealth();
        }
    }
    public void howMuchBeef(){
        int beefCount = 0;
        for(Food food : foodList){
            if(food instanceof Beef){
                beefCount++;
            }
        }
        System.out.print("Beef: " + beefCount + "kg | ");
    }
    public void howMuchCorn(){
        int CornCount = 0;
        for(Food food : foodList){
            if(food instanceof Corn){
                CornCount++;
            }
        }
        System.out.println("Corn: " + CornCount + "kg");
    }
}



