package pojoClasses.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
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
}
