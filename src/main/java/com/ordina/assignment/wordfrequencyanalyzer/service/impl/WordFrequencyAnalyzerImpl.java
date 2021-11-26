package com.ordina.assignment.wordfrequencyanalyzer.service.impl;

import com.ordina.assignment.wordfrequencyanalyzer.exception.DataNotFoundException;
import com.ordina.assignment.wordfrequencyanalyzer.service.WordFrequency;
import com.ordina.assignment.wordfrequencyanalyzer.service.WordFrequencyAnalyzer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * WordFrequencyAnalyzerImpl
 * <br>
 * <code>com.ordina.assignment.wordfrequencyanalyzer.service.impl.WordFrequencyAnalyzerImpl</code>
 * <br>
 *
 * @author hemanshu.banga
 */

@Service
@Slf4j
public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

    @Override
    public int calculateHighestFrequency(String text) {
        var methodName = "calculateHighestFrequency";
        log.info("Starting method {}", methodName);

        var listOfWords = getListOfWords(text);

        if (listOfWords.isEmpty()) {
            throw new DataNotFoundException("There are no alphabetical words present in the given text");
        }

        Map<String, Long> result = listOfWords.stream().collect(
                Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        var max = result.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();

        log.info("Ending method {}", methodName);
        return max.getValue().intValue();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        var methodName = "calculateFrequencyForWord";
        log.info("Starting method {}", methodName);

        var listOfWords = getListOfWords(text);

        if (listOfWords.isEmpty()) {
            throw new DataNotFoundException("There are no alphabetical words present in the given text");
        }

        var frequency = listOfWords.stream()
                .filter(input -> input.equalsIgnoreCase(word)).count();
        if (frequency == 0) {
            throw new DataNotFoundException("There is no given word present in the given text");
        }
        log.info("Ending method {}", methodName);
        return (int) frequency;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        return null;
    }


    private List<String> getListOfWords(String text) {
        var list = new ArrayList<String>();
        var regexPattern = Pattern.compile("[a-zA-Z]+");
        var regexMatch = regexPattern.matcher(text);
        while (regexMatch.find()) {
            list.add(regexMatch.group(0).toLowerCase());
        }
        return list;
    }
}
