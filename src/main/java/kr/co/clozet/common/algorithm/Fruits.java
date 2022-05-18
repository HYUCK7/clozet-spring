package kr.co.clozet.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

public class Fruits {
    @Builder@Getter@NoArgsConstructor@AllArgsConstructor
    public static class Solution{
        @Override
        public String toString() {
            return String.format("total: %d, apple :%d, grape: %d, orange: %d",
                    total, apple, grape, orange);
        }

        private int total, apple, grape, orange;
    }
    @FunctionalInterface private interface SolutionService{
        Solution solution(Solution solution);
    }
    @Test
    void testSolution(){

    }
}
