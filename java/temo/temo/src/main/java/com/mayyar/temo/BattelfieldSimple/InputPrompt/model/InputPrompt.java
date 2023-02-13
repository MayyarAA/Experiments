package com.mayyar.temo.BattelfieldSimple.InputPrompt.model;

import com.mayyar.temo.playeraction.PlayerAction;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class InputPrompt {
    final String id;
    final List<PlayerAction> playerActions;
}
