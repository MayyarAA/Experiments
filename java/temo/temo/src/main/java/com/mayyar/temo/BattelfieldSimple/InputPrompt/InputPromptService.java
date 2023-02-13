package com.mayyar.temo.BattelfieldSimple.InputPrompt;

import com.mayyar.temo.BattelfieldSimple.InputPrompt.model.InputPrompt;
import com.mayyar.temo.BattelfieldSimple.InputPrompt.model.InputPromptResponse;
import com.mayyar.temo.BattelfieldSimple.game.board.model.Board;
import com.mayyar.temo.BattelfieldSimple.game.board.service.BoardService;
import com.mayyar.temo.BattelfieldSimple.game.model.GameSnapshot;
import com.mayyar.temo.playeraction.PlayerAction;
import lombok.Builder;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Builder
@Slf4j
public class InputPromptService {
    private final BoardService boardService;
    public InputPromptService(final BoardService boardService){
        this.boardService = boardService;
    }

    public InputPromptResponse createGame(@NonNull String gameId, @NonNull InputPrompt inputPrompt) {
        log.info("Creating game {}", gameId);
        final InputPromptResponse inputPromptResponse = InputPromptResponse.builder()
                .response("Game Started")
                .gameSnapshot(generateGameSnapshot(inputPrompt))
                .build();
        return inputPromptResponse;
    }

    private GameSnapshot generateGameSnapshot(@NonNull final InputPrompt inputPrompt) {
        final List<String> players = parseAllPlayers(inputPrompt.getPlayerActions());
        final Board[][] simpleBoard = boardService.createSimpleBoard();
        final String[][] locationByPlayer  = boardService.createLocationByPlayer(simpleBoard);
        final GameSnapshot gameSnapshot = GameSnapshot.builder()
                .locationsByPlayer(locationByPlayer)
                .players(players)
                .board(simpleBoard)
                .build();
        return gameSnapshot;
    }

    private List<String> parseAllPlayers(List<PlayerAction> playerActions) {
        final List<String> players  = playerActions.stream()
                .map(playerAction -> playerAction.getPlayerId())
                .collect(Collectors.toList());
        return players;
    }
}
