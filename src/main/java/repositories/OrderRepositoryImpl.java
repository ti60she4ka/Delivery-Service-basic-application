package repositories;

import api.repositories.OrderRepository;
import model.entities.Order;
import storages.OrderDataStorage;

public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order> implements OrderRepository {
    private static OrderRepositoryImpl instance;
    private final OrderDataStorage orderDataStorage;

    private OrderRepositoryImpl(){
        super(OrderDataStorage.getInstance());
        orderDataStorage = (OrderDataStorage) abstractDataStorage;
        entityType = "Order";
    }

    public static OrderRepositoryImpl getInstance(){
        if(instance == null){
            instance = new OrderRepositoryImpl();
        }

        return instance;
    }
}
