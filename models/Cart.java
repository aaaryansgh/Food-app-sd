package Tomato.models;
import java.util.*;
public class Cart {
    private Resturant resturant;
    private List<MenuItem> cartItems=new ArrayList<>();
    public Cart(){
        resturant =null;
    }
    public void additem(MenuItem item){
        cartItems.add(item);
    }
    public void setResturant(Resturant r){
        resturant=r;
    }
    public Resturant getResturant(){
        return resturant;
    }
    public List<MenuItem> getItems(){
        return cartItems;
    }
    public double getTotalCost(){
        double sum=0;
        for(MenuItem item:cartItems){
            sum=sum+item.getPrice();
        }
        return sum;
    }
    public void clearCart(){
        cartItems.clear();
        resturant=null;
    }


}
