package com.instaply.thermodataco.controller;


import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.instaply.thermodataco.service.TemperatureService;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TemperatureControllerTest {
	
    MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    TemperatureController temperatureController;
    @MockBean
    TemperatureService temperatureService;
	
	@Before
	public void before() {
		this.mockMvc = standaloneSetup(this.temperatureController).build();// Standalone context
	}

    @Test
    public void test_checkStatus() throws Exception {
        // Mocking service

        mockMvc.perform(get("/status").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
            //.andExpect(jsonPath())
    }	
	
}
