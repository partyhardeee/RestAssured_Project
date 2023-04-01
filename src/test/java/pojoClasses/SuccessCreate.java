package pojoClasses;

import java.util.Date;


public class SuccessCreate extends Create {
    private String id;
    private Date createdAt;

    public SuccessCreate() {
    }

    public SuccessCreate(String name, String job, String id, Date createdAt) {
        super(name, job);
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
