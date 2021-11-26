package com.ordina.assignment.wordfrequencyanalyzer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class WordFrequencyResponse {
    private final String word;
    private final long frequency;
}
