package com.company;

public class Beef extends Food{

    private String name = "beef";

    public Beef(){

        super(FoodType.MEAT);
    }

    @Override
    public FoodType getFoodType() {

        return FoodType.MEAT;
    }

    @Override
    public String getFoodName() {
        return name;
    }
}
