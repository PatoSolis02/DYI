package rit.stu;

import rit.cs.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DYI {

    private static Scanner prefix = new java.util.Scanner(System.in);

    public DYI(){
    }

    public static Expression parse(ArrayList<String> tokens){
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

    public static void processLoop(){
        System.out.println("Derp Your Interpreter!");
        System.out.print(">");
        String userInput = prefix.nextLine();
        while(!userInput.equals("quit")) {
            String[] str = userInput.split(" ");
            ArrayList<String> expArrayEval = new ArrayList<>(Arrays.asList(str));
            ArrayList<String> expArrayEmit = new ArrayList<>(expArrayEval);
            System.out.println("Emit: " + parse(expArrayEmit).emit());
            System.out.println("Evaluate: " + parse(expArrayEval).evaluate());
            System.out.print(">");
            userInput = prefix.nextLine();
        }
        System.out.println("Goodbye!");
    }

    public static void main(String[] args) {
        processLoop();
    }
}