package hello.itemservice.domain.item.service;

import hello.itemservice.domain.item.dto.Item;
import hello.itemservice.infra.ItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepositoryImpl itemRepository;

    public Long save(Item item) {
        Long sequence = createSequence();
        item.setItem_id(sequence);
        return itemRepository.save(item);
    };

    public Long createSequence() {
        return itemRepository.createSequence();
    }

    public Item findById(Long itemId) {
        return itemRepository.findById(itemId);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public void update(Item updated , Long itemId) {
        itemRepository.update(updated, itemId);
    }

   public void delete(Long itemId) {
        itemRepository.delete(itemId);
   }
}
