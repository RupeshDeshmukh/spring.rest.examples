/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example;

/**
 * Simple POJO for greetings.
 * 
 * @author a120065
 */
public class Greeting {

    private final long id;
    private final String content;

    /**
     * Constructor for initializing both variables.
     * 
     * @param id
     * @param content
     */
    public Greeting(final long id, final String content) {
        this.id = id;
        this.content = content;
    }

    /**
     * Getter for id.
     *
     * @return the id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Getter for content.
     *
     * @return the content
     */
    public String getContent() {
        return this.content;
    }

}
