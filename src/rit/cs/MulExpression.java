package rit.cs;

/**
 * A MulExpression is an expression that can be evaluated and emitted. Since
 * this is doing the multiplication, it should evaluate to a product of two
 * numbers and emit a formatted string with the two numbers and the operation
 * done on them, enclosed in parentheses.
 *
 * @author Patricio Solis
 */
public class MulExpression implements Expression {
    private Expression left;
    private Expression right;

    /**
     * Constructor for MulExpression
     * @param left Expression
     * @param right Expression
     */
    public MulExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return (left.evaluate() * right.evaluate());
    }

    @Override
    public String emit() {
        return "(" + left.emit() + " * " + right.emit() + ")";
    }
}
