package ijse.POS.service;

import ijse.POS.entity.Item;

public interface ItemService {

    java.util.List<Item> findAllItems();
    Item findByItemCode(String itemCode);
    Item saveItem(Item item);
    void deleteByItemCode(String itemCode);
    Item updateItem(Item item , String itemCode);
}
