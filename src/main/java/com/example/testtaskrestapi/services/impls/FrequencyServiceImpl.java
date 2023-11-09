package com.example.testtaskrestapi.services.impls;

import com.example.testtaskrestapi.services.FrequencyService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FrequencyServiceImpl implements FrequencyService {
    public Map<Character, Integer> getFrequencyChar(String input) {
        if(input==null||input.isEmpty()){
            throw new IllegalArgumentException("Input cannot be empty.");
        }
        Map<Character, Integer> map = new HashMap<>();

        for (String s : input.split("")) {
            char c = s.charAt(0);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
