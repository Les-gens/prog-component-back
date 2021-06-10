# prog-component-back

# endpoints : 

## POSTS

* (GET) => http://localhost:7100/api/posts
* (GET) => http://localhost:7100/api/posts/{id}
* (POST) => http://localhost:7100/api/posts
* (DELETE) => http://localhost:7100/api/posts/{id}
* (PUT) => http://localhost:7100/api/posts/{id}

## USERS

* (GET) => http://localhost:7101/api/users
* (GET) => http://localhost:7101/api/users/{id}
* (POST) => http://localhost:7101/api/users
* (DELETE) => http://localhost:7101/api/users/{id}
* (PUT) => http://localhost:7101/api/users/{id}


# Afin de lancer le projet 

Cd dans chacun des micro services séparément (admin, batch, config, gateway, post, user) : 

> mvn clean && mvn spring-boot:run

# Authors

* @verzelea - Arthur Verzele
* @Un-dev - Francois Lannoy
* @Skiadram - Neel Coffin
* @Galimede - Mathieu Degand
