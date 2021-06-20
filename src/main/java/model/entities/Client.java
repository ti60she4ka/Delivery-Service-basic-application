package model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;

    public Client(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return  "Id — " + id + '\n'
                + "First name — " + firstName + '\n'
                + "Last name — " + lastName + '\n'
                + "Email — " + email;
    }
}
