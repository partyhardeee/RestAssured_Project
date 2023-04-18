package pojoClasses.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessRegister {
    private Integer id;
    private String token;

    public SuccessRegister() {
    }

    public SuccessRegister(Integer id, String token) {
        this.id = id;
        this.token = token;
    }
}
