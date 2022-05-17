package kr.co.clozet.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrimeNumber {
    @Builder @Getter @NoArgsConstructor @AllArgsConstructor
    public static class Solution {
        private int start, end;
        private List<Integer> primes;
    }
    @FunctionalInterface private interface SolutionService{
        List<Integer> solution(int start, int end);
    }
    @Test
    void testSolution(){
        SolutionService sol = (start, end) -> null;
        System.out.println(sol.solution(1, 100));
    }
}
