package com.mayyar.temo.BattelfieldSimple.game.board.service;

import com.mayyar.temo.BattelfieldSimple.game.board.model.Board;

public interface BoardServiceInterface {
     Board[][] createSimpleBoard();

     String[][] createLocationByPlayer(Board[][] simpleBoard);
}
