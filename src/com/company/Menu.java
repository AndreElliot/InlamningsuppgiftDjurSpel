package com.company;

public class Menu {

    public void mainMenu(){
        System.out.println();
        System.out.println("1. Buy Animals");
        System.out.println("2. Buy food");
        System.out.println("3. Feed your animals");
        System.out.println("4. Mate your animals");
        System.out.println("5. Sell your animals");
    }
    public void animalMenu(){
        System.out.println("----------- Animals for sale -----------");
        System.out.println("         Lion    |   $750 (each)");
        System.out.println("         Tiger   |   $500 (each)");
        System.out.println("         Horse   |   $350 (each)");
        System.out.println("         Cow     |   $300 (each)");
        System.out.println("         Chicken |   $50 (each)");
    }
    public void foodMenu(){
        System.out.println("------------ Food for sale ------------");
        System.out.println("         Beef   |   $50 (price per kg)");
        System.out.println("         Hay    |   $50 (price per kg)");
        System.out.println("         Corn   |   $50 (price per kg)");
    }
}
