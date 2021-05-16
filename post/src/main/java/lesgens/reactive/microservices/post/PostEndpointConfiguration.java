package lesgens.reactive.microservices.post;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;

@Configuration
public class PostEndpointConfiguration {
    @Bean("postRoutes")
    RouterFunction<ServerResponse> routes(PostHandler handler) {
        return route(GET("/api/posts"), handler::all)
                .andRoute(GET("api/posts/{id}"), handler::getById)
                .andRoute(DELETE("api/posts/{id}"), handler::deleteById)
                .andRoute(POST("api/posts"), handler::create)
                .andRoute(PUT("api/posts/{id}"), handler::updateById);
    }

}
