package pojoClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Create {
    protected String name;
    protected String job;

    public Create() {
    }

    public Create(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
