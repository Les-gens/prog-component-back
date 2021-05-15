package lesgens.reactive.microservices.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Date;
import java.time.LocalDateTime;

@Log4j2
@RequiredArgsConstructor
@Service
class UserService {

    private final UserRepository userRepository;

    public Flux<User> all() {
        return this.userRepository.findAll();
    }

    public Mono<User> get(Long userId) {
        return this.userRepository.findById(userId);
    }

    public Mono<User> update(Long id, String username, String familyname, String firstname, String password, Date birthday, String description) {
        return this.userRepository
                .findById(id)
                .map(p -> {
                    p.setUsername(username);
                    p.setFamilyname(familyname);
                    p.setFirstname(firstname);
                    p.setPassword(password);
                    p.setBirthday(birthday);
                    p.setDescription(description);
                    return p;
                })
                .flatMap(this.userRepository::save);
    }

    public Mono<User> delete(Long id) {
        return this.userRepository
                .findById(id)
                .flatMap(p -> this.userRepository.deleteById(p.getId()).thenReturn(p));
    }

    public Mono<User> create(String username, String familyname, String firstname, String password, Date birthday, String description) {
        return this.userRepository.save(new User(null, username, familyname, firstname, password, birthday, description));
    }
}