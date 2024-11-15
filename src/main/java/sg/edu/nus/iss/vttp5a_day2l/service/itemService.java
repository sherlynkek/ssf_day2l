package sg.edu.nus.iss.vttp5a_day2l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_day2l.model.Item;
import sg.edu.nus.iss.vttp5a_day2l.repo.ItemRepo;


@Service
public class itemService {
    
    @Autowired
    ItemRepo itemRepo;

    public List<Item> getItems(){
        return itemRepo.getItems();
    }
}
