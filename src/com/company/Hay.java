package com.company;

public class Hay extends Food {

    private String name = "hay";

    public Hay() {
        super(FoodType.VEGETERIAN);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.VEGETERIAN;
    }

    @Override
    public String getFoodName() {
        return name;
    }
}

