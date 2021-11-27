package com.ordina.assignment.wordfrequencyanalyzer.service.impl;

import com.ordina.assignment.wordfrequencyanalyzer.service.WordFrequency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordFrequencyImpl implements WordFrequency {

    private String word;
    private int frequency;
}
