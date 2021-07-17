package repositories.order;

import repositories.AbstractRepositoryImpl;
import model.entities.Order;
import storages.OrderDataStorage;

public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order> implements OrderRepository {
    private static OrderRepositoryImpl instance;
    private OrderDataStorage orderDataStorage;

    private OrderRepositoryImpl(){
    }

    public static OrderRepositoryImpl getInstance(){
        if(instance == null){
            instance = new OrderRepositoryImpl();
        }

        return instance;
    }

    public void setOrderDataStorage(OrderDataStorage orderDataStorage) {
        this.orderDataStorage = orderDataStorage;
        abstractDataStorage = orderDataStorage;
        entityType = "Order";
    }
}
