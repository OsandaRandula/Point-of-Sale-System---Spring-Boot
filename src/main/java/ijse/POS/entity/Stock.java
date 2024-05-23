package ijse.POS.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Stock {

    @Id
    private String itemCode;
    private String unit;
    private Long qtyOnHand;
    private double unitPrice;
        
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "itemCode")
    private Item item;
    
}
