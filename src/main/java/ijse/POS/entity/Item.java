package ijse.POS.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {

    @Id
    private String itemCode;

    private String itemName;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private ItemCategory itemCategory;

    @JsonIgnore
    @OneToOne(mappedBy = "item",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Stock stock;

    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<OrderDetails> orderList;

    
}
