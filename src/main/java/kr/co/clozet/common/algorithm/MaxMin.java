package kr.co.clozet.common.algorithm;

import com.jayway.jsonpath.internal.function.numeric.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
       Solution solution (Solution s);
    }
    @Test
    void testSolution() {
        int[] arr = {3, 1, 9, 45, 18};
        SolutionService sol = e -> {
            int min = 10;
            for (int i : e.getArr()) {
                if (i < min) min = i;
            }
            int max = 10;
            for (int i : e.getArr()) {
                if (i > max) max = i;
            }
            return Solution.builder().min(min).max(max).build();
        };
        Solution s = Solution.builder().arr(arr).build();
        System.out.println(sol.solution(s));
    }
}
