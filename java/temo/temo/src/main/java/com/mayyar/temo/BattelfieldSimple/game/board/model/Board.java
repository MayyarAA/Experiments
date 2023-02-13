package com.mayyar.temo.BattelfieldSimple.game.board.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Board {
    final int x;
    int y;
    int point;
}
