package pojoClasses.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
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
