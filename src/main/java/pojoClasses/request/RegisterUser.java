package pojoClasses.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUser {
    private String email;
    private String password;

    public RegisterUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
