package ijse.POS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailsId;

    private Long quntity;
    private Double unitPrice;
    private Double totalItemPrice;

    @ManyToOne
    @JoinColumn(name = "item_code")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;


}
