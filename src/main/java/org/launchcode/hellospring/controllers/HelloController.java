package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
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
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String properGreeting = HelloController.createMessage(name, language);

        return "<h3 style='color:blue'>" + properGreeting + "</h3>";

    }

    //handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +  //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                    "<option value='English'>English</option>" +
                    "<option value='Ukrainian'>Ukrainian</option>" +
                    "<option value='German'>German</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='Spanish'>Spanish</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public static String createMessage(String n, String l) {
        String message = "";

        if (l.equals("English") ) {
            message = "Hello " + n;
        }

        if (l.equals("Ukrainian") ) {
            message = "Привіт " + n;
        }

        if (l.equals("German") ) {
            message = "Hallo " + n;
        }

        if (l.equals("French") ) {
            message = "Bonjour " + n;
        }

        if (l.equals("Spanish")  ) {
            message = "Hola " + n;
        }

        return message;
    }



}
