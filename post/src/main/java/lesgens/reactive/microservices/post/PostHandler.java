package lesgens.reactive.microservices.post;

import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

@AllArgsConstructor
@Component
public class PostHandler {
    @Autowired
    private PostService postService;

    Mono<ServerResponse> getById(ServerRequest r) { return defaultReadResponse(this.postService.get(id(r))); }

    Mono<ServerResponse>all(ServerRequest r) { return defaultReadResponse(this.postService.all());}

    Mono<ServerResponse>showPosts(ServerRequest r) { return defaultReadResponse(this.postService.showPosts(id(r)));}

    Mono<ServerResponse>deleteById(ServerRequest r) { return defaultReadResponse(this.postService.delete(id(r)));}

    Mono<ServerResponse> updateById(ServerRequest r) {
        Flux<Post> id = r.bodyToFlux(Post.class)
                .flatMap(p -> this.postService.update(id(r), p.getTitle(), p.getText(), p.getUserId(), p.getPrivatePost()));
        return defaultReadResponse(id);
    }

    Mono<ServerResponse> create(ServerRequest request) {
        Flux<Post> flux = request
                .bodyToFlux(Post.class)
                .flatMap(toWrite -> this.postService.create(toWrite.getTitle(), toWrite.getText(), toWrite.getUserId(), toWrite.getPrivatePost()));
        return defaultWriteResponse(flux);
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<Post> post) {
        return Mono
                .from(post)
                .flatMap(p -> ServerResponse
                        .created(URI.create("/api/posts/" + p.getPostId()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .build()
                );
    }

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
