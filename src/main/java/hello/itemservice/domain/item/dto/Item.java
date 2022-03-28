package hello.itemservice.domain.item.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {
    private Long item_id;
    private String itemName;
    private Integer itemPrice; // 가격이 안들어갈 가능성이 있다
    private Integer itemCount; // 수량이 안들어갈 가능성이 있다

    public Item() {
    }

    public Item(String itemName, Integer itemPrice, Integer itemCount) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemCount=" + itemCount +
                '}';
    }
}
