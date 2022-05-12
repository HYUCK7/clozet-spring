package kr.co.clozet.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component @Data @Lazy
public class Trunk<K, V> {
    private final HashMap<K, V> map;
    public Trunk(){
        this.map = new HashMap<K, V>();
    }
    public void put(K k, V v){
        map.put(k, v);
    }
    public void replace(K k, V v){
        map.replace(k, v);
    }
    public void remove(K k, V v){
        map.remove(k, v);
    }
    public V findById(K k){
        return map.get(k);
    }
    public int count(){
        return map.size();
    }
    public boolean existById(K k){
        return map.containsKey(k);
    }
}
