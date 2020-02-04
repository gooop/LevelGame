package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelEngine {
	private Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
	private ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
	private int playerStartLoc = (GameEngine.BOARD_SIZE - 1) / 2;
	
	
	public void createLevel(int levelNum) {
		if (levelNum == 1) {
			generateLevel1();
		} else if (levelNum == 2) {
			generateLevel2();
		}
		
	}
	
	private void generateLevel1() {
		//Bush:
		//Sets the bush to space 1 no matter how big the board is
		gameBoard[GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 1)] = new Bush(GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 1));
		//Knight:
		//Sets knight to be in the first fifth edge of the board
		Knight e1 = new Knight('E', GameEngine.BOARD_SIZE / 5);
		gameBoard[GameEngine.BOARD_SIZE / 5] = e1;
		movingPieces.add(e1);
		interactingPieces.add(e1);
		
	}
	
	private void generateLevel2() {
		//Bush:
		//Sets the bush to space 3 no matter how big the board is
		gameBoard[GameEngine.BOARD_SIZE - 2] = new Bush(GameEngine.BOARD_SIZE - 2);
		//Bush:
		//Sets knight to be in the first quarter edge of the board
		Knight e1 = new Knight('E', GameEngine.BOARD_SIZE / 4);
		gameBoard[GameEngine.BOARD_SIZE / 4] = e1;
		movingPieces.add(e1);
		interactingPieces.add(e1);
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
