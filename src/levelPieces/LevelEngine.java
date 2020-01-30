package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelEngine {
	private Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;
	
	
	public void createLevel(int levelNum) {
		// TODO Auto-generated method stub
		
	}

	public Drawable[] getBoard() {
		return gameBoard;
	}

	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		return playerStartLoc;
	}

}
