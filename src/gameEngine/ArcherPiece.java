package gameEngine;

import levelPieces.GamePiece;

public class ArcherPiece extends GamePiece {
	private char symbol;
	private int location;
	
	public ArcherPiece(char symbol, int location) {
		super(symbol, location);
		this.symbol = 'A';
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (Math.abs(playerLocation - this.location) == 2) {
			return InteractionResult.KILL;
		}
		return null;
	}
}
