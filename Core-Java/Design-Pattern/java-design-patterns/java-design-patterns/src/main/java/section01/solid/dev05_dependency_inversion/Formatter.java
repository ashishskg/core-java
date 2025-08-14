package section01.solid.dev05_dependency_inversion;

public interface Formatter {
	
	public String format(Message message) throws FormatException;
	
}
