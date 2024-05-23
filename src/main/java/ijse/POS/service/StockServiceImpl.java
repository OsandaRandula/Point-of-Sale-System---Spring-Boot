package ijse.POS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ijse.POS.entity.Stock;
import ijse.POS.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> findAllStock() {
        
        return stockRepository.findAll();
    }

    @Override
    public Stock findByStockId(String itemCode) {
        
        return stockRepository.findById(itemCode).orElse(null);
    }

    @Override
    public Stock saveStock(Stock stock) {
        
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock, String stockId) {
        
        Stock updatedStock = stockRepository.findById(stock.getItemCode()).orElse(null);
        if(updatedStock==null){
            return null;
        }
        
        updatedStock.setQtyOnHand(stock.getQtyOnHand());
        updatedStock.setUnit(stock.getUnit());
        updatedStock.setUnitPrice(stock.getUnitPrice());

        return stockRepository.save(updatedStock);
        
    }

    


}
