package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Bomb extends GamePiece {
	private char symbol;
	private int location;
	
	public Bomb(char symbol, int location) {
		super(symbol, location);
		this.symbol = 'x';
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
	}
	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == this.location) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	
}
