package gameEngine;

import levelPieces.GamePiece;

public class EnemyPiece extends GamePiece implements Moveable, Drawable {
	private char symbol;
	private int location;
	
	public EnemyPiece(char symbol, int location) {
		super(symbol, location);
		this.symbol = 'E';
		this.location = location;
	}
	
	@Override
	public void draw() {
		System.out.print(symbol);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		location++;
		
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if (playerLocation == this.location) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

}
