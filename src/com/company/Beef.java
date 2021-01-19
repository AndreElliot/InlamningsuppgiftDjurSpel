package com.company;

public class Beef extends Food{

    public Beef(){

        super(FoodType.MEAT);
    }

    @Override
    public FoodType getFoodType() {

        return FoodType.MEAT;
    }
}
