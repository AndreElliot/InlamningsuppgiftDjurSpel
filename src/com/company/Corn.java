package com.company;

public class Corn extends Food {

    public Corn() {
        super(FoodType.VEGETERIAN);
    }

    @Override
    public FoodType getFoodType(String foodType) {
        if (foodType.equalsIgnoreCase("corn")) {
            return FoodType.VEGETERIAN;
        }
        return null;
    }
}