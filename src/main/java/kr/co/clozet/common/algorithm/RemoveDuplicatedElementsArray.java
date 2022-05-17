package kr.co.clozet.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatedElementsArray {
    @Builder
    @NoArgsConstructor
    @Getter
    @AllArgsConstructor
    public static class Solution {
        private List<Integer> list;

        @Override
        public String toString() {
            return String.format("답: ");
        }
    }

    @FunctionalInterface private interface SolutionService {
        List<Integer> solution(List<Integer> list);
    }

    @Test
    void TestSolution() {
        List<Integer> list = Arrays.asList(5, 10, 9, 27, 2, 8, 10, 4, 27, 1);
        SolutionService sol = e -> e.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(sol.solution(list));
    }
}
