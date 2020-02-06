package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Knight extends GamePiece implements Moveable, Drawable {
	private char symbol;
	private int location;
	
	public Knight(char symbol, int location) {
		super(symbol, location);
		this.symbol = 'E';
		this.location = location;
	}
	
	@Override
	public void draw() {
		System.out.print(symbol);
	}

	// Moves 1 space toward player, but stays in place if player is 1 space away
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[location] = null;
		if (Math.abs(playerLocation - location) == 1) {
			// does nothing if it is close enough to the player
		} else if (playerLocation > location) {
			location++;
		} else {
			location--;
		}
		gameBoard[location] = this;
	}

	// Kills player if the player moves onto the knight's location
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == this.location) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	
	@Override
	public int getLocation() {
		return location;
	}

}
