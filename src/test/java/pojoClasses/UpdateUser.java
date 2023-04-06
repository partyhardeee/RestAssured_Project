package pojoClasses;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
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
