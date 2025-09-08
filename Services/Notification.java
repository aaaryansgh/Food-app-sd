package Tomato.Services;
import java.util.*;
import Tomato.models.*;
public class Notification {
    public static void notify(Order order){
        System.out.println("\nNotification: New "+order.getType()+ "order placed!");
        System.out.println("----------------------------------------------");
        System.out.println("OrderID: "+order.getOrderId());
        System.out.println("Customer: "+ order.getUser().getName());
        System.out.println("Resturant: "+ order.getResturant().getName());
        System.out.println("Items Ordered");
        List<MenuItem>items=order.getItems();
        for(MenuItem i:items){
            System.out.println("-"+ i.getName()+" : Rs. "+i.getPrice());
        }
        System.out.println("Total Price: Rs. "+order.getTotalCost());
        System.out.println("Scheduled Time: "+order.getScheduled());
        System.out.println("Payment: Done");
        System.out.println("---------------------------------------------------------");
    }
}
