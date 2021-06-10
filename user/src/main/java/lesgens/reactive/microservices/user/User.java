package lesgens.reactive.microservices.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    private Long userId;
    private String username;
    private String familyname;
    private String firstname;
    private String password;
    private LocalDate birthday;
    private String description;
}
