package com.example.firstservice;

import com.netflix.discovery.converters.Auto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/first-service")
@RequiredArgsConstructor
public class FirstServiceController {

    private final Environment env;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to the first service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
        System.out.println(header);
        return "hello world in first service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        log.info("server port ={}", request.getServerPort());
        return String.format("hi, there. this is a message from first service on port %s"
        , env.getProperty("local.server.port"));
    }

}
