package ijse.POS.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockDto {

    private String itemCode;
    private String unit;
    private long qtyOnHand;
    private double unitPrice;
    
}
