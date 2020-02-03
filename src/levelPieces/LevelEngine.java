package levelPieces;

import java.util.ArrayList;

import gameEngine.BushPiece;
import gameEngine.Drawable;
import gameEngine.EnemyPiece;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.Player;

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
		gameBoard[1] = new BushPiece(1);
		EnemyPiece e1 = new EnemyPiece('E', 5);
		gameBoard[5] = e1;
		movingPieces.add(e1);
		interactingPieces.add(e1);
		
	}
	
	private void generateLevel2() {
		
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
