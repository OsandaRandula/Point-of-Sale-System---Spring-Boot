package ijse.POS.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ijse.POS.entity.OrderDetails;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long>{

    List<OrderDetails> findByOrderOrderId(Long orderId);
    
}
