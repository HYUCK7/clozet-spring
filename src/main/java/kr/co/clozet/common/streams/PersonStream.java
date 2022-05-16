package kr.co.clozet.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

        @Override public String toString(){
            String gender = (ssn.substring(7,8).equals("1")||ssn.substring(7,8).equals("3"))? "남자": "여자";
            int age = Integer.parseInt(ssn.substring(7,8)) == 3 || Integer.parseInt(ssn.substring(7,8)) == 4
                    ? 22 - Integer.parseInt(ssn.substring(0,2))
                    : 122- Integer.parseInt(ssn.substring(0,2));
            return String.format("이름: %s, 성별: %s, 나이:%s", name, gender, age);
        }



        }
        interface PersonService {Person search(List<Person> arr);}
        static class PersonServiceImpl implements PersonService{
            @Override
            public Person search(List<Person> arr) {
                return arr
                        .stream()
                        .filter(e -> e.getName().equals("김유신"))
                        .collect(Collectors.toList()).get(0);
            }
    }
        @Test
        void personStreamTest(){
            List<Person> arr = Arrays.asList(
                    Person.builder().name("홍길동").ssn("900120-1").build(),
                    Person.builder().name("김유신").ssn("970620-1").build(),
                    Person.builder().name("유관순").ssn("040920-4").build()
            );
            System.out.println(new PersonServiceImpl().search(arr));
    }
}
