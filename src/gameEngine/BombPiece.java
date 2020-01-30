package gameEngine;

import levelPieces.GamePiece;

public class BombPiece extends GamePiece {
	private char symbol;
	private int location;
	
	public BombPiece(char symbol, int location) {
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
		return null;
	}
	
}
