package kr.co.clozet.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Scanner;

public class MemberCRUD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("0.Exit 1. register 2. findById 3. findByName 4. memberList 5.Count 6. Update 7.Remove");
            switch (scanner.next()){
                case "0": return;
                case "1": break;
                case "2": break;
                case "3": break;
                case "4": break;
                case "5": break;
                case "6": break;
                case "7": break;
                default: break;
            }
        }
    }
    @Data @AllArgsConstructor
    class Member{
        protected String userId, name, password, profileImg, phone, email;
        @Override public String toString(){
            return String.format("[user spec] userId: %s, name: %s, password: %s, profileImg: %s, phone: %s, email: %s",
                    userId, name, password, profileImg, phone, email);
        }
    }
    @RequiredArgsConstructor
    class MemberService{
        private final Map<String, Member> map;
        void register(Member member) {map.put(member.getUserId(), member);}
    }
}
