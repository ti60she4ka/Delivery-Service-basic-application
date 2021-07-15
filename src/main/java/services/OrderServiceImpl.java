package services;

import api.repositories.OrderRepository;
import api.services.OrderService;
import model.entities.Order;

public class OrderServiceImpl extends AbstractServiceImpl<Order> implements OrderService {
    private static OrderServiceImpl instance;
    private OrderRepository orderRepository;

    private OrderServiceImpl(){
    }

    public static OrderServiceImpl getInstance(){
        if(instance == null){
            instance = new OrderServiceImpl();
        }

        return instance;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        abstractRepository = orderRepository;
    }
}
