package hello.itemservice.controller;

import hello.itemservice.domain.item.dto.Item;
import hello.itemservice.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostConstruct
    public void init() {
        itemService.save(new Item("itemA", 1000 , 10));
        itemService.save(new Item("itemB", 2000, 20));
    }

    @GetMapping()
    public String items(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "items/items";
    }

    @GetMapping("/new")
    public String addItem() {
        return "items/new";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("item") Item item) {
        itemService.save(item);
        return "redirect:/basic/items";
    }

    @GetMapping("/detail/{item_id}")
    public String detail(@PathVariable("item_id") Long itemId , Model model) {
        Item saved = itemService.findById(itemId);
        model.addAttribute("saved", saved);
        return "items/detail";
    }

    @GetMapping("/update/{item_id}")
    public String update(@PathVariable("item_id") Long itemId, Model model) {
        Item item = itemService.findById(itemId);
        model.addAttribute("item", item);
        return "items/update";
    }

    @PostMapping("/update")
    public String updateed( Item item) {
        itemService.update(item, item.getItem_id());
        return "redirect:/basic/items/detail/" + item.getItem_id();
    }

    @GetMapping("/delete/{item_id}")
    public String delete(@PathVariable("item_id") Long itemId) {
        itemService.delete(itemId);
        return "redirect:/basic/items";
    }
}
