**Smart Explorer RESTful API v1**

Smart Explorer Proxy is Web Service application that allows you to comfortable explore a history of place where just you are! Proxy separates the user from the application's core and simplifies the use of the API.
<br><br>
A WebSocket API is created to allow communication between users of Smart
 Explorer. The API's is divided into `chat rooms`. You can contact other explorers in your region.

Technologies used:
- Java 8 (Production code)
- Groovy (Unit tests)
- Spring Framework {MVC, Security, Data}
- Spock Framework 1.1


IMPORTANT
Use this with Smart Explorer. These two modules are inseparable. 

To run it in your local machine type:
<br>
- $ ./gradlew build
- $ cd build/libs
- $ java -jar smart-explorer-proxy-0.0.1.jar
<br>

Verify:
<br>
http://localhost:8091/
