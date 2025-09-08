package Tomato.factories;
import java.util.*;
import Tomato.models.*;
import Tomato.strategies.*;
public interface Orderfactory {
    Order createOrder(User user, Cart cart, Resturant resturant, List<MenuItem>menuItems, Paymentstrategy payment, double totalCost, String orderType);
}
