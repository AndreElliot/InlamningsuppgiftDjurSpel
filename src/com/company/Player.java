package com.company;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println(money); //Will be deleted later.
    }
    public int getMoney(){
        return money;
    }
    public void buyTiger(){

    }
    public void addAnimal(Animal animal){
        animalList.add(animal);
    }
}


