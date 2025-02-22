package com.firstspringapp.controller;
import org.springframework.web.bind.annotation.*;
import com.firstspringapp.model.User;

import static javax.management.Query.value;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // curl localhost:8080/hello-w "\n"
    @GetMapping("/home")
    public String sayHello() {
        return "Hello From BridgeLabz!";
    }

    // curl localhost:8080/hello/query?name="yourName"
    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHelloQuery(@RequestParam(value = "name") String name) {
        return "Hello " + name + " !";
    }

    // curl localhost:8080/hello/param/________ -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello " + name + " !";
    }

    // curl -X POST -H "Content-Type: application/json"
    // -d("firstName": "Lisa", "lastName": {"Harry"}"
    // "http://localhost:8080/hello/post" -w "\n"
    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName()+user.getLastName() + " !";
    }

    // curl -X PUT localhost:8080/hello/put/Lisa/7lastName-Terrisa -w "\n"
    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + " !";
    }
}