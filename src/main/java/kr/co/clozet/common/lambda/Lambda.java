package kr.co.clozet.common.lambda;

import static kr.co.clozet.common.dataStructure.AppleList.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    public static void main(String[] args) {
        //System.out.println(Lambda.integer("900"));
        //System.out.println(string(900));
        //System.out.println(string(900));
        //System.out.println(string(new Apple.Builder().origin("영동").color("RED").price(3000).build()));
        //System.out.println(string(
        //Arrays.asList(new Apple.Builder().origin("영동").color("RED").price(3000).build(),
        //new Apple.Builder().origin("영동").color("RED").price(3000).build()
        //))
        //);
        //System.out.println(equals("홍길동", "홍길동"));
        System.out.println(array(8));
    }
    // 전달값 많으면 스프레드 연산자로
    public static int integer(String arg){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(arg);
    }

    public static String string(Object o){
        //String s = String.valueOf(object);
        Function<Object, String> f= String::valueOf;
        return f.apply(o);
    }
    public static boolean equals(String s1, String s2){
        BiPredicate<String, String> p= String::equals;
        return p.test(s1, s2);
    }
    // int [] arr = new int[8];
    public static int[] array(int arg){
        Function<Integer, int[]> f = int[] :: new;
        return f.apply(arg);
    }
}
