package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    int rounds;
    int players;
    private ArrayList<Player> playerList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);





    public void run(){
        System.out.println("How many people will be playing?(1-4)");
        int players = scan.nextInt();
        for(int i = 1; i <= players; i++){
            String name = ("player" + i);
            Player player = new Player(name, 400);
            playerList.add(player);
        }
        System.out.println("How many rounds would you like to play?(5-30)");
        int rounds = scan.nextInt();
        for(int i = 0; i < rounds; i++){
            for(int j = 1; j <= players; j++){


            }
        }



}



}
