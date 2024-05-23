package ijse.POS.service;

import ijse.POS.entity.Stock;

public interface StockService {

    java.util.List<Stock> findAllStock();
    Stock findByStockId(String stockId);
    Stock saveStock(Stock stock);
    Stock updateStock(Stock stock , String stockId);
    
    
}
