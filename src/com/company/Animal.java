package com.company;

enum Gender{
    MALE,
    FEMALE
}

abstract class Animal {

    protected String name;
    protected int health;
    protected Gender gender;

    public Animal(String name, int health, String gender){
        this.name = name;
        this.health = health;
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

}
