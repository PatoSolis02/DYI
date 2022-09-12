package rit.stu;

import rit.cs.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DYI {

    public DYI(){
    }

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

    public static void main(String[] args) {
        new DYI().processLoop();
    }
}