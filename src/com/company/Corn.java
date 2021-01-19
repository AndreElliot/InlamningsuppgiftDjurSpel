package com.company;

public class Corn extends Food {

    private String name = "corn";

    public Corn() {
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