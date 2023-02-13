package com.mayyar.temo.BattelfieldSimple.InputPrompt.model;

import com.mayyar.temo.BattelfieldSimple.game.model.GameSnapshot;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class InputPromptResponse {
    final String response;
    final GameSnapshot gameSnapshot;
}
