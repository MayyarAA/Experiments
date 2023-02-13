package com.mayyar.temo.playeraction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class PlayerAction {
    final String playerId;
    final int x;
    final int y;
}
