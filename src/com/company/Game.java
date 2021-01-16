package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    int rounds;
    int players;
    private ArrayList<Player> playerList = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    Store store = new Store();



    public void run(){
        System.out.println("How many people will be playing?(1-4)");
        int players = scan.nextInt();
        for(int i = 1; i <= players; i++){
            String name = ("player" + i);
            Player player = new Player(name, 500);
            playerList.add(player);
        }
        System.out.println("How many rounds would you like to play?(5-30)");
        int rounds = scan.nextInt();
        scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.
        for(int i = 0; i < rounds; i++){
            for(int j = 0; j < players; j++){
                whatAnimalToBuy(playerList.get(j));



            }
        }
}

    public void whatAnimalToBuy(Player player) {


        while(true){
        System.out.println("Choose the animal you want to buy or type in \"-\" to finish your turn");
        String buymenu = scan.nextLine().toLowerCase();
        if(buymenu.equals("-")){
            break;
        }

        System.out.println("How many animals would you like to buy?");
        int buyAmount = scan.nextInt();
        scan.nextLine(); //scan.nextint() reads an extra character into the buffer, in order to whipe the buffer, puts in an extra line that reads it.

        if(!checkIfPlayerHasEnoughMoney(buymenu, buyAmount, player)){
            System.out.println("You dont have enough money for this. Redo you decisions and make sure you have enough money in the bank for it.");
            continue;
        }
        switch (buymenu) {
            case "tiger":
                for (int i = 0; i < buyAmount; i++) {
                    System.out.println("What Gender do you want to buy?");
                    String gender = scan.nextLine();
                    System.out.println("Give the animal a name:");
                    String name = scan.nextLine();
                    Tiger tiger = new Tiger(name, 100, gender);
                    player.addAnimal(tiger);
                    updateWallet("tiger", player);
                }
                break;
            case "chicken":
                for (int i = 0; i < buyAmount; i++) {
                    System.out.println("What Gender do you want to buy?");
                    String gender = scan.nextLine();
                    System.out.println("Give the animal a name:");
                    String name = scan.nextLine();
                    Chicken chicken = new Chicken(name, 100, gender);
                    player.addAnimal(chicken);
                    updateWallet("chicken", player);
                }
                break;
        }
        }


    }
    public void updateWallet(String animal, Player player){
        player.setmoney(player.getMoney() - store.getCostOfAnimal(animal));
}
    public boolean checkIfPlayerHasEnoughMoney(String animal, int buyamount, Player player){
        if(player.getMoney() >= buyamount* store.getCostOfAnimal(animal)){
            return true;
        }
        return false;
    }

        }
