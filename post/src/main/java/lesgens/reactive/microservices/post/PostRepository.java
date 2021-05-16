package lesgens.reactive.microservices.post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveSortingRepository<Post, Long> {

    @Query(value = "select distinct p.post_id, p.text, p.user_id, p.private_post from post p join friend f where " +
            "(p.user_id = f.person_id AND p.post_id IN ( select distinct p2.post_id from post p2 where p2.user_id = ?1 OR f.friend_id = ?1))" +
            " OR p.private_post = 0 ", nativeQuery = true)
    Flux<Post> showPosts(Long user_id);
}
