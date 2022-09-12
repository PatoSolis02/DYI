package rit.cs;

/**
 * An IntExpression is an expression that can be evaluated and emitted. Since
 * this is checking for numbers, and not doing an operation it should evaluate
 * and emit just a single value.
 *
 * @author Patricio Solis
 */
public class IntExpression implements Expression{
    private int num;

    /**
     * Constructor for IntExpression
     * @param value int, the value of the number in the expression
     */
    public IntExpression(int value){
        this.num = value;
    }

    @Override
    public int evaluate() {
        return this.num;
    }

    @Override
    public String emit() {
        return String.valueOf(this.num);
    }
}
