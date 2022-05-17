package kr.co.clozet.common.algorithm;

import com.jayway.jsonpath.internal.function.numeric.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MaxMin {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
        private int[] arr;
        private int max, min, elem;

        @Override
        public String toString() {
            return String.format("최소값: %d , 최대값: %d", min, max);
        }
    }

    @FunctionalInterface private interface SolutionService {
        public String solution (List<Integer> list);
    }

    @Test
    void testSolution(){
        List<Integer> list = Arrays.asList(3, 1, 9, 5, 10);
        SolutionService sol = l -> "";
        System.out.println(sol.solution(list));
    }
}
