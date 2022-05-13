package kr.co.clozet.common.lambda;

import java.util.function.Function;

public class MyLambda {
    // 기존 존재 만들 필요 x
    @FunctionalInterface interface MyFunction { int execute(String arg);}
    @FunctionalInterface interface MyConsumer { void execute(String arg); }
    @FunctionalInterface interface MySupplier { int execute();}
    @FunctionalInterface interface MyPredicate{ boolean execute (String arg);}
    // 커스텀
    @FunctionalInterface interface MyUnaryOp {int operator(Integer a);}
    @FunctionalInterface interface LengthOfString {int execute(String arg);}
}
