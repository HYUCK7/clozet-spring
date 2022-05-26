package kr.co.clozet.common.lambda;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class Lambda {
    @Test
    void myLambda() {
        System.out.println(Lambda.integer("900"));
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
        System.out.println(random2(1,6));
    }

    // 전달값 많으면 스프레드 연산자로
    public static int integer(String a){ //interger.parseint()
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(a);
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
    //int player = (int)(Math.random()*6)+1, int p = random(1,6)
    public static double random(){
        Supplier<Double> s = Math::random;
        return (s.get() * 6) +1;
    }
    public static Integer random2(int min, int max){
        BiFunction<Integer, Integer, Integer> s = (integer, integer2) -> (int)(Math.random() * integer) + integer2;
        return s.apply(min, max);

    }
    public static File makeFile(String a){
        Function<String, File> p = File::new;
        return p.apply(a);
    }
    public static long longParse(String s){
        Function<String, Long> f = Long::parseLong;
        return f.apply(s);
    }
    public static Object date() {
        Supplier<Object> s = LocalDate::now;
        return s.get();
    }
}
