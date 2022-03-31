package hello.itemservice.infra;

import hello.itemservice.domain.item.dto.Item;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class ItemRepositoryImpl implements ItemRespository {

    private static final Map<Long, Item> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Long save(Item item) {
        store.put(item.getItem_id(), item);
        return item.getItem_id();
    }

    @Override
    public Long createSequence() {
        return sequence += 1;
    }

    @Override
    public Item findById(Long itemId) {
        Item itemFound = store.get(itemId);
        log.info("itemFound: {}" , itemFound.toString() );
        return store.get(itemId);
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>(store.values());
        return items;
    }

    @Override
    public void update(Item updated, Long itemId) {
        Item before = findById(itemId);
        before = updated;
        Item itemUpdated = before;
        itemUpdated.setItem_id(itemId);
        store.put(itemId, itemUpdated);
    }

    @Override
    public void clearStore() {
        store.clear();
    }

    @Override
    public void delete(Long itemId) {
        store.remove(itemId);
    }
}
