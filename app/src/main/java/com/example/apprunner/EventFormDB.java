package com.example.apprunner;

public class EventFormDB {

    private int id_user;
    private String pic_event;
    private String name_organizer;
    private String name_event;
    private String name_producer;
    private String date_reg_start;
    private String date_reg_end;
    private String objective;
    private String detail;

    public EventFormDB(int id_user,String pic_event,String name_organizer, String name_event, String name_producer, String date_reg_start, String date_reg_end, String objective, String detail){
        this.id_user = id_user;
        this.pic_event = pic_event;
        this.name_organizer = name_organizer;
        this.name_event = name_event;
        this.name_producer = name_producer;
        this.date_reg_start = date_reg_start;
        this.date_reg_end = date_reg_end;
        this.objective = objective;
        this.detail = detail;
    }




}
