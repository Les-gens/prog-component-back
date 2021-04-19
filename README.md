# prog-component-back

This is a REST spring-boot backend for our prog component project. 

In this proejct you can :
* You can sign-up on the `/users/sign-up` endpoint.
* Login on the `/login` endpoint that will give you in the header a token that you will need to access the other endpoints.
* There is also two endpoints `/posts/**`, `/users/**` where you can find all the datas.
* You can also see your friend requests, accept them and send friend reuests to other people (more details on these endpoints in the  `methods.json` file)

-> A list of pre-filled endpoints are available in the `methods.json`file that you can import in postman/insomnia... to try the endpoints easily

# Run the project with maven 

> maven clean && maven spring-boot:run

# Authors

* @verzelea - Arthur Verzele
* @Un-dev - Francois Lannoy
* @Skiadram - Neel Coffin
* @Galimede - Mathieu Degand
