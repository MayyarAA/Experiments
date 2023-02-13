package com.mayyar.temo.BattelfieldSimple.game.model;


import com.mayyar.temo.BattelfieldSimple.game.board.model.Board;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class GameSnapshot {
    final List<String> players;
    final Board[][] board;
    final String[][] locationsByPlayer;
}
