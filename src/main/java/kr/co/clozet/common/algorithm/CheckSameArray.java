package kr.co.clozet.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CheckSameArray {
    @Builder @Getter@AllArgsConstructor@NoArgsConstructor
    public static class Solution{
        private List<Integer> list;
        private boolean result;

        @Override
        public String toString() {
            return String.format("A배열과 B배열은 %s 배열입니다.", result);
        }
    }
    @FunctionalInterface private interface SolutionService{
       Boolean solution (Solution list, Solution list2);
    }
    @Test
    void testSolution(){
        List<Solution> list = Arrays.asList(
                Solution.builder().list(Arrays.asList(1,3,2)).build(),
                Solution.builder().list(Arrays.asList(2,3,1)).build()
        );
        SolutionService sol = (a, b) -> a.getList().containsAll(b.getList());
        System.out.println(sol.solution(list.get(0), list.get(1)));
    }

}
