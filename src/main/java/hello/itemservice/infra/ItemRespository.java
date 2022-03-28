package hello.itemservice.infra;

import hello.itemservice.domain.item.dto.Item;

import java.util.List;

public interface ItemRespository {
    Long save(Item item);

    Item findById(Long itemId);

    List<Item> findAll();

    void update(Item updated, Long itemId);

    public void clearStore();

    public void delete(Long itemId);
}
