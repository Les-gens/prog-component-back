package lesgens.reactive.microservices.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Flux<Post> all() { return this.postRepository.findAll(); }

    public Mono<Post> get(Long id) { return this.postRepository.findById(id); }

    public Mono<Post>update(Long id, String titre, String text, Long user_id, boolean private_post) {
        return this.postRepository
                .findById(id)
                .map(p -> {
                    p.setTitre(titre);
                    p.setText(text);
                    p.setPrivatePost(private_post);
                    return p;
                })
                .flatMap(this.postRepository::save);
    }

    public Mono<Post>delete(Long id){
        return this.postRepository
                .findById(id)
                .flatMap(p -> this.postRepository.deleteById(p.getPostId()).thenReturn(p));
    }

    public Mono<Post> create(String titre, String text, Long user_id, boolean private_post){
        return this.postRepository.save(new Post(null, titre, text, user_id, private_post));
    }
}
