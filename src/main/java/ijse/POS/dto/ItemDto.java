package ijse.POS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    
    private String itemCode;
    private String itemName;
    private Long categoryId;

}
