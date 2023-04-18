package pojoClasses.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnsuccessfulRegister {
    private String error;


    public UnsuccessfulRegister() {
    }

    public UnsuccessfulRegister(String error) {
        this.error = error;
    }

}
