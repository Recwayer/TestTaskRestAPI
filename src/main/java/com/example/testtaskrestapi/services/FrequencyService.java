package com.example.testtaskrestapi.services;

import java.util.Map;

public interface FrequencyService {
    Map<Character, Integer> getFrequencyChar(String input);
}
