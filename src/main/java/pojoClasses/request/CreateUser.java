package pojoClasses.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUser {
    protected String name;
    protected String job;

    public CreateUser() {
    }

    public CreateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
