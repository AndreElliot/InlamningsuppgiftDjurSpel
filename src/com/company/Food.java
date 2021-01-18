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



}
