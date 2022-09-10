package rit.cs;

public class IntExpression implements Expression{
    private int num;

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
