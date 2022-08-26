package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public  void whenItemDescByNameTest() {
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        List<Item> items = new ArrayList<>(List.of(item1, item3, item2));
        items.sort(new ItemDescByName());
        List<Item> expected = List.of(item3, item2, item1);
        assertThat(items).isEqualTo(expected);
    }
}