package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.enums.status.OrderStatus;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Order extends BaseEntity {
    private User user;
    private Collection<OrderItem> orderItems;
    private double totalPrice;
    private OrderStatus status;
    private LocalDate creationDate;
    private LocalDate updateDate;
    private LocalDate completionDate;

    @Override
    public String toString() {
        return "Id = " + id +
                "\nClient: " + user.getFirstName() + " " + user.getLastName() + ", " + user.getEmail() +
                "\nTotal price = " + totalPrice +
                "\nStatus: " + status +
                "\nCreation date: " + creationDate +
                "\nCompletion date: " + completionDate +
                "\nOrder items:" + orderItemsToString();
    }

    private String orderItemsToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(OrderItem item : orderItems){
            stringBuilder.append("\n\t— ").append(item.toString());
        }

        return stringBuilder.toString();
    }
}
