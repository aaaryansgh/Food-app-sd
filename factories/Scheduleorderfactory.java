package Tomato.factories;

import java.time.LocalDateTime;
import java.util.List;

import Tomato.models.Cart;
import Tomato.models.Deliveryorder;
import Tomato.models.MenuItem;
import Tomato.models.Order;
import Tomato.models.Pickuporder;
import Tomato.models.Resturant;
import Tomato.models.User;
import Tomato.strategies.Paymentstrategy;

public class Scheduleorderfactory implements Orderfactory {
    private LocalDateTime time;
    Scheduleorderfactory(LocalDateTime time){
        this.time=time;
    }
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
        order.setScheduled(time);
        order.setTotalCost(totalCost);
        return order;
    }
}
