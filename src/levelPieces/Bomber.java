package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import java.util.Random;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Bomber extends GamePiece implements Moveable{
	private char symbol;
	private int location;
	Random randomMove = new Random();
	int randomMoveInt; // Initializes random variable for the Bomber
	
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
		randomMoveInt = randomMove.nextInt(100);
		// The Bomber will move two steps in a row up and down the level
		if (randomMoveInt < 50 && location + 2 < GameEngine.BOARD_SIZE) { // if the random bomb in is small and Bomber has room to move
			location += 2;
		} else if (randomMoveInt < 50 && location + 2 >= GameEngine.BOARD_SIZE) { // small + no room to move
			location -= 2;
		} else if (randomMoveInt > 50 && location - 2 > 0) { // large and room to move
			location -= 2;
		} else {
			location += 2; // large and no room to move
		}
		gameBoard[location] = this; 
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == this.location) {
			if (this.symbol == ' ') { // if the object has already been interacted with
				return InteractionResult.NONE;
			}
			this.symbol = ' ';
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
