package rit.cs;

/**
 * A ModExpression is an expression that can be evaluated and emitted. Since
 * this is doing the modulo, it should evaluate to a remainder of two numbers
 * and emit a formatted string with the two numbers and the operation done on
 * them, enclosed in parentheses.
 *
 * @author Patricio Solis
 */
public class ModExpression implements Expression {
    private Expression left;
    private Expression right;

    /**
     * Constructor for ModExpression
     * @param left Expression
     * @param right Expression
     */
    public ModExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        return (left.evaluate() % right.evaluate());
    }

    @Override
    public String emit() {
        return "(" + left.emit() + " % " + right.emit() + ")";
    }
}

