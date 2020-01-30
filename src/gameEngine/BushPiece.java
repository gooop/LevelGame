package gameEngine;

public class BushPiece implements Drawable{
	char symbol = 'B';
	int location;
	
	public BushPiece(int loc) {
		location = loc;
	}
	
	@Override
	public void draw() {
		System.out.print(symbol);
	}

}
