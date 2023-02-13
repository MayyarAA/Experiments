package com.mayyar.temo.BattelfieldSimple.game.board.service;

import com.mayyar.temo.BattelfieldSimple.game.board.model.Board;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class BoardService implements BoardServiceInterface {

    final static int min = -1;
    final static int max = 9;

    @Override
    public Board[][] createSimpleBoard() {
        return createSimpleBoardSingleThreaded();
    }

    @Override
    public String[][] createLocationByPlayer(Board[][] simpleBoard) {
        final String[][] boardLocations = new String[simpleBoard.length][simpleBoard.length];
        final int[][] allIndexes = generateRandomShuffleOfIndexes(simpleBoard.length);
        boolean playerTurn = false;
        for(int rowIndex=0;rowIndex<allIndexes.length;rowIndex++){
            int[] row = allIndexes[rowIndex];
            for(int colIndex=0;colIndex<row.length;colIndex++){
                boardLocations[rowIndex][colIndex] = playerTurn?"1":"2";
                playerTurn = !playerTurn;
            }
        }
        return boardLocations;
    }

    private int[][] generateRandomShuffleOfIndexes(int indexLength) {
        int[][] allIndexes = new int[indexLength][indexLength];

        for (int i = 0; i < allIndexes.length; i++) {
            int[] row = allIndexes[i];
            for (int j = 0; j < row.length; j++) {
                allIndexes[i][j] = i + j;
            }
        }

        // If running on Java 6 or older, use `new Random()` on RHS here
        final Random rnd = ThreadLocalRandom.current();
        for (int[] row : allIndexes) {

            for (int i = row.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                int a = row[index];
                row[index] = row[i];
                row[i] = a;
            }
        }


        return allIndexes;
    }

    private Board[][] createSimpleBoardSingleThreaded() {
        final Board[][] board = new Board[2][2];
        int x = 0, y = 0;
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            final Board[] row = board[rowIndex];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
                final Board column = Board.builder()
                        .x(rowIndex)
                        .y(colIndex)
                        .point(randomNum)
                        .build();
                row[colIndex] = column;
            }
        }
        return board;

    }
}
