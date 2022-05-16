package kr.co.clozet.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class itemCRUD {
    @Test
    void itemTest() {

    }
    @Data @AllArgsConstructor
    class Item{
        private int id;
        private String name;
        private int price;
    }
    interface ItemService{

    }
    @RequiredArgsConstructor
    class ItemServiceImpl implements ItemService{
        private final Map<String, Item> map;
    }
}
