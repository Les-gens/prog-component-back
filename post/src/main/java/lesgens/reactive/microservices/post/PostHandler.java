package lesgens.reactive.microservices.post;

import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class PostHandler {
    private final PostService postService;

    Mono<ServerResponse> getById(ServerRequest r) { return defaultReadResponse(this.postService.get(id(r))); }

    Mono<ServerResponse>all(ServerRequest r) { return defaultReadResponse(this.postService.all());}

    Mono<ServerResponse>deleteById(ServerRequest r) { return defaultReadResponse(this.postService.delete(id(r)));}

    private static Mono<ServerResponse> defaultReadResponse(Publisher<Post> post){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(post, Post.class);
    }

    private static Long id(ServerRequest r) {
        return Long.parseUnsignedLong(r.pathVariable("id"));
    }


}
