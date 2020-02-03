package gameEngine;

import levelPieces.GamePiece;

public class GoldPiece extends GamePiece {
	private char symbol;
	private int location;
	
	public GoldPiece(char symbol, int location) {
		super(symbol, location);
		this.symbol = 'G';
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.print(symbol);
	}
	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (location == playerLocation) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}

}
