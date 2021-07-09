package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.enums.status.OrderStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Order extends BaseEntity {
    private User user;
    private List<Product> products;
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
                "\nProducts:" + articlesToString();
    }

    private String articlesToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Product product : products){
            stringBuilder.append("\n\t— ").append(product.toString());
        }

        return stringBuilder.toString();
    }
}
