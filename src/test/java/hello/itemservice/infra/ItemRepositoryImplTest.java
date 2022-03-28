package hello.itemservice.infra;

import hello.itemservice.domain.item.dto.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryImplTest {

    ItemRepositoryImpl itemRepository = new ItemRepositoryImpl();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("itemA", 10000, 10);


        // when
        Long itemId = itemRepository.save(item);

        // then
        Item findItem = itemRepository.findById(itemId);
        System.out.println("findItem: " + findItem.toString());
        Assertions.assertThat(item).isEqualTo(findItem);
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("item1", 1000, 10);
        Item item2 = new Item("item2", 2000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        // when
        List<Item> result = itemRepository.findAll();

        // then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(item1 , item2);
    }

    @Test
    void update() {
        // given
        Item item1 = new Item("item3", 3000 , 25);

        Long itemId = itemRepository.save(item1);

        // when
        Item item1_updated = new Item("item3_수정", 3500 , 30);

        itemRepository.update(item1_updated , itemId);

        Item updated = itemRepository.findById(itemId);

        // then
        Assertions.assertThat(updated.getItemName()).isEqualTo(item1_updated.getItemName());
        Assertions.assertThat(updated.getItemPrice()).isEqualTo(item1_updated.getItemPrice());
        Assertions.assertThat(updated.getItemCount()).isEqualTo(item1_updated.getItemCount());

    }

}