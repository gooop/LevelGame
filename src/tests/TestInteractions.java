package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.*;

public class TestInteractions {
	int playerLoc = (GameEngine.BOARD_SIZE - 1) / 2; // Middle of board
	
	@Test
	public void testArcherInteract() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			Archer archer = new Archer('A', i);
			gameBoard[i]= archer; 
			if (Math.abs(playerLoc - i) != 2) {
				assertEquals(InteractionResult.NONE, archer.interact(gameBoard, playerLoc));
			} else {
				assertEquals(InteractionResult.KILL, archer.interact(gameBoard, playerLoc));
			}
		}
	}
	
	@Test
	public void testKnightInteract() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			Knight knight = new Knight('E', i);
			gameBoard[i]= knight; 
			if (i != playerLoc) {
				assertEquals(InteractionResult.NONE, knight.interact(gameBoard, playerLoc));
			} else {
				assertEquals(InteractionResult.KILL, knight.interact(gameBoard, playerLoc));
			}
		}
	}
	
	@Test
	public void testBomberInteract() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			Bomber bomber= new Bomber('B', i);
			gameBoard[i]= bomber; 
			if (i != playerLoc) {
				assertEquals(InteractionResult.NONE, bomber.interact(gameBoard, playerLoc));
			} else {
				assertEquals(InteractionResult.HIT, bomber.interact(gameBoard, playerLoc));
			}
		}
	}
	
	@Test
	public void testBombInteract() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			Bomb bomb= new Bomb('B', i);
			gameBoard[i]= bomb; 
			if (i != playerLoc) {
				assertEquals(InteractionResult.NONE, bomb.interact(gameBoard, playerLoc));
			} else {
				assertEquals(InteractionResult.KILL, bomb.interact(gameBoard, playerLoc));
			}
		}
	}
	
	@Test
	public void testGoldInteract() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			Gold gold = new Gold('G', i);
			gameBoard[i]= gold; 
			if (i != playerLoc) {
				assertEquals(InteractionResult.NONE, gold.interact(gameBoard, playerLoc));
			} else {
				assertEquals(InteractionResult.GET_POINT, gold.interact(gameBoard, playerLoc));
			}
		}
	}

}
