package levelPieces;

import java.util.ArrayList;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelEngine {
	private Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
	private ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
	private int playerStartLoc = (GameEngine.BOARD_SIZE - 1) / 2;
	private Random random = new Random();
	private int randomBombInt;
	
	
	public void createLevel(int levelNum) {
		if (levelNum == 1) {
			generateLevel1();
		} else if (levelNum == 2) {
			generateLevel2();
		}
		
	}
	
	private void generateLevel1() {
		// Bush:
		// Sets the bush to space 1 no matter how big the board is
		gameBoard[GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 1)] = new Bush(GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 1));
		
		// Knight:
		// Sets knight to be in the first fifth edge of the board
		Knight enemyOne = new Knight('E', GameEngine.BOARD_SIZE / 5);
		gameBoard[GameEngine.BOARD_SIZE / 5] = enemyOne;
		movingPieces.add(enemyOne);
		interactingPieces.add(enemyOne);
		
		// Bomber:
		// Sets the bomber to the last 4/5th of the board
		Bomber bomberOne = new Bomber('B', GameEngine.BOARD_SIZE - 3); 
		gameBoard[GameEngine.BOARD_SIZE - 3] = bomberOne;
		movingPieces.add(bomberOne);
		interactingPieces.add(bomberOne);
		
		// Bombs:
		// Sets the bomb to be next to the bomber
		Bomb bombOne = new Bomb('x', GameEngine.BOARD_SIZE - 4); 
		gameBoard[GameEngine.BOARD_SIZE - 4] = bombOne;
		interactingPieces.add(bombOne);
		
		// Archer:
		// Sets archer to space 2 no matter how big the board is
		Archer archerOne = new Archer('A', GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 2));
		gameBoard[GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 2)] = archerOne;
		interactingPieces.add(archerOne);
		
		// Gold: Declared last as to always exist on the board
		// Sets the gold to the edge of the board
		Gold goldOne = new Gold('G', GameEngine.BOARD_SIZE - 2);
		// Sets the gold to the edge of the board - 4
		Gold goldTwo = new Gold('G', GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 3));
		gameBoard[GameEngine.BOARD_SIZE - 2] = goldOne;
		gameBoard[GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 3)] = goldTwo;
		interactingPieces.add(goldOne);
		interactingPieces.add(goldTwo);
}
	
	private void generateLevel2() {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Bush:
		// Sets the bush to two spaces from the edge no matter how big the board is
		gameBoard[GameEngine.BOARD_SIZE - 2] = new Bush(GameEngine.BOARD_SIZE - 2);
		
		// Knight:
		// Sets knight to be in the first quarter edge of the board
		Knight enemyTwo = new Knight('E', GameEngine.BOARD_SIZE / 4);
		gameBoard[GameEngine.BOARD_SIZE / 4] = enemyTwo;
		movingPieces.add(enemyTwo);
		interactingPieces.add(enemyTwo);
		
		// Bomber:
		// Sets the bomber to the last 3/4th of the board
		// Note that bombs (another interactable piece) are placed by the bomber and
		// not initialized here.
		Bomber bomberTwo = new Bomber('B', GameEngine.BOARD_SIZE - 6); 
		gameBoard[GameEngine.BOARD_SIZE - 6] = bomberTwo;
		movingPieces.add(bomberTwo); 	   // Note that bombs (another interactable piece) are placed by the bomber and
		interactingPieces.add(bomberTwo); // not initialized here.
		
		// Bombs:
		// Sets the bomb to be next to the bomber
		Bomb bombOne = new Bomb('x', GameEngine.BOARD_SIZE - 7); 
		gameBoard[GameEngine.BOARD_SIZE - 7] = bombOne;
		interactingPieces.add(bombOne);
		
		// Archer:
		// Sets archer to space 3 no matter how big the board is
		Archer archerTwo = new Archer('A', GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 2));
		gameBoard[GameEngine.BOARD_SIZE - (GameEngine.BOARD_SIZE - 3)] = archerTwo;
		interactingPieces.add(archerTwo);
		// Gold: Declared last as to always exist on the board
		// Sets the gold to the edge of the board - 1
		Gold goldThree = new Gold('G', GameEngine.BOARD_SIZE - 2);
		// Sets the gold to the edge of the board - 3
		Gold goldFour = new Gold('G', GameEngine.BOARD_SIZE - 4);
		gameBoard[GameEngine.BOARD_SIZE - 2] = goldThree;
		gameBoard[GameEngine.BOARD_SIZE - 4] = goldFour;
		interactingPieces.add(goldThree);
		interactingPieces.add(goldFour);
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
