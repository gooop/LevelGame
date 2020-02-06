package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Knight;

public class TestInteractions {
	int playerLoc = (GameEngine.BOARD_SIZE - 1) / 2; // Middle of board
	
	@Test
	public void testArcherInteract() {
		
		fail("Not yet implemented");
	}
	
	@Test
	public void testKnightInteract() {
		Knight [] gameBoard = new Knight[GameEngine.BOARD_SIZE];
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			gameBoard[i] = new Knight('E', i);
			if (i != playerLoc) {
				assertEquals(InteractionResult.NONE, gameBoard[i].interact(gameBoard, playerLoc));
			}
		}
		fail("Not yet implemented");
	}
	
	@Test
	public void testBomberInteract() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBombInteract() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGoldInteract() {
		fail("Not yet implemented");
	}

}
