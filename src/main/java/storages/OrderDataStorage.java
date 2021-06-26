package storages;

import lombok.Setter;
import model.entities.Order;

public class OrderDataStorage extends AbstractDataStorage<Order>{
    @Setter
    private static OrderDataStorage instance;

    private OrderDataStorage(){}

    public static OrderDataStorage getInstance(){
        if(instance == null){
            instance = new OrderDataStorage();
        }

        return instance;
    }
}
