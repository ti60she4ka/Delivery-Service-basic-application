package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Client extends BaseEntity implements Cloneable {
    private String firstName;
    private String lastName;
    private String email;

    public Client(Client client) {
        firstName = client.getFirstName();
        lastName = client.getLastName();
        email = client.getEmail();
    }

    @Override
    public String toString() {
        return "ID — " + id +
                "\nFirst name — " + firstName +
                "\nLast name — " + lastName +
                "\nEmail — " + email;
    }
}
