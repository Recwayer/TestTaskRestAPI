package com.example.testtaskrestapi;

import com.example.testtaskrestapi.controllers.FrequencyController;
import com.example.testtaskrestapi.exceptions.ClientRequestException;
import com.example.testtaskrestapi.services.FrequencyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class FrequencyControllerTest {
    private FrequencyService service;
    private FrequencyController controller;

    @Before
    public void init() {
        service = Mockito.mock(FrequencyService.class);
        controller = new FrequencyController(service);
    }

    @Test
    public void testCalculateFrequency() {
        String input = "aaaaabcccc\\";
        Map<Character, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put('a', 5);
        expectedMap.put('c', 4);
        expectedMap.put('b', 1);
        expectedMap.put('\\', 1);
        when(service.getFrequencyChar(input)).thenReturn(expectedMap);

        Map<Character, Integer> result = controller.calculateFrequency(input);

        assertEquals(expectedMap, result);
    }

    @Test
    public void testCalculateFrequencyEmptyInput() {
        String input = "";
        assertThrows(ClientRequestException.InputException.class,()->controller.calculateFrequency(input));
        try {
            controller.calculateFrequency(input);
        } catch (ClientRequestException.InputException e) {
            assertEquals("Input cannot be empty.", e.getMessage());
        }
    }

    @Test
    public void testCalculateFrequencyLongInput() {
        String input = "a".repeat(10001);
        assertThrows(ClientRequestException.InputException.class,()->controller.calculateFrequency(input));
        try {
            controller.calculateFrequency(input);
        } catch (ClientRequestException.InputException e) {
            assertEquals("Input must not exceed 10000 characters. Current line length: 10001.", e.getMessage());
        }
    }
    @Test
    public void testCalculateFrequencyMultipleLinesInput() {
        String input = "aaa\nbbb";
        assertThrows(ClientRequestException.InputException.class,()->controller.calculateFrequency(input));
        try {
            controller.calculateFrequency(input);
        } catch (ClientRequestException.InputException e) {
            assertEquals("Input cannot be divided into several lines.", e.getMessage());
        }
    }
}
