package hello.itemservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/basic/items")
public class ItemController {

    @GetMapping()
    public String items() {
        log.error("/basic/items");
        return "items/items";
    }

    @GetMapping("/new")
    public String addItem() {
        return "items/new";
    }




}
