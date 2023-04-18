package pojoClasses.request;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UpdateUser {
    private String name;
    private String job;

    public UpdateUser() {
    }

    public UpdateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
