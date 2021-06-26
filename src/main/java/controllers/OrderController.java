package controllers;

import api.services.OrderService;
import exceptions.EntityCannotBeAddedException;
import model.entities.Order;
import services.OrderServiceImpl;

import java.util.List;

public class OrderController {
    private static OrderController instance;
    private final OrderService orderService;

    private OrderController(){
        orderService = OrderServiceImpl.getInstance();
    }

    public static OrderController getInstance() {
        if(instance == null){
            instance = new OrderController();
        }

        return instance;
    }

    public void create(Order order) throws EntityCannotBeAddedException {
        orderService.create(order);
    }

    public List<Order> getAll(){
        return orderService.getAll();
    }
}
