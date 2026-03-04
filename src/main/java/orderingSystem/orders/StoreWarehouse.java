package main.java.orderingSystem.orders;

import java.util.ArrayDeque;
import java.util.Queue;

public class StoreWarehouse {
    private Queue<Order> orders;
    private static StoreWarehouse instance;

    private StoreWarehouse() {
        this.orders = new ArrayDeque<>();
    }

    public static StoreWarehouse getInstance() {
        if (instance == null) {
            instance = new StoreWarehouse();
        }
        return instance;
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public void deliverNextOrder() {
        Order nextOrder = orders.poll();
        if (nextOrder == null) {
            System.out.println("No more orders to deliver!");
            return;
        }

        nextOrder.markedDelivered();
    }
}
