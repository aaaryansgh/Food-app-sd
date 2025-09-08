package Tomato.models;
import java.util.*  ;
import java.time.*;
import Tomato.strategies.*;
public abstract class Order {
    private static int nextorderId=0;
    protected int orderId;
    protected User user;
    protected Cart cart;
    protected Resturant resturant;
    protected List<MenuItem> menuItems;
    protected Paymentstrategy payment;
    protected double totalCost;
    protected LocalDateTime scheduled;

    public Order(){
        this.user=null;
        this.resturant=null;
        this.payment=null;
        this.totalCost=0.0;
        this.orderId=++nextorderId;
    }
    public boolean processPayment(){
        if(payment!=null){
            payment.pay(totalCost);
            return true;
        }else{
            return false;
        }
    }
    public abstract String getType();

    public int getOrderId(){
        return orderId;
    }
    public User getUser(){
        return user;
    }
    public Resturant getResturant(){
        return resturant;
    }
    public List<MenuItem> getItems(){
        return menuItems;
    }
    public double getTotalCost(){
        return totalCost;
    }
    public LocalDateTime getScheduled(){
        return scheduled;
    }
    public void setTotalCost(double cost){
        totalCost=cost;
    }
    public void setUser(User u){
        user=u;
    }
    public void setResturant(Resturant r){
        resturant=r;
    }
    public void setItems(List<MenuItem> items){
        menuItems=items;
        totalCost=0;
        for(MenuItem i:items){
            totalCost+=i.getPrice();
        }
    }
    public void setScheduled(LocalDateTime s){
        scheduled=s;
    }
    public void setPayment(Paymentstrategy p){
        payment=p;
    }

}
