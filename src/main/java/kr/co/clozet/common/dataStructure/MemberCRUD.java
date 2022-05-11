package kr.co.clozet.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// 알고리즘 테스트에서는 이렇게 one page로 작성함.
public class MemberCRUD {
    public static void main(String[] args) {
        MemberService service = new MemberServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("0.Exit 1. save 2. update 3.remove 4. findById " +
                    "5. findByName 6. findAll 7.count 8.existsById");
            switch (scanner.next()){
                case "0": return;
                case "1":
                    Member m = new Member.Builder("hong")
                            .email("hong.test.com")
                            .password("1")
                            .name("hong-ki")
                            .phone("010-9999-9999")
                            .profileImg("hong.jpg")
                            .build();
                    service.save(m);
                    Member s = new Member.Builder("hyuck")
                            .email("hyuck.test.com")
                            .password("2")
                            .name("hyuck")
                            .phone("010-9999-9992")
                            .profileImg("hong2.jpg")
                            .build();
                    service.save(s);
                    Member a = new Member.Builder("ddd")
                            .email("ddd.test.com")
                            .password("3")
                            .name("dsd")
                            .phone("010-9999-9991")
                            .profileImg("hong3.jpg")
                            .build();
                    service.save(a);
                    break;
                case "2":
                    break;
                case "3":
                    Member temp = new Member();
                    temp.setUserId("hong");
                    service.remove(temp);
                    break;
                case "4":
                    String result = (service.findById("hong") == null) ? "해당 계정이 없습니다." : String.format("info",service.findById("hong"));
                    System.out.println(result);
                    break;
                case "5": break;
                case "6": break;
                case "7": System.out.println("총 회원수: "+service.count()+" 명");
                    break;
                case "8": break;
                default: break;
            }
        }
    }
    @Data @NoArgsConstructor
    static class Member{
        protected String userId, name, password, profileImg, phone, email;

        public Member(Builder builder){
            this.userId = builder.userId;
            this.name = builder.name;
            this.password = builder.password;
            this.profileImg = builder.profileImg;
            this.phone = builder.phone;
            this.email = builder.email;
        }
        static class Builder{
            private String userId, name, password, profileImg, phone, email;
            public Builder (String userId){this.userId = userId;}
            public Builder name(String name){this.name = name; return this;}
            public Builder password(String password) {this.password = password; return this;}
            public Builder profileImg(String profileImg) {this.profileImg = profileImg; return this;}
            public Builder phone(String phone) {this.phone = phone; return this;}
            public Builder email(String email) {this.email = email; return this;}
            Member build(){return new Member(this);}
        }
        @Override public String toString(){
            return String.format("[user spec] userId: %s, name: %s, password: %s, profileImg: %s, phone: %s, email: %s",
                    userId, name, password, profileImg, phone, email);
        }
    }
    interface MemberService{
        void save(Member member);
        void update(Member member);
        void remove(Member member);
        Member findById(String id);
        List<Member> findByName(String name);
        List<Member> findAll();
        int count();
        boolean existsById(String id);

    }

    static class MemberServiceImpl implements MemberService{
        Map<String, Member> map;
        MemberServiceImpl(){
            this.map = new HashMap<>();
        }


        @Override
        public void save(Member member) {
            map.put(member.getUserId(), member);
        }

        @Override
        public void update(Member member) {
            map.replace(member.getUserId(), member);
        }

        @Override
        public void remove(Member member) {
            map.remove(member.getUserId());
        }

        @Override
        public Member findById(String id) {
            return map.get(id);
        }

        @Override
        public List<Member> findByName(String name) {
            return null;
        }

        @Override
        public List<Member> findAll() {
            //return (List<Member>)map.forEach();
            return null;
        }

        @Override
        public int count() {
            return map.size();
        }

        @Override
        public boolean existsById(String id) {
            return map.containsKey(id);
        }
    }
}
