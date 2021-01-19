package com.company;

enum FoodType{
    MEAT,
    VEGETERIAN;
}


abstract class Food {
    protected FoodType foodType;

    public Food(FoodType foodtype){
        this.foodType=foodtype;

    }

    public abstract FoodType getFoodType(String foodType); //not tested yet

}
