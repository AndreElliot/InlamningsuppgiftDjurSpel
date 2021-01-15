package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {


    private String name;
    private int money;
    Store store = new Store();

    public Player(String name,int money){
        this.name = name;
        this.money = money;
    }

    public void setmoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return money;
    }
    public void buyTiger(){

    }

}


