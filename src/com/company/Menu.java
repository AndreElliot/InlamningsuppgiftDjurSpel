package com.company;

public class Menu {

    public void mainMenu(){
        System.out.println("1. Buy Animals");
        System.out.println("2. Buy food");
        System.out.println("3. Feed your animals");
        System.out.println("4. Mate your animals");
        System.out.println("5. Sell your animals");
    }
    public void animalMenu(){
        System.out.println("----------- Animals for sale -----------");
        System.out.println("         Tiger   |   $500 (each)");
        System.out.println("         Chicken |   $100 (each)");
    }
    public void foodMenu(){
        System.out.println("------------ Food for sale ------------");
        System.out.println("         Meat    |   $50 (price per kg)");
        System.out.println("         Grain   |   $50 (price per kg)");
    }
}
