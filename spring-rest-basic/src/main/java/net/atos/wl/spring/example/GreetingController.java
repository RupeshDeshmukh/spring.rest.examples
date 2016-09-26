/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple rest controller to demonstrate simple GET REST service to return
 * greetings to the user.
 * 
 * <code>@RestController</code> marks the class as a controller where every
 * method returns a domain object instead of a view. It’s shorthand for
 * <code>@Controller</code> and <code>@ResponseBody</code> rolled together.
 * 
 * @author a120065
 */
@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * <p>
     * REST service to return greeting message to the user.
     * </p>
     * 
     * <p>
     * Here Greeting object is converted into JSON format by Spring's HTTP
     * message converter support.
     * <code>MappingJackson2HttpMessageConverter</code> is automatically chosen
     * to convert the Greeting instance to JSON.
     * </p>
     * 
     * <p>
     * The <code>@RequestMapping</code> annotation ensures that HTTP requests to
     * /greeting are mapped to the greeting() method.
     * </p>
     * 
     * <p>
     * <code>@RequestParam</code> binds the value of the query string parameter
     * name into the name parameter of the greeting() method. This query string
     * parameter is optional (required=false by default): if it is absent in the
     * request, the defaultValue of "World" is used.
     * </p>
     * 
     * @param name
     *            String
     * @return String greetings.
     */
    @GetMapping
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {
        return new Greeting(this.counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
