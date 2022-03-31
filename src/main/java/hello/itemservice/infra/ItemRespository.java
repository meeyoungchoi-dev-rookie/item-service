package hello.itemservice.infra;

import hello.itemservice.domain.item.dto.Item;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ItemRespository {
    Long save(Item item);

    Long createSequence();

    Item findById(Long itemId);

    List<Item> findAll();

    void update(Item updated, Long itemId);

    public void clearStore();

    public void delete(Long itemId);
}
