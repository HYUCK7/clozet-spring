/**
package kr.co.clozet.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Gugudan {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Solution {
        private int[][] arr;

        @FunctionalInterface
        private interface SolutionService {
            void solution();
        }

         @Test void testSolution() {
         SolutionService sol = () -> {
         for (int k = 2; k < 10; k += 4) {
         for (int i = 1; i < 10; i++) {
         for (int j = k; j < k + 4; j++) {
         System.out.print(j + "*" + i + "=" + (j * i) + "\t");
         }
         System.out.println();
         }
         System.out.println();
         }
         };
         }
    }
}
 */
