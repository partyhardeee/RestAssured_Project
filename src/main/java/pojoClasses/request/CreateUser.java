package pojoClasses.request;

import lombok.*;

@AllArgsConstructor
@Data
public class CreateUser {
    protected String name;
    protected String job;
}
