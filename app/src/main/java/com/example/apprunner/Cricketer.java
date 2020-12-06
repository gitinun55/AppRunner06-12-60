package com.example.apprunner;

import java.io.Serializable;

public class Cricketer implements Serializable {

    private int Add_id;
    private int Price;
    private String NameDistance;
    private int Distance;
    private String name_event;
    private int distance;


    public Cricketer(int add_id, String namedistance, int distance, int price) {
        Add_id = add_id;
        NameDistance = namedistance;
        Price = price;
        Distance = distance;
    }
    public int getId_add(){
        return Add_id;
    }

    public String getNameDistance(){
        return NameDistance;
    }

    public void setNameDistance(String namedistance){
        NameDistance = namedistance;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getdistance() {
        return distance;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {
        Distance = distance;
    }
}
