package section22.behaviral.interpreter;

//Abstract expression
public interface PermissionExpression {

	boolean interpret(User user); 
}
