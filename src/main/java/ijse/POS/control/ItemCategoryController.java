package ijse.POS.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ijse.POS.entity.ItemCategory;
import ijse.POS.service.ItemCategoryService;

@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/categories")
    public List<ItemCategory> getItemCategories(){

        return itemCategoryService.getAllCategories();
        
    }

    @GetMapping("/categories/{id}")
    public ItemCategory getItemCategoryById(@PathVariable Long id){

        return itemCategoryService.getItemCategoryById(id);

    }

    @PostMapping("/categories")
    public ItemCategory saveItemCategory(@RequestBody ItemCategory itemCategory){

        return itemCategoryService.saveCategory(itemCategory);

    }

    @DeleteMapping("/categories/{id}")
    public void deleteItemCategory(@PathVariable Long id){

        itemCategoryService.deleteCategory(id);
    }

    @PutMapping("/categories/{id}")
    public ItemCategory updateItemCategory(@PathVariable Long id , @RequestBody ItemCategory itemCategory){

        return itemCategoryService.updateCategory(id, itemCategory);
        
    }
    
}
