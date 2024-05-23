package ijse.POS.repository;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import ijse.POS.entity.OrderDetails;
import ijse.POS.entity.User;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long>{

    List<OrderDetails> findByOrderOrderId(Long orderId);
    
}
