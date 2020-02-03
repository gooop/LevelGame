package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Gold extends GamePiece {
	private char symbol;
	private int location;
	
	public Gold(char symbol, int location) {
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
