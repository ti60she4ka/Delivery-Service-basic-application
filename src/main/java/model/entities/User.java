package model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

    public User(User user) {
        username = user.getUsername();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        phoneNumber = user.getPhoneNumber();
        address = user.getAddress();
    }

    @Override
    public String toString() {
        return "ID — " + id +
                "\nUsername — " + username +
                "\nFirst name — " + firstName +
                "\nLast name — " + lastName +
                "\nEmail — " + email +
                "\nPhone number — " + phoneNumber +
                "\nAddress — " + address;
    }
}
