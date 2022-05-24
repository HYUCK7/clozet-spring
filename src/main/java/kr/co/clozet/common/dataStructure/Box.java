package kr.co.clozet.common.dataStructure;

import kr.co.clozet.user.domains.User;
import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component @Data @Lazy
public class Box <K,V> {
    private HashMap<K,V> map;

    public Box(){
        this.map = new HashMap<>();
    }
    // 반드시 구현할 기능
    public void put(K k , V v){map.put(k , v);}
    public void replace(K k , V v){map.replace(k ,v);}
    public void remove(K k , V v){map.remove(k , v);}
    public List<V> values(){return map.values().stream().collect(Collectors.toList());}
    public V get(String id){return map.get(id);}
    public int size(){return map.size();}
    public void clear(){map.clear();}

    // User Custom
    // 회원 아이디(테이블 키 값 = 행) 목록 요청시
    public List<V> findAllUserKeyList(){
        List<V> ls = new ArrayList<>();
        for(Map.Entry<K, V> e: map.entrySet()){
            ls.add((V)e.getValue());
        }
        return ls;
    }

    //회원 아이디 목록(테이블 키값) 요청 시
    public List<User> findAllUserList() {
    List<User> ls = new ArrayList<>();
    for(Map.Entry<K, V> e: map.entrySet()) {
        ls.add((User)e. getValue());
        }
    return ls;
    }
    //이르음으로 검색된 회원 목록 요청 시 (필터가 필요없이 리액트로 던지는 경우)
    public List<User> findByUserName(String name){
        List<User> ls = new ArrayList<>();
        for(User v: ls) { if (name.equals(v.getName())) ls.add(v); }
        return ls;
    }
    //이름으로 검색된 회원 목록 요청시(추가 필터를 통해 더 줄어든결과값이 필요한 경우)
    public Map<String , User> mapFindByUserName(String name){
        Map <String , User> map = new HashMap<>();
        for (Map.Entry<String, User> e: map.entrySet()){
            if(name.equals(e.getValue().getName())) map.put(e.getKey(), e.getValue());
        }
        return map;
    }
}




