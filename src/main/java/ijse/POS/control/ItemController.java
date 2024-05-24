package ijse.POS.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ijse.POS.dto.ItemDto;
import ijse.POS.entity.Item;
import ijse.POS.entity.ItemCategory;
import ijse.POS.service.ItemCategoryService;
import ijse.POS.service.ItemService;


@RestController
@CrossOrigin(origins = "*" )

public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;


    @GetMapping("/items")
    public List<Item> getItems(){
        return itemService.findAllItems();
    }

    @GetMapping("/items/{itemCode}")
    public Item getItemById(@PathVariable String itemCode){

        return itemService.findByItemCode(itemCode);
    }


    @PostMapping("/items")
    public ResponseEntity<Item> saveItem(@RequestBody ItemDto itemDto){


        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemDto.getCategoryId());

        Item item = new Item();
        item.setItemCode(itemDto.getItemCode());
        item.setItemName(itemDto.getItemName());
        item.setItemCategory(itemCategory);

        return ResponseEntity.status(201).body(itemService.saveItem(item));
        

    }

    @DeleteMapping("/items/{itemCode}")
    public void deleteItem(@PathVariable String itemCode){

        itemService.deleteByItemCode(itemCode);
    }

    @PutMapping("/items/{itemCode}")
    public Item updateItem(@RequestBody ItemDto itemDto , @PathVariable String itemCode){

        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemDto.getCategoryId());

        Item item = new Item();
        item.setItemCode(itemDto.getItemCode());
        item.setItemName(itemDto.getItemName());
        item.setItemCategory(itemCategory);

        return itemService.updateItem(item, item.getItemCode());

    }
    
}
