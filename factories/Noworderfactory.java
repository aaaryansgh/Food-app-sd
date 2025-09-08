package Tomato.factories;
import java.time.*;
import java.util.*;
import Tomato.models.*;
import Tomato.strategies.*;
public class Noworderfactory implements Orderfactory{
    @Override
    public Order createOrder(User user, Cart cart, Resturant resturant, List<MenuItem>menuItems, Paymentstrategy payment, double totalCost, String orderType){
        Order order=null;
        if(orderType.equals("Delivery")){
            Deliveryorder deliveryorder=new Deliveryorder();
            deliveryorder.setUserAddress(user.getAddress());
            order=deliveryorder;
        }
        else{
            Pickuporder pickuporder=new Pickuporder();
            pickuporder.setRestAddress(resturant.getLocation());
            order=pickuporder;
        }
        order.setUser(user);
        order.setResturant(resturant);
        order.setItems(menuItems);
        order.setPayment(payment);
        order.setScheduled(LocalDateTime.now());
        order.setTotalCost(totalCost);
        return order;
    }
}
