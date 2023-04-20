package com.item.validationservice;

import com.item.validationservice.model.ItemCondition;
import com.item.validationservice.model.ItemValidationRequest;
import com.item.validationservice.model.ItemValidationResponse;
import com.item.validationservice.service.ItemValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemValidationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemValidationService itemValidationService;

    private ItemValidationRequest request;

    @BeforeEach
    public void setUp() {
        // Create a sample request for testing
        request = new ItemValidationRequest();
        request.setSiteId("us");
        request.setCategoryId("12345");
        request.setTitle("Test Item");
        request.setCondition(ItemCondition.NEW);
        request.setPrice(BigDecimal.valueOf(10.99));
        request.setQuantity(5);
        List<String> imageURLs = new ArrayList<>();
        imageURLs.add("https://example.com/image1.jpg");
        imageURLs.add("https://example.com/image2.jpg");
        request.setImageURLs(imageURLs);
        List<String> itemSpecifics = new ArrayList<>();
        itemSpecifics.add("Brand: Test");
        itemSpecifics.add("Model: 123");
        request.setItemSpecifics(itemSpecifics);
        request.setDescription("This is a test item.");
    }

    @Test
    public void testValidateItem() throws Exception {
        // Set up the mock service response
        ItemValidationResponse response = new ItemValidationResponse();
        response.setValid(true);
        Mockito.when(itemValidationService.validate(Mockito.any(ItemValidationRequest.class)))
                .thenReturn(response);

        // Send a POST request to the controller
        mockMvc.perform(MockMvcRequestBuilders.post("/api/items/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"siteId\": \"us\",\n" +
                                "    \"categoryId\": \"12345\",\n" +
                                "    \"title\": \"Test Item\",\n" +
                                "    \"condition\": \"NEW\",\n" +
                                "    \"price\": 10.99,\n" +
                                "    \"quantity\": 5,\n" +
                                "    \"imageURLs\": [\n" +
                                "        \"https://example.com/image1.jpg\",\n" +
                                "        \"https://example.com/image2.jpg\"\n" +
                                "    ],\n" +
                                "    \"itemSpecifics\": [\n" +
                                "        \"Brand: Test\",\n" +
                                "        \"Model: 123\"\n" +
                                "    ],\n" +
                                "    \"description\": \"This is a test item.\"\n" +
                                "}")
                )
                // Verify that the response has a 200 status code
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Verify that the response body is valid
                .andExpect(MockMvcResultMatchers.jsonPath("$.valid").value(true));
    }
}

