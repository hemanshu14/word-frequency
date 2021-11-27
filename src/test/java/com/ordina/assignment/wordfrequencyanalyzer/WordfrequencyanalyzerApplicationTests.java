package com.ordina.assignment.wordfrequencyanalyzer;

import com.ordina.assignment.wordfrequencyanalyzer.controller.WordFrequencyAnalyzerController;
import com.ordina.assignment.wordfrequencyanalyzer.service.WordFrequencyAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WordfrequencyanalyzerApplicationTests {

    @Autowired
    private WordFrequencyAnalyzerController wordFrequencyAnalyzerController;

    @Autowired
    private WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(wordFrequencyAnalyzerController);
        Assertions.assertNotNull(wordFrequencyAnalyzer);
    }


}
