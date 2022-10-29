package Sudoku.ProblemDomain;

import Sudoku.ComputationLogic.SudokuUtilities;
import Sudoku.Constants.GameState;

public class SudokuGame {
    private final GameState gameState;
    private final int[][] gridState;

    public static final int GRID_BOUNDARY = 9;

    public SudokuGame (GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;

    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }

}
