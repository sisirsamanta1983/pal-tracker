
package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.Value;
import org.springframework.beans.factory.annotation.Value;


@RestController
public class WelcomeController {
    String message;
    @GetMapping("/")
    public String sayHello() {
        ///@Value("ssfskg")

        return message;
    }
    public WelcomeController(@Value("${welcome.message}") String message)
    {
        this.message = message;

    }




}
