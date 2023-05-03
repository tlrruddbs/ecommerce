package com.example.secondservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class SecondServiceController {
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to the second service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header){
        System.out.println(header);
        return "hello world in second service";
    }

    @GetMapping("/check")
    public String check(){
        return "hi, there. this is a message from second service.";
    }
}
