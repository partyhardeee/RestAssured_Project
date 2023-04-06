package pojoClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Data data;
    private String name;
    private String job;
    private Date updatedAt;

    public Root() {
    }

    public Root(Data data, String name, String job, Date updatedAt) {
        this.data = data;
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Data getData() {
        return data;
    }
}
