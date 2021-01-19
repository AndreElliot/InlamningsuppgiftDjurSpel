package com.company;



public class Tiger extends Animal {

    public Tiger(String name, int health, String gender) {
        super(name, health, gender, FoodType.MEAT);

    }
    @Override
    public void printOutValues(){
        System.out.println("Tiger | Name: " + name + " | Gender:" + gender.toString().toLowerCase() + " | Health:" + health  + " | Last rounds health: " + healthLastRound + "(" + (health-healthLastRound) + ")");
    }
}
