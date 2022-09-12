package rit.stu;

import rit.cs.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The main class for Derp Your Interpreter. The expression to be evaluated
 * by the interpreter are provided by the user through the command window
 * and must be provided in prefix form as the program converts the prefix
 * expression into a tree. Can only take in basic mathematical operators
 * (multiplication, division, subtraction, addition, and modulo).
 *
 * @author Patricio Solis
 */
public class DYI {

    /**
     * Constructor for DYI
     */
    public DYI(){
    }

    /**
     * Parses an ArrayList<String> that has been created from the users
     * input of a prefix expression. Correctly parses through the ArrayList
     * and recognizes operators to make the correct Expression to be evaluated
     * and emitted accurately. Recursively calls itself until the end of the
     * ArrayList has been reached.
     *
     * @param tokens ArrayList<Strings> containing the prefix expression from user
     * @return an accurate Expression
     */
    public Expression parse(ArrayList<String> tokens){
        var tok = tokens.remove(0);
        return switch (tok) {
            case "+" -> new AddExpression(parse(tokens), parse(tokens));
            case "-" -> new SubExpression(parse(tokens), parse(tokens));
            case "*" -> new MulExpression(parse(tokens), parse(tokens));
            case "/" -> new DivExpression(parse(tokens), parse(tokens));
            case "%" -> new ModExpression(parse(tokens), parse(tokens));
            default -> new IntExpression(Integer.parseInt(tok));
        };
    }

    /**
     * Runs the program until the user wishes to quit inputting prefix
     * expressions to be evaluated. This function is also responsible
     * for taking in an input and for outputting the expression in the
     * correct format and order of operations and for outputting the
     * correct evaluation of the expression.
     */
    public void processLoop(){
        System.out.println("Derp Your Interpreter!");
        System.out.print(">");
        Scanner prefix = new Scanner(System.in);
        String userInput = prefix.nextLine();
        while(!userInput.equals("quit")) {
            String[] str = userInput.split(" ");
            ArrayList<String> expArray = new ArrayList<>(Arrays.asList(str));
            Expression parsedArray = parse(expArray);
            System.out.println("Emit: " + parsedArray.emit());
            System.out.println("Evaluate: " + parsedArray.evaluate());
            System.out.print(">");
            userInput = prefix.nextLine();
        }
        System.out.println("Goodbye!");
    }

    /**
     * runs the program
     *
     * @param args command line
     */
    public static void main(String[] args) {
        new DYI().processLoop(); // creates instance of DYI, so no other static functions
    }
}