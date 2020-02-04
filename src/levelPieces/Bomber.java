package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;

import java.util.Random;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Bomber extends GamePiece implements Moveable{
	private char symbol;
	private int location;
	Random randomBombGeneratoRandom = new Random();
	int randomBombInt; // Initializes random variable for the Bomber
	
	public Bomber(char symbol, int location) {
		super(symbol, location);
		this.symbol = 'B';
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[location] = null; 
		
		// Whether or not the Bomber drops a bomb is being handled in move in order to streamline its integration with GameEngine
		randomBombInt = randomBombGeneratoRandom.nextInt(100);
		if (true /*randomBombInt < 24*/) { // There's a 25% chance for the bomber to drop a bomb
			gameBoard[location] = new levelPieces.Bomber('x', location);
		}
		
		// The Bomber will move two steps in a row up and down the level
		if (randomBombInt < 50 && location + 2 < GameEngine.BOARD_SIZE) { // if the random bomb in is small and Bomber has room to move
			location += 2;
		} else if (randomBombInt < 50 && location + 2 >= GameEngine.BOARD_SIZE) { // small + no room to move
			location -= 2;
		} else if (randomBombInt > 50 && location - 2 > 0) { // large and room to move
			location -= 2;
		} else {
			location += 2; // large and no room to move
		}
		gameBoard[location] = this; 
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == this.location) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
