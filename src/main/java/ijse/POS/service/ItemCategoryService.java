package ijse.POS.service;


import ijse.POS.entity.ItemCategory;

public interface ItemCategoryService {

    java.util.List<ItemCategory> getAllCategories ();
    ItemCategory getItemCategoryById (Long id);
    ItemCategory saveCategory(ItemCategory itemCategory);
    void deleteCategory(Long id);
    ItemCategory updateCategory(Long id, ItemCategory itemCategory);
    
}
