package lesgens.reactive.microservices.post;

import org.springframework.data.r2dbc.repository.Query;
import reactor.core.publisher.Flux;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@Repository
public interface PostRepository extends ReactiveCrudRepository<Post, Long> {

    @Query(value = "select distinct p.post_id, p.text, p.user_id, p.private_post from post p join friend f where " +
            "(p.user_id = f.person_id AND p.post_id IN ( select distinct p2.post_id from post p2 where p2.user_id = ?1 OR f.friend_id = ?1))" +
            " OR p.private_post = 0 ")
    Flux<Post> showPosts(Long user_id);
}
