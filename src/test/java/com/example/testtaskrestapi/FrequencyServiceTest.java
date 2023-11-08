package com.example.testtaskrestapi;

import com.example.testtaskrestapi.services.FrequencyService;
import com.example.testtaskrestapi.services.impls.FrequencyServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FrequencyServiceTest {
    private FrequencyService service;
    private Map<Character, Integer> expectedMap;

    @Before
    public void init() {
        service = new FrequencyServiceImpl();
        expectedMap = new LinkedHashMap<>();
    }

    @Test
    public void testGetFrequencyChar() {
        expectedMap.put('a', 5);
        expectedMap.put('c', 4);
        expectedMap.put('b', 1);
        expectedMap.put('\\', 1);

        assertEquals(expectedMap, service.getFrequencyChar("aaaaabcccc\\"));
    }

    @Test
    public void testGetFrequencyCharEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> service.getFrequencyChar(""));
    }

    @Test
    public void testGetFrequencyCharNullInput() {
        assertThrows(IllegalArgumentException.class, () -> service.getFrequencyChar(null));

    }
}
