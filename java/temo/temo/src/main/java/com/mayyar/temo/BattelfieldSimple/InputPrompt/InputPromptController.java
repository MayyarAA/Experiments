package com.mayyar.temo.BattelfieldSimple.InputPrompt;

import com.mayyar.temo.BattelfieldSimple.InputPrompt.model.InputPrompt;
import com.mayyar.temo.BattelfieldSimple.InputPrompt.model.InputPromptResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/v1/inputprompts")
@RestController
public class InputPromptController {
    private final InputPromptService inputPromptService;

    @Autowired
    public InputPromptController(final InputPromptService inputPromptService){
        this.inputPromptService = inputPromptService;
    }

    @RequestMapping(path = "/start/{gameid}", method = RequestMethod.POST)
    public ResponseEntity<InputPromptResponse> postGameStart(@PathVariable("gameid") final String gameId,
                                          @RequestBody final InputPrompt inputPrompt) {
        log.info("Received game start request, {} and prompt: {}", gameId, inputPrompt);
        try {
            final InputPromptResponse inputPromptResponse = inputPromptService.createGame(gameId, inputPrompt);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(inputPromptResponse);
        } catch (final Exception e) {
            log.error("Error during postGameStart", e);
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(null);
        }

    }
}
