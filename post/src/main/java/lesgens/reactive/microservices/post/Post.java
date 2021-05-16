package lesgens.reactive.microservices.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;



@Data
@AllArgsConstructor
public class Post {
    @Id
    private Long postId;
    private String titre;
    private String text;
    private Long userId;
    private Boolean privatePost;

}
