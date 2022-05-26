package kr.co.clozet.common.lambda;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.function.Supplier;

public class LambdaLab {
    public static void solution() {

    }

    @Test
    public void testSolution() {
        System.out.println(date());

    }

    @Test
    public static Object date() {
        Supplier<Object> s = LocalDate::now;
        return s.get();
    }
}
