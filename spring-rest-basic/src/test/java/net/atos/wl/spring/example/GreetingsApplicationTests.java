/*
 * Copyright (C) 2016 Worldline UK&I.
 */
package net.atos.wl.spring.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * JUnit test case for testing <code>/greeting</code> REST service.
 * 
 * @author a120065
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test to check REST service output when no query parameters are passed.
     * 
     * @throws Exception
     *             occurred while invoking the REST service.
     */
    @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                        .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    /**
     * Test to check REST service output when query parameter is passed.
     * 
     * @throws Exception
     *             occurred while invoking the REST service.
     */
    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/greeting").param("name", "Spring Community")).andDo(print())
                        .andExpect(status().isOk()).andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
    }
}
