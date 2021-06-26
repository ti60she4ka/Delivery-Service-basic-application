package services;

import api.repositories.OrderRepository;
import api.services.OrderService;
import model.entities.Order;
import repositories.OrderRepositoryImpl;

public class OrderServiceImpl extends AbstractServiceImpl<Order> implements OrderService {
    private static OrderServiceImpl instance;
    private final OrderRepository orderRepository;

    private OrderServiceImpl(){
        super(OrderRepositoryImpl.getInstance());
        orderRepository = (OrderRepository) abstractRepository;
    }

    public static OrderServiceImpl getInstance(){
        if(instance == null){
            instance = new OrderServiceImpl();
        }

        return instance;
    }
}
