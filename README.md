# prog-component-back

# endpoints : 

## POSTS

* (GET) => http://localhost:7100/api/posts
* (GET) => http://localhost:7100/api/posts/{id}
* (POST) => http://localhost:7100/api/posts
* (DELETE) => http://localhost:7100/api/posts/{id}
* (PUT) => http://localhost:7100/api/posts/{id}

### Exemple body posts
```json
{
    "title": "test",
    "text": "test content",
    "userId": 2,
    "privatePost": false
}
```


## USERS

* (GET) => http://localhost:7101/api/users
* (GET) => http://localhost:7101/api/users/{id}
* (POST) => http://localhost:7101/api/users
* (DELETE) => http://localhost:7101/api/users/{id}
* (PUT) => http://localhost:7101/api/users/{id}

### Exemple body users
```json
{
    "username": "test", 
    "prenom": "test",
    "nom": "saskah",
    "password": "jaadaelqe",
    "birthday": "1990-05-15",
    "description": "hello"
}
```

# Afin de lancer le projet 

Lancer la db avec docker à la racine avec 
> docker-compose -f db-docker-compose.yml up

Cd dans chacun des micro services séparément (admin, batch, config, gateway, post, user) : 

> mvn clean && mvn spring-boot:run

# Authors

* @verzelea - Arthur Verzele
* @Un-dev - Francois Lannoy
* @Skiadram - Neel Coffin
* @Galimede - Mathieu Degand
