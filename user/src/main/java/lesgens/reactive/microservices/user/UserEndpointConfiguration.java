package lesgens.reactive.microservices.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UserEndpointConfiguration {
    @Bean("userRoutes")
    RouterFunction<ServerResponse> routes(UserHandler handler) {
        return route(GET("/api/users"), handler::all)
                .andRoute(GET("/api/users/{id}"), handler::getById)
                .andRoute(DELETE("/api/users/{id}"), handler::deleteById)
                .andRoute(POST("/api/users"), handler::create)
                .andRoute(PUT("/api/users/{id}"), handler::updateById);
    }
}
