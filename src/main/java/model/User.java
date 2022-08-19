package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import storage.UserStorage;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends UserStorage {

    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;

}
