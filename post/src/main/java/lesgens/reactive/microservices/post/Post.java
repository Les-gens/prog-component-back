package lesgens.reactive.microservices.post;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {
    @Id
    private Long postId;
    private String titre;
    private String text;
    private Long userId;
    private Boolean privatePost;

}
