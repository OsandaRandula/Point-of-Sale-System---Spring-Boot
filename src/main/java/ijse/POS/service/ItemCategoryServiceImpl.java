package ijse.POS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ijse.POS.entity.ItemCategory;
import ijse.POS.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllCategories() {
        
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory getItemCategoryById(Long id) {
        
        return itemCategoryRepository.findById(id).orElse(null);

    }

    @Override
    public ItemCategory saveCategory(ItemCategory itemCategory) {
        
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        
        itemCategoryRepository.deleteById(id);
    }

    @Override
    public ItemCategory updateCategory(Long id, ItemCategory itemCategory) {

        ItemCategory updatedCategory = itemCategoryRepository.findById(id).orElse(null);
        if(updatedCategory == null){
            return null;
        }

        updatedCategory.setCategoryName(itemCategory.getCategoryName());

        return itemCategoryRepository.save(updatedCategory);


     }

   
}
