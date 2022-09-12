package rit.cs;

/**
 * An expression is a mathematical function
 *
 * @author Patricio Solis
 */
public interface Expression {
    /**
     * Evaluates mathematical expression with appropriate mathematical operator
     * and returns the result
     *
     * @return result of mathematical operation (in this case could be an Expression or int)
     */
    public int evaluate();

    /**
     * The mathematical expression represented as a formatted string
     *
     * @return string, mathematical expression
     */
    public String emit();

}
