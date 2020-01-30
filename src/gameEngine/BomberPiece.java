package gameEngine;

import levelPieces.GamePiece;

public class BomberPiece extends GamePiece implements Moveable{
	private char symbol;
	private int location;
	
	public BomberPiece(char symbol, int location) {
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
		// TODO add a rng for if it drops a bomb
		
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == this.location) {
			return InteractionResult.HIT;
		}
		return null;
	}

}
