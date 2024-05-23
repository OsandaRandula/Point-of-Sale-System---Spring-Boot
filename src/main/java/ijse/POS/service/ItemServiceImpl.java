package ijse.POS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ijse.POS.entity.Item;
import ijse.POS.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAllItems() {

        return itemRepository.findAll();
          
    }

    @Override
    public Item findByItemCode(String itemCode) {
        
        return itemRepository.findById(itemCode).orElse(null);
    }

    @Override
    public Item saveItem(Item item) {
        
        return itemRepository.save(item);
    }

    @Override
    public void deleteByItemCode(String itemCode) {
        
        itemRepository.deleteById(itemCode);
    }

    @Override
    public Item updateItem(Item item , String itemCode) {
        
        Item updatedItem = itemRepository.findById(itemCode).orElse(null);

        updatedItem.setItemName(item.getItemName());
        updatedItem.setItemCategory(item.getItemCategory());

        return itemRepository.save(updatedItem);

    }
    
}
