package com.company;
import java.util.Scanner;
import java.util.ArrayList;




public class Store {
    enum animalShop{
        TIGER(500),
        CHICKEN(100);

        int p;
        animalShop(int price){
            p = price;
        }





}
 public int getCostOfAnimal(String animal){
        return animalShop.valueOf(animal.toUpperCase()).p;
 }

}

