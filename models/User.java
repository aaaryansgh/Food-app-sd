package Tomato.models;

public class User {
    private int userID;
    private String name;
    private String address;
    private Cart cart;
    public User(int userID,String name,String address){
        this.userID=userID;
        this.name=name;
        this.address=address;
        this.cart=new Cart();
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public Cart getCart(){
        return cart;
    }
    public void setName(String n){
        name=n;
    }
    public void setAddress(String add){
        address=add;
    }
}
