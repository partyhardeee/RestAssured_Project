package pojoClasses.request;

import lombok.*;

@AllArgsConstructor
@Data
public class UpdateUser {
    private String name;
    private String job;
}
