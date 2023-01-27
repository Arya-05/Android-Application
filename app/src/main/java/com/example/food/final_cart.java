package com.example.food;

import java.util.ArrayList;

public class final_cart {
    static ArrayList<String> cart_array = new ArrayList<String>();
    static ArrayList<Integer> cost_array = new ArrayList<Integer>();

    public static void addToCart(String name, int cost){
        cart_array.add(name);
        cost_array.add(cost);
    }

    public static  void addCostOfCustomize(String name, int cost){
        cart_array.add(name);
        cost_array.add(cost);
    }
    public ArrayList<String> get_cart_array(){
        return cart_array;
    }

    public ArrayList<Integer> get_cost_array() {
        return cost_array;
    }
}
