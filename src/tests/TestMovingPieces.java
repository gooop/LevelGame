package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Player;
import levelPieces.Bomber;
import levelPieces.Knight;

public class TestMovingPieces {

	@Test
	public void testKnightMove() {
		int playerLoc = (GameEngine.BOARD_SIZE - 1) / 2; // Middle of board
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Knight leftKnight = new Knight('E', playerLoc - 3);
		Knight rightKnight = new Knight('E', playerLoc + 3);
		// Player is between both knights
		Player player = new Player(playerLoc);
		gameBoard[playerLoc] = player;
		gameBoard[playerLoc - 3] = leftKnight;
		gameBoard[playerLoc + 3] = rightKnight;
		// Instantiated location
		assertEquals(playerLoc - 3, leftKnight.getLocation());
		assertEquals(playerLoc + 3, rightKnight.getLocation());
		// Moved once, toward player
		leftKnight.move(gameBoard, playerLoc);
		rightKnight.move(gameBoard, playerLoc);
		assertEquals(playerLoc - 2, leftKnight.getLocation());
		assertEquals(playerLoc + 2, rightKnight.getLocation());
		// Moved twice, toward player
		leftKnight.move(gameBoard, playerLoc);
		rightKnight.move(gameBoard, playerLoc);
		assertEquals(playerLoc - 1, leftKnight.getLocation());
		assertEquals(playerLoc + 1, rightKnight.getLocation());
		// Moved three times, doesn't move
		leftKnight.move(gameBoard, playerLoc);
		rightKnight.move(gameBoard, playerLoc);
		assertEquals(playerLoc - 1, leftKnight.getLocation());
		assertEquals(playerLoc + 1, rightKnight.getLocation());
	}
	
	@Test
	public void testBomberMove() {
		// Note: Random jumps
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Bomber bomber = new Bomber('B', 0);
		gameBoard[0] = bomber;
		int [] counts = new int[GameEngine.BOARD_SIZE];
		if (bomber.getLocation() % 2 != 0) {
			fail("Invalid square selected");
		}
		for (int i = 0; i < GameEngine.BOARD_SIZE * 5; i++) {
			bomber.move(gameBoard, 0);
			counts[bomber.getLocation()] += 1;
		}
		for (int i = 0; i < GameEngine.BOARD_SIZE; i += 2) {
			assert(counts[i] > 1);
		}
	}


}
