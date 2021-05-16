package lesgens.reactive.microservices.user;

import reactor.core.publisher.Mono;

public interface IUserService {
    Mono<Boolean> userExistsById(Long userId);
}
