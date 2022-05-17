package kr.co.clozet.common.streams;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonStream {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Person {
        private String name, ssn;

        private boolean slice(String ssnGenderPos) {
            return ssn.substring(7, 8).equals(ssnGenderPos);
        }

        @Override
        public String toString() {
            String gender = (slice("1") || slice("3")) ? "남자" : "여자";
            int age = Integer.parseInt(ssn.substring(7, 8)) == 3 || Integer.parseInt(ssn.substring(7, 8)) == 4
                    ? 22 - Integer.parseInt(ssn.substring(0, 2))
                    : 122 - Integer.parseInt(ssn.substring(0, 2));
            return String.format("이름: %s, 성별: %s, 나이:%s", name, gender, age);
        }
    }

    @FunctionalInterface interface PersonService {
        Person search(List<Person> persons);
    }
        @Test
        void personStreamTest() {
            List<Person> arr = Arrays.asList(
                    Person.builder().name("홍길동").ssn("900120-1").build(),
                    Person.builder().name("김유신").ssn("970620-1").build(),
                    Person.builder().name("유관순").ssn("040920-4").build()
            );
            PersonService ps = persons -> persons
                    .stream()
                    .filter(e -> e.getName().equals("홍길동"))
                    .collect(Collectors.toList()).get(0);
            System.out.println(ps.search(arr));
        }
    }

