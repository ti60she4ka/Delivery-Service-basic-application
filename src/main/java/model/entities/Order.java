package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Order extends BaseEntity {
    private Client client;
    private String address;
    private List<ProductStorage> productStorages;
    private double price;

    @Override
    public String toString() {
        return "Id = " + id +
                "\nClient: " + client.getFirstName() + " " + client.getLastName() + ", " + client.getEmail() +
                "\nAddress: " + address +
                "\nTotal price = " + price +
                "\nProducts:" + ProductStoragesToString();
    }

    private String ProductStoragesToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(ProductStorage item : productStorages){
            stringBuilder.append("\n\t— ").append(item.toString())
                    .append(" in ").append(item.getProduct().getNameOfShop());
        }

        return stringBuilder.toString();
    }
}
