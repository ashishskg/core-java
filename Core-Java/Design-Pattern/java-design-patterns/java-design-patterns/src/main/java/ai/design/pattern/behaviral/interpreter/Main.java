package ai.design.pattern.behaviral.interpreter;

// Abstract expression interface
interface Expression {
    int interpret();
}

// Concrete expression class for a number
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public int interpret() {
        return number;
    }
}

// Concrete expression class for addition
class AdditionExpression implements Expression {
    private Expression left;
    private Expression right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

// Concrete expression class for subtraction
class SubtractionExpression implements Expression {
    private Expression left;
    private Expression right;

    public SubtractionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

// Concrete expression class for multiplication
class MultiplicationExpression implements Expression {
    private Expression left;
    private Expression right;

    public MultiplicationExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() * right.interpret();
    }
}

// Concrete expression class for division
class DivisionExpression implements Expression {
    private Expression left;
    private Expression right;

    public DivisionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() / right.interpret();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create expression: 5 + (4 - 2)
        Expression expression = new AdditionExpression(
                new NumberExpression(5),
                new SubtractionExpression(
                        new NumberExpression(4),
                        new NumberExpression(2)
                )
        );

        // Evaluate the expression
        int result = expression.interpret();
        System.out.println("Result: " + result); // Output: Result: 7
    }
}
