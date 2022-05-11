package kr.co.clozet.common.lambda;

public class Calculator {
    public static void main(String... args) {
        var s= "계산기";
        System.out.println(s);
        Calculator c = new Calculator();
        System.out.println("10 + 5 = " + c.operate(10, 5, (a,b) -> a+b));
        System.out.println("10 - 5 = " + c.operate(10, 5, (a,b) -> a-b));
        System.out.println("10 x 5 = " + c.operate(10, 5, (a,b) -> a*b));
        System.out.println("10 / 5 = " + c.operate(10, 5, (a,b) -> a/b));
    }
    interface Arithmetic{
        int operation(int a, int b);
    }
    private int operate(int a, int b, Arithmetic arit){
        return arit.operation(a, b);
    }
}
