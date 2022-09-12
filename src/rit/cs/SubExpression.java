package rit.cs;

/**
 * A MulExpression is an expression that can be evaluated and emitted. Since
 * this is doing the subtraction, it should evaluate to a difference of two
 * numbers and emit a formatted string with the two numbers and the operation
 * done on them, enclosed in parentheses.
 *
 * @author Patricio Solis
 */
public class SubExpression implements Expression {
    private Expression left;
    private Expression right;

    /**
     * Constructor for SubExpression
     * @param left Expression
     * @param right Expression
     */
    public SubExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return (left.evaluate() - right.evaluate());
    }

    @Override
    public String emit() {
        return "(" + left.emit() + " - " + right.emit() + ")";
    }
}
