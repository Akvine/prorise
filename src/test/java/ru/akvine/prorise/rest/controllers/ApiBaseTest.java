package ru.akvine.prorise.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=update"
})
@SpringBootTest
@AutoConfigureMockMvc
public class ApiBaseTest {
    @Autowired
    protected MockMvc mvc;

    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected ResultActions doPost(String link, Object request) throws Exception {
        MockHttpServletRequestBuilder postReq = post(link, request)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        if (request != null) {
            postReq.content(toJson(request));
        }

        return mvc.perform(postReq);
    }

    protected ResultActions doGet(String link, Object request) throws Exception {
        MockHttpServletRequestBuilder getReq = get(link)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        if (request != null) {
            getReq.content(toJson(request));
        }

        return mvc.perform(getReq);
    }

    protected ResultActions doPut(String link, Object request) throws Exception {
        MockHttpServletRequestBuilder getReq = put(link)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        if (request != null) {
            getReq.content(toJson(request));
        }

        return mvc.perform(getReq);
    }

    protected ResultActions doDelete(String link, Object request) throws Exception {
        MockHttpServletRequestBuilder getReq = delete(link)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        if (request != null) {
            getReq.content(toJson(request));
        }

        return mvc.perform(getReq);
    }
}
