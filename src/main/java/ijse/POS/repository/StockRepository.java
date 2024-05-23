package ijse.POS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ijse.POS.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository < Stock, String > {
    
}
