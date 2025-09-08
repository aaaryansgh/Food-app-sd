package Tomato.models;

public class Deliveryorder extends Order {
    private String userAddress;
    public Deliveryorder(){
        userAddress="";
    }
    @Override
    public String getType(){
        return "Delivery";
    }
    public void setUserAddress(String add){
        userAddress=add;
    }
    public String getUserAddress(){
        return userAddress;
    }
    
}
