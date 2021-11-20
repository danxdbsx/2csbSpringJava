package com.csb.samplefullstack.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.csb.samplefullstack.computations.computation.sum;

@RestController
@RequestMapping("/api/v1/greet")
@CrossOrigin("*")
public class Greet {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!!!" + sum();
    }

    @RequestMapping("/hi")
    public String hi(){
        return "hi world!!!";
    }
}
