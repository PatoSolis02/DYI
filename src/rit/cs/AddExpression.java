package rit.cs;

/**
 * A AddExpression is an expression that can be evaluated and emitted. Since
 * this is doing the addition, it should evaluate to a sum of two numbers and
 * emit a formatted string with the two numbers and the operation done on them,
 * enclosed in parentheses.
 *
 * @author Patricio Solis
 */
public class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    /**
     * Constructor for AddExpression
     * @param left Expression
     * @param right Expression
     */
    public AddExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return (left.evaluate() + right.evaluate());
    }

    @Override
    public String emit() {
        return "(" + left.emit() + " + " + right.emit() + ")";
    }
}
