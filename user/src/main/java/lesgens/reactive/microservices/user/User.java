package lesgens.reactive.microservices.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class User {
    @Id
    private long userId;
    private String username;
    private String familyname;
    private String firstname;
    private String password;
    private Date birthday;
    private String description;
}
