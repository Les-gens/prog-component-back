package lesgens.reactive.microservices.user;

import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@AllArgsConstructor
@Component
public class UserHandler {
    private final UserService userService;
    
    Mono<ServerResponse> getById(ServerRequest r) {
        return defaultReadResponse(this.userService.get(id(r)));
    }

    Mono<ServerResponse> all(ServerRequest r) {
        return defaultReadResponse(this.userService.all());
    }

    Mono<ServerResponse> deleteById(ServerRequest r) {
        return defaultReadResponse(this.userService.delete(id(r)));
    }

    Mono<ServerResponse> updateById(ServerRequest r) {
        Flux<User> id = r.bodyToFlux(User.class)
                .flatMap(p -> this.userService.update(id(r), p.getUsername(), p.getFamilyname(),
                p.getFirstname(), p.getPassword(), p.getBirthday(), p.getDescription()));
        return defaultReadResponse(id);
    }

    Mono<ServerResponse> create(ServerRequest request) {
        Flux<User> flux = request
                .bodyToFlux(User.class)
                .flatMap(toWrite -> this.userService.create(toWrite.getUsername(),
                toWrite.getFamilyname(), toWrite.getFirstname(), toWrite.getPassword(),
                toWrite.getBirthday(), toWrite.getDescription()));
        return defaultWriteResponse(flux);
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<User> user) {
        return Mono
                .from(user)
                .flatMap(p -> ServerResponse
                        .created(URI.create("/api/devoirs/" + p.getUserId()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .build()
                );
    }

    private static Mono<ServerResponse> defaultReadResponse(Publisher<User> user) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(user, User.class);
    }

    private static Long id(ServerRequest r) {
        return Long.parseUnsignedLong(r.pathVariable("id"));
    }
}