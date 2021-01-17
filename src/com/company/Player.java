package com.company;
import java.util.ArrayList;

public class Player {

    private ArrayList<Animal> animalList = new ArrayList<>();
    private ArrayList<Food> foodList = new ArrayList<>();

    private String name;
    private int money;
    Store store = new Store();

    public Player(String name,int money){
        this.name = name;
        this.money = money;
    }

    public void setmoney(int money){
        this.money = money;
        System.out.println("Money left: " + money); //Will be deleted later.
    }
    public int getMoney(){
        return money;
    }
    public String getName(){
        return name;
    }
    public void buyTiger(){

    }
    public void addAnimal(Animal animal){
        animalList.add(animal);
    }
    public void addFood(Food food){
        foodList.add(food);
    }
    public void animalsOwned(){
        System.out.println("Animals owned: ");
        for( Animal animals : animalList) {
            System.out.println(animals.name);
        }
    }
    public void foodOwned(){
        System.out.println("Food owned: ");
        for(Food foods : foodList){
            System.out.println(foods);
        }

    }
    }



