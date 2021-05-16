package lesgens.reactive.microservices.post;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface PostRepository extends ReactiveSortingRepository<Post, Long> {

}
