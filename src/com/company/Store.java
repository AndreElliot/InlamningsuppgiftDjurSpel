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

        private ArrayList<Animal> animalList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);



public void whatAnimalToBuy() {


    System.out.println("What animal do you want to buy?");
    int buymenu = scan.nextInt();
    System.out.println("How many animals would you like to buy?");
    int buyAmount = scan.nextInt();
    switch (buymenu) {
        case 1:
            for (int i = 0; i < buyAmount; i++) {
                System.out.println("What Gender do you want to buy?");
                String gender = scan.nextLine();
                System.out.println("Give the animal a name:");
                String name = scan.nextLine();
                Tiger tiger = new Tiger(name, 100, gender);
                animalList.add(tiger);
            }
    }


    }
        public void updateMoney(){


}

}
}
