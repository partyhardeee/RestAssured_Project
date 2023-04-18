package pojoClasses.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SuccessCreate {
    private String name;
    private String job;
    private String id;
    private Date createdAt;

    public SuccessCreate() {
    }

    public SuccessCreate(String name, String job, String id, Date createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }
}
