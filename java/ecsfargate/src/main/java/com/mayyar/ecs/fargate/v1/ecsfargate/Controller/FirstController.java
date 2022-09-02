package com.mayyar.ecs.fargate.v1.ecsfargate.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstController {
    @GetMapping
    public String applicationStatus(){
        return "App is running fully healthy ";
    }
    @GetMapping("/{name}")
    public String welcome(@PathVariable String name){
        return "Hello " + name + " this is the ECS + Fargate project";
    }
}
