package sg.edu.nus.iss.vttp5a_day2l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day2l.model.Item;

@Repository
public class ItemRepo {
    private List<Item> itemList;

    public List<Item> getItems() {
        itemList = new ArrayList<>();

        Item itm = new Item("Apple M4 mini", 5);
        itemList.add(itm);
        itm = new Item("iPhone 16 max pro", 15);
        itemList.add(itm);
        itm = new Item("Prada wallet", 25);
        itemList.add(itm);
        itm = new Item("Hermes Tote Bag", 10);
        itemList.add(itm);
        itm = new Item("LV suitcase", 8);
        itemList.add(itm);

        return itemList;
    }
}
