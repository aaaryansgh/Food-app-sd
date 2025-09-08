package Tomato.managers;
import java.util.*;
import Tomato.models.*;
public class Ordermanager {
    private List<Order>orders=new ArrayList<>();
    private static Ordermanager instance=null;
    private Ordermanager(){

    }
    public static Ordermanager getInstance(){
        if(instance==null){
            instance=new Ordermanager();
        }
        return instance;
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void listOrders(){
        System.out.println("\n--- All orders ---");
        for(Order order:orders){
            System.out.println(order.getType()+" - "+order.getUser().getName()
            +" | Total: Rs."+order.getTotalCost()+" | At:"+ order.getScheduled());
        }
    }

}
