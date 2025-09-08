package Tomato.models;

import java.util.*;

public class Resturant {
    private static int nextId=0;
    private int resturantId;
    private String name;
    private String location;
    private List<MenuItem>menu=new ArrayList<>();
    
    public Resturant(String name, String location){
        this.name=name;
        this.location=location;
        this.resturantId=++nextId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public void addmenuItem(MenuItem item){
        menu.add(item);
    }
    public List<MenuItem> getMenu(){
        return menu;
    }
}
