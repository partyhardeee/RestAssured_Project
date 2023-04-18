package pojoClasses.response;

import lombok.Data;


import java.util.Date;

@Data
public class SuccessCreate {
    private String name;
    private String job;
    private String id;
    private Date createdAt;


}
