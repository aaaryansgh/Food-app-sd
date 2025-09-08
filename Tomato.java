package Tomato;


import java.util.List;

import Tomato.Services.Notification;
import Tomato.factories.*;
import Tomato.managers.Ordermanager;
import Tomato.managers.Resturantmanager;
import Tomato.models.*;
import Tomato.strategies.*;

public class Tomato {
    public Tomato(){
        initializeResturants();
    }
    public void initializeResturants(){
        Resturant resturant1=new Resturant("Z&S roll","Lonavla");
        Resturant resturant2=new Resturant("Hotel Indian curry","Koderma");
        Resturant resturant3=new Resturant("Anglo Indian cafe","Lonavla");

        resturant1.addmenuItem(new MenuItem("L1","Chicken kathi roll",120));
        resturant1.addmenuItem(new MenuItem("L2","Chicken Dum Biryani",150));
        resturant2.addmenuItem(new MenuItem("K1","Chicken kali mirch", 250));
        resturant2.addmenuItem(new MenuItem("K2","Masala Dosa", 110));
        resturant2.addmenuItem(new MenuItem("K3","Rasmalai",30));
        resturant3.addmenuItem(new MenuItem("A1","Italian pasta", 350));
        resturant3.addmenuItem(new MenuItem("A2","Cold coffee", 150));
        resturant3.addmenuItem(new MenuItem("A3","croissant", 200));

        Resturantmanager resturantmanager=Resturantmanager.getInstance();
        resturantmanager.addResturant(resturant1);
        resturantmanager.addResturant(resturant2);
        resturantmanager.addResturant(resturant3);
    }
    public List<Resturant> searchResturants(String location){
        return Resturantmanager.getInstance().searchByLocation(location);
    }
    public void selectResturant(User user,Resturant resturant){
        Cart cart=user.getCart();
        cart.setResturant(resturant);
    }
    public void addToCart(User user, String itemCode){
        Resturant restaurant = user.getCart().getResturant();
        if (restaurant == null) {
            System.out.println("Please select a restaurant first.");
            return;
        }
        for (MenuItem item : restaurant.getMenu()) {
            if (item.getCode().equals(itemCode)) {
                user.getCart().additem(item);
                break;
            }
        }
    }
    public Order checkoutNow(User user, String orderType, Paymentstrategy paymentStrategy) {
        return checkout(user, orderType, paymentStrategy, new Noworderfactory());
    }

    public Order checkout(User user, String orderType, Paymentstrategy paymentStrategy, Orderfactory orderFactory) {

        Cart userCart = user.getCart();
        Resturant orderedRestaurant = userCart.getResturant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double totalCost = userCart.getTotalCost();

        Order order = orderFactory.createOrder(user, userCart, orderedRestaurant, itemsOrdered, paymentStrategy, totalCost, orderType);
        Ordermanager.getInstance().addOrder(order);
        return order;
    }

    public void payForOrder(User user, Order order) {
        boolean isPaymentSuccess = order.processPayment();

        if (isPaymentSuccess) {
            Notification.notify(order);
            user.getCart().clearCart();
        }
    }

    public void printUserCart(User user) {
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : Rs." +item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : Rs." +user.getCart().getTotalCost());
    }

}
