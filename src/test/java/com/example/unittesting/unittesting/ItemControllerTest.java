package com.example.unittesting.unittesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

 //      assertEquals("hello nedo", mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void itemFromBusinessService() throws Exception {
        when(itemBusinessService.retrieveHardCodedItem()).thenReturn(new Item(2,"item2",2,3));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-services")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:item2}"))
                .andReturn();

 //      assertEquals("hello nedo", mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(itemBusinessService.retrieveAll()).thenReturn(
                Arrays.asList(new Item(2,"item2",10,10),
                              new Item(3,"item3",20,20))
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2,name:item2},{id:3,name:item3}]"))
                .andReturn();

 //      assertEquals("hello nedo", mvcResult.getResponse().getContentAsString());

    }


}
