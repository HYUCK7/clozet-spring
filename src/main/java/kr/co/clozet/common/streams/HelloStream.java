package kr.co.clozet.common.streams;

import lombok.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//한국어로 안녕, 영어로 Hello
public class HelloStream {
    //@Data
    @Builder // Setter 역할
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Greet {
        private String greeting, inLanguage;
        /*
        public Greet(Builder builder) {
            this.greeting = builder.greeting;
            this.inLanguage = builder.inLanguage;
        }

        @NoArgsConstructor
        static public class Builder {
            private String greeting, inLanguage;

            public Builder greeting(String greeting) {
                this.greeting = greeting;
                return this;
            }

            public Builder inLanguage(String inLanguage) {
                this.inLanguage = inLanguage;
                return this;
            }
            public Greet build() {
                return new Greet(this);
            }
            @Override public String toString(){
                return String.format("%s %s", inLanguage, greeting);
            }
        }*/
        interface GreetService {
            Set<Greet> greet(List<Greet> arr);
        }
        static class GreetServiceImpl implements GreetService{
            @Override
            public Set<Greet> greet(List<Greet> arr) {
                return arr
                        .stream()
                        .filter(e -> e.getInLanguage().equals("영어"))
                        .collect(Collectors.toSet());
            }
        }
        @Test
        void helloTest() {
            List<Greet> arr = Arrays.asList(
                    Greet.builder().inLanguage("영어").greeting("Hello").build(),
                    Greet.builder().inLanguage("한국어").greeting("안녕").build()
            );
            new GreetServiceImpl().greet(arr).forEach(System.out::print);

        }
    }
}
