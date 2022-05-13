package kr.co.clozet.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Component @Data @Lazy
public class Vector <T> {
    private final ArrayList<T> list;

    public Vector() {
        this.list = new ArrayList<T>();
    }
    public void add(T t){ list.add(t); }
    public void remove(T t){ list.remove(t);}
    public void set(int i, T t) { list.set(i, t);}
    public void get(int i) {list.get(i);}
    public int count() {return list.size();}
    public void clear() {list.clear();}


}

