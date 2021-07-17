package controllers;

import services.order.OrderService;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import lombok.Setter;
import model.entities.Order;

import java.util.Collection;

public class OrderController {
    private static OrderController instance;
    @Setter
    private OrderService orderService;

    private OrderController(){
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

    public Collection<Order> getAll(){
        return orderService.getAll();
    }

    public void deleteById(long id) throws EntityNotFoundException {
        orderService.deleteById(id);
    }

    public Order getById(long id) throws EntityNotFoundException {
        return orderService.getById(id);
    }
}
