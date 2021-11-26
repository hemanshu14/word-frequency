package com.ordina.assignment.wordfrequencyanalyzer.controller;

import com.ordina.assignment.wordfrequencyanalyzer.service.WordFrequencyAnalyzer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * WordFrequencyAnalyzerController
 * <br>
 * <code>com.ordina.assignment.wordfrequencyanalyzer.controller.WordFrequencyAnalyzerController</code>
 * <br>
 *
 * @author hemanshu.banga
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/word-frequency-analyzer")
public class WordFrequencyAnalyzerController {

    private final WordFrequencyAnalyzer wordFrequencyAnalyzer;

    /**
     * Method to retrieve the frequency of the most occurring word in a given sentence
     *
     * @param text required text in which we need to find the frequency of the most occurring word
     * @return the integer value of the most occurring word in the given sentence
     */
    @GetMapping("/words/frequency/highest/{text}")
    @ResponseBody
    @Operation(summary = "Receive the frequency of the most occurring word in a given sentence", //
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the frequency of the most occurring word in a given sentence", //
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Server Error", content = @Content(mediaType = "application/json"))})
    public int getHighestWordFrequency(@Parameter(name = "text", required = true, description = "The text in which we need to find the frequency of the most occurring word") @Valid @NonNull @PathVariable final String text) {
        return wordFrequencyAnalyzer.calculateHighestFrequency(text);
    }

    /**
     * Method to retrieve the frequency of the given word in a given sentence
     *
     * @param text required text in which we need to find the frequency of the given word
     * @param word required word for which we need to find the frequency in the given text
     * @return the integer value of the frequency of the given word in the given sentence
     */
    @GetMapping("/words/count/{text}/{word}")
    @ResponseBody
    @Operation(summary = "Receive the frequency of the given word in a given sentence", //
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved the frequency of the given word in a given sentence", //
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Server Error", content = @Content(mediaType = "application/json"))})
    public int getWordFrequency(@Parameter(name = "text", required = true, description = "The text in which we need to find the frequency of the given word") @Valid @NonNull @PathVariable final String text, @Parameter(name = "word", required = true, description = "The word for which we need to find the frequency in the given text") @Valid @NonNull @PathVariable final String word) {
        return wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);
    }
}
