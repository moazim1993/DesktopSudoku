package Sudoku.BuildLogic;

import Sudoku.ComputationLogic.GameLogic;
import Sudoku.Persistence.LocalStorageImpl;
import Sudoku.ProblemDomain.SudokuGame;
import Sudoku.ProblemDomain.IStorage;
import Sudoku.UserInterface.IUserInterfaceContract;
import Sudoku.UserInterface.Logic.ControlLogic;

import java.awt.image.ImagingOpException;
import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();
        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
