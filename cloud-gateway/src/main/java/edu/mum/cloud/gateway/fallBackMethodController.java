package edu.mum.clound_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fallBackMethodController {

    @GetMapping("postServiceFallBack")
    public String postServiceFallBackMethod() {
        return "Post Service is taking longer than expected" +
                "Pleas try again";
    }

    @GetMapping("commentServiceFallBack")
    public String commentServiceFallBackMethod() {
        return "Comment Service is taking longer than expected" +
                "Pleas try again";
    }

}