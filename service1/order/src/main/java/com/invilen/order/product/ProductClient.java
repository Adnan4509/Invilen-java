package com.invilen.order.product;

import java.util.List;

public interface ProductClient {
    List<PurchaseResponse> getProductById(List<PurchaseRequest> requests);
}
