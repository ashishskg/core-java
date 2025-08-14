package section01.solid.dev03_liskov_substitution;

import lombok.Data;

@Data
public class Rectangle implements Shape {

	private int width;
	
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int computeArea() {
		return width * height;
	}
}
