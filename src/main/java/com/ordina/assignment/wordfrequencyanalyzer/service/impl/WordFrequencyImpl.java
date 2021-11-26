package com.ordina.assignment.wordfrequencyanalyzer.service.impl;

import com.ordina.assignment.wordfrequencyanalyzer.service.WordFrequency;
import org.springframework.stereotype.Service;

@Service
public class WordFrequencyImpl implements WordFrequency {

    private String word;
    private int frequency;

    public void setWord(String word) {
        this.word = word;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String getWord() {
        return this.word;
    }

    /**
     * @param word
     * @param frequency
     */
    public WordFrequencyImpl(String word, int frequency) {
        super();
        this.word = word;
        this.frequency = frequency;
    }

    /**
     *
     */
    public WordFrequencyImpl() {
        super();
    }

    @Override
    public int getFrequency() {
        return this.frequency;
    }
}
