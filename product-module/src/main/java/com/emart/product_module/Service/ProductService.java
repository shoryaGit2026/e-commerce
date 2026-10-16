package com.emart.product_module.Service;

import org.springframework.stereotype.Service;

@Service 
public class ProductService {

    public Long checkStockAvailability(Long productId, Integer requestedQuantity) {
       if(productId == null || requestedQuantity == null || requestedQuantity <= 0) {
            throw new IllegalArgumentException("Invalid product ID or requested quantity");
        }else if (productId == 1L && requestedQuantity <= 10) {
            return 1L; // Product is available
        } else if (productId == 2L && requestedQuantity <= 5) {
            return 2L; // Product is available
        } else if (productId == 3L && requestedQuantity <= 20) {
            return 3L; // Product is available
        }
        return 0L;
    }

}
