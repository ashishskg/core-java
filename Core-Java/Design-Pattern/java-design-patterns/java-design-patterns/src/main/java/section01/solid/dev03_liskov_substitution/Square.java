package section01.solid.dev03_liskov_substitution;

import lombok.Data;

@Data
public class Square implements Shape {
	
	private int side;
	
	public Square(int side) {
		this.side = side;
	}

	@Override
	public int computeArea() {
		return side*side;
	}
}
