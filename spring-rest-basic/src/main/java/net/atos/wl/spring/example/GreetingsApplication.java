/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * Spring Boot Application to run the simple REST service in tomcat container.
 * </p>
 * 
 * <p>
 * <code>@SpringBootApplication</code> is a convenience annotation that adds all
 * of the following:
 * 
 * <ul>
 * <li><code>@Configuration</code> tags the class as a source of bean
 * definitions for the application context.</li>
 * <li><code>@EnableAutoConfiguration</code> tells Spring Boot to start adding
 * beans based on classpath settings, other beans, and various property
 * settings.</li>
 * <li>Normally you would add <code>@EnableWebMvc</code> for a Spring MVC app,
 * but Spring Boot adds it automatically when it sees spring-webmvc on the
 * classpath. This flags the application as a web application and activates key
 * behaviors such as setting up a <code>DispatcherServlet</code>.</li>
 * <li><code>@ComponentScan</code> tells Spring to look for other components,
 * configurations, and services in the the com.examples.spring.rest package,
 * allowing it to find the <code>GreetingController.</code></li>
 * </ul>
 * </p>
 * 
 * <p>
 * The main() method uses Spring Boot’s SpringApplication.run() method to launch
 * an application. Did you notice that there wasn’t a single line of XML? No
 * web.xml file either. This web application is 100% pure Java and you didn’t
 * have to deal with configuring any plumbing or infrastructure.
 * </p>
 * 
 * @author a120065
 */
@SpringBootApplication
public class GreetingsApplication {

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(GreetingsApplication.class, args);
    }
}
