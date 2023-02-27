package com.shah.starter.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {


    @GetMapping("/secured")
    public String securedController() {
        return "this is secured controller";
    }

    @GetMapping("/unsecured")
    public String unSecuredController() {
        return "this is not secured controller";
    }

    @GetMapping("/exception")
    public String exceptionController() throws Exception {

        if(true) {
            throw new Exception("Exception controller called");
        }

        return "this is not exception controller";
    }
}
