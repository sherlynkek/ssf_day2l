package sg.edu.nus.iss.vttp5a_day2l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_day2l.model.Item;
import sg.edu.nus.iss.vttp5a_day2l.service.itemService;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    itemService itmService;


    @GetMapping()
    public String cartItems(Model model){

        List<Item> items = itmService.getItems();
        model.addAttribute("items", items);

        return "cartList";
    }

    @GetMapping("/filter")
    public String filtercartItems(@RequestParam("itemQuantity") String quantity, Model model) {

        List<Item> items = itmService.getItems();
        items = items.stream().filter(a -> a.getQuantity() >= Integer.parseInt(quantity))
        .collect(Collectors.toList());
        model.addAttribute("items", items);

        return "cartList";
    }
}