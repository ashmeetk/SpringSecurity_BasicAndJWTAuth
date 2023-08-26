# SpringSecurity_BasicAndJWTAuth
Basic Auth and JWT Auth are implemented as part of this project
This project is made with the help of course - Go Java Full Stack With Spring Boot And Angular by in28minutes Official.
This project did not work when I uncommented BasicAuth Security Code. Also Basic Auth only seems to be working when making API requests. JWT Auth through postman doesn't seem to be working. Therefore deal with this project in the cautious manner.

JWT Auth: After user makes request- http://localhost:8080/authenticate with basic auth credentials, the server authenticates the credentials and returns back a JWT token. This JWT token is created with the help of JWT encoder. In the following requests, when the user sends JWT token instead of credentials, the server verifies whether the JWT token is correct with the help of JWT decoder and allows user the resources without having bothered him again and again asking credentials with each request.

Basic Auth: The user needs to send credentials with each request

API requests through postman:
{username}: ashmeet

1. Retrieve all todos
  Method: GET
  API: http://localhost:8080/todos
  Authorization: username: ashmeet, password: dummy
  
3. Retrieve all todos for a specific user
  Method: GET
  API: http://localhost:8080/users/{username}/todo
  Authorization: username: ashmeet, password: dummy
  
4. Create a todo for a specific user
  Method: POST
  API: http://localhost:8080/users/{username}/todo
  Request Body: {
                  "username": "ashmeet",
                  "password": "learn to write"
                }
  Authorization: username: ashmeet, password: dummy
  Response: Returns Nothing

Notes from the above course are as below:

Form Authentication:
1. When we add spring security, form based authentication is enabled by default wherein it makes user enter credentials. It generates it as a sessionId cookie and sends it with each subsequent api request to the server. 
2. This way all subsequent requests are authenticated till the time session lasts.
3. Form based authentication provides /login, /logout as well as a default logout page.
4. Whether the first request be to a correct url or incorrect url, it is always directed to /login page, thereby not letting users know if a resource exists on the server or not. This way it fulfills one of the most imp security principle, i.e. mediation of all requests.

Basic Authentication:
-With each request we send a base 64 encoded (username + password) combination like Basic YXNobWVldHVtOmR1bW15
-Or, we can send it as- Authorization, Type: Basic Auth, Username: ashmeet, Password: dummy
-Disadvantages of basic auth: 
1. It can easily be decoded.
2. It includes no authorization. 

CSRF:
When a browser has logged in into a e.g. banking website and has session cookie stored, and by mistake opens a malicious website link, the malicious website link can utilize the session cookie and make a fraud by tranferring money from the user's account to his own account.
To protect this CSRF, basic auth does not work while making put or post requests.
A solution to CSRF can be to generate a new token each time a request is being made.(Synchronizer token pattern)
To disable csrf, we can configure a bean SecurityFilterChain and disable it for all http requests. We can also make our application STATELESS by disabling the session and thus we will no longer be able to access urls: /login, /logout.

CORS:
1. Global configuration: Add Configuration Bean WebMvcConfigurer to add configuration on all the controllers.
2. Local configuration: Add @CrossOrigin on specific controllers on whom, we want the requests to come from any domain.

Difference between Encoding, Encryption and Hashing:
1. Encoding: 
	Principle: To represent data in another form, we can encode it. Encoding doesn't require any key. The data can easily be decoded back.
	Use: While streaming or compressing, we can use encoding to store the data in a shorter form.
2. Hashing: 
	Principle: Data can be hashed to store in another format which can be converted to see original data. If we send data along with its hash, on the other end, we can convert hash 		the original data again to confirm it has not been tampered with. This promotes data integrity.
	Usage: While storing passwords, we can store its hash in the database, thereby it can never be converted back. Also when user enters the password, we can hash it to confirm 		if user has entered it correctly.
3. Encryption: 
	Principle: Data can be encrypted with the help of a key to ensure it cannot be read by unauthorized users. It can be decrypted back using same key.
