package com.example.testtaskrestapi.controllers;

import com.example.testtaskrestapi.exceptions.ClientRequestException;
import com.example.testtaskrestapi.services.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FrequencyController {
    private final FrequencyService frequencyService;
    @Autowired
    public FrequencyController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }



    @PostMapping("/calculateFrequency")
    public Map<Character, Integer> calculateFrequency(@RequestBody String input) {
        if (input == null || input.isEmpty()) {
            throw new ClientRequestException.InputException("Input cannot be empty.");
        } else if(input.length()>10000){
            throw new ClientRequestException.InputException(String.format("Input must not exceed 10000 characters. Current line length: %d.",input.length()));
        } else if(input.contains("\n") || input.contains("\r")){
            throw new ClientRequestException.InputException("Input cannot be divided into several lines.");
        }
        return frequencyService.getFrequencyChar(input);
    }
}
