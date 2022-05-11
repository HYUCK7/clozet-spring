package kr.co.clozet.common.dataStructure;

import kr.co.clozet.common.lambda.Lambda;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppleList {
    //color price(int) origin
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AppleService service = new AppleServiceImpl();
        while (true){
            System.out.println("0.Exit 1. save 2. update 3.remove 4. findById " +
                    "5. findByName 6. findAll 7.count 8.existsById");
            switch (s.next()){
                case "0": return;
                case "1":
                    Apple yd = new Apple.Builder()
                            .origin("영동")
                            .color("red")
                            .price(10000)
                            .build();
                    service.save(yd);
                    Apple yd2 = new Apple.Builder()
                            .origin("영동")
                            .color("blue")
                            .price(10005)
                            .build();
                    service.save(yd2);
                    Apple pg = new Apple.Builder()
                            .origin("풍기")
                            .color("red")
                            .price(20005)
                            .build();
                    service.save(pg);
                    break;
                case "2":
                    break;
                case "3":

                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("5.findByOrigin");
                    System.out.println(service.findByOrigin("영동"));
                    break;
                case "6":
                    System.out.println("6.findAll: \n" + service.findAll());
                    break;
                case "7": System.out.println("총 사과 수: "+service.count()+" 개");
                    break;
                case "8":
                    break;
                case "9": service.clear();
                case "10":
                    System.out.println("사과 가격은" + Lambda.integer("1000"));
                    break;
                default: break;
            }
        }
    }
    @Data
    static public class Apple{
        protected String color, origin;
        protected int price;

        public Apple(Builder builder){
            this.color = builder.color;
            this.origin = builder.origin;
            this.price = builder.price;
    }
        @NoArgsConstructor
        static public class Builder{
            private String color, origin;
            private int price;
            public Builder color(String color){this.color = color; return this;}
            public Builder origin(String origin) {this.origin = origin; return this;}
            public Builder price(int price) {this.price = price; return this;}
            public Apple build(){return new Apple(this);}
    }
        @Override public String toString(){
            return String.format("[사과 스펙] origin: %s, color: %s, price: %d",
                    origin, color, price);
        }
    }
    interface AppleService{
        boolean save(Apple apple);
        Apple update(int i, Apple apple);
        boolean remove(Apple apple);
        int count();
        Apple findById(int i);
        List<Apple> findByOrigin(String origin);
        List<Apple> findByColor(String color);
        List<Apple> findAll();
        void clear();
    }
    static class AppleServiceImpl implements AppleService{
        private final List<Apple> list;

        public AppleServiceImpl() {
            this.list = new ArrayList<>();
        }
        @Override
        public boolean save(Apple apple) {
            return list.add(apple);
        }
        @Override
        public Apple update(int i, Apple apple) {
            return list.set(i, apple);
        }
        @Override
        public boolean remove(Apple apple) {
            return list.remove(apple);
        }
        @Override
        public int count() {
            return list.size();
        }

        @Override
        public Apple findById(int i) {
            return list.get(i);
        }

        @Override
        public List<Apple> findByOrigin(String origin) {
            return list.stream().filter(apple -> apple.getOrigin().equals(origin)).collect(Collectors.toList());
        }

        @Override
        public List<Apple> findByColor(String color) {
            return list.stream().filter(apple -> apple.getColor().equals(color)).collect(Collectors.toList());
        }

        @Override
        public List<Apple> findAll() {
            return list;
        }

        @Override
        public void clear() {
            list.clear();
        }
    }
}

