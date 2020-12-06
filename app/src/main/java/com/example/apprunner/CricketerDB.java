package com.example.apprunner;

public class CricketerDB {
    private int id_add;
    private String name_event;
    private String name_distance;
    private int price;
    private int distance;

    public CricketerDB(int id_add,String name_event,String name_distance,int distance ,int price){
        this.id_add = id_add;
        this.name_event = name_event;
        this.name_distance = name_distance;
        this.distance = distance;
        this.price = price;
    }
}
