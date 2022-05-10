package kr.co.clozet.common.dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Map;

public class itemCRUD {
    public static void main(String[] args) {

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
