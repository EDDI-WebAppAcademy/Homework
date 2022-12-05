package kr.eddi.demo.service.jpa.products;

import kr.eddi.demo.entity.jpa.products.Product;
import kr.eddi.demo.entity.jpa.products.request.ProductRequest;

import java.util.List;

public interface ProductService {
    public List<Product> list();

    public void register(ProductRequest productRequest);

}
