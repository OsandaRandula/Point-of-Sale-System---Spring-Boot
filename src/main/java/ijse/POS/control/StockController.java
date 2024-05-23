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

import ijse.POS.dto.StockDto;
import ijse.POS.entity.Item;
import ijse.POS.entity.Stock;
import ijse.POS.service.ItemService;
import ijse.POS.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/auth/stocks")
    public List<Stock> getstocks(){
        return stockService.findAllStock();
    }

    @GetMapping("/auth/stocks/{itemCode}")
    public Stock getstockById(@PathVariable String itemCode){

        return stockService.findByStockId(itemCode);
    }

    @PostMapping("/auth/stocks")
    public Stock saveStock(@RequestBody StockDto stockDto){

        Item item = itemService.findByItemCode(stockDto.getItemCode());
        Stock stock = new Stock();
        stock.setItemCode(stockDto.getItemCode());
        stock.setQtyOnHand(stockDto.getQtyOnHand());
        stock.setUnit(stockDto.getUnit());
        stock.setUnitPrice(stockDto.getUnitPrice());
        stock.setItem(item);

        return stockService.saveStock(stock);

    }

    @PutMapping("/auth/stocks/{itemCode}")
    public Stock updateStock( @RequestBody StockDto stockDto, @PathVariable String itemCode){

        Item item = itemService.findByItemCode(stockDto.getItemCode());
        Stock stock = new Stock();
        stock.setItemCode(stockDto.getItemCode());
        stock.setQtyOnHand(stockDto.getQtyOnHand());
        stock.setUnit(stockDto.getUnit());
        stock.setUnitPrice(stockDto.getUnitPrice());
        stock.setItem(item);

        return stockService.updateStock(stock, stockDto.getItemCode());
        

    }

    


    
}
