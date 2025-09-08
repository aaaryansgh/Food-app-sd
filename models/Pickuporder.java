package Tomato.models;

public class Pickuporder extends Order {
    private String restAddress;
    public Pickuporder(){
        restAddress="";
    }
    @Override
    public String getType(){
        return "Pickup";
    }
    public void setRestAddress(String add){
        restAddress=add;
    }
    public String getRestAddress(){
        return restAddress;
    }
}
