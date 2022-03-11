package hello.itemservice.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private  Long item_id;
    private String itemName;
    private Integer itemPrice; // 가격이 안들어갈 가능성이 있다
    private Integer itemCount; // 수량이 안들어갈 가능성이 있다

    public Item() {
    }

    public Item(Long item_id, String itemName, Integer itemPrice, Integer itemCount) {
        this.item_id = item_id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }
}
