package levelPieces;

import gameEngine.Drawable;

public class Bush implements Drawable{
	char symbol = '*';
	int location;
	
	public Bush(int loc) {
		location = loc;
	}
	
	@Override
	public void draw() {
		System.out.print(symbol);
	}

}
