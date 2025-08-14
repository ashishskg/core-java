package section07.creational.prototype;

public class Swordsman extends GameUnit {

	private String state = "attacking";

	public void attack() {
		this.state = "attacking";
	}

	@Override
	public String toString() {
		return "Swordsman "+state+" @ "+getPosition();
	}

	@Override
	protected void reset() {
		state = "idle";
	}
}
