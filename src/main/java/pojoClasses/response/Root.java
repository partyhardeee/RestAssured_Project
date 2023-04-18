package pojoClasses.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    private Data data;
    private String name;
    private String job;
    private Date updatedAt;

}
