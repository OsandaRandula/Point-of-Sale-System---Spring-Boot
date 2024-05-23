package ijse.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ijse.POS.entity.ItemCategory;


public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {

}