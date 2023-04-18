package pojoClasses.request;

import lombok.*;

@AllArgsConstructor
@Data
public class RegisterUser {
    private String email;
    private String password;
}
