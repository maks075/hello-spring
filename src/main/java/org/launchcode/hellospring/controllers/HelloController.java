package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloController {

    //Handles requests at path /hello
    @GetMapping
    public String hello() {
        return "Hello, Spring";
    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handles request of the form /hello?name=LaunchCode


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {

        return "Hello, " + name + "!";

    }

    //handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

}
