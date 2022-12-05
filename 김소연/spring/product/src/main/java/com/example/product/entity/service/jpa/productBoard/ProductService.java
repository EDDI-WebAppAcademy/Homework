package com.example.product.entity.service.jpa.productBoard;

import com.example.product.controller.jpa.productBoard.request.ProductRequest;
import com.example.product.entity.jpa.productBoard.Product;

import java.util.List;

public interface ProductService {

    public void register(ProductRequest productRequest);
    public List<Product> list();
    public Product read(Long productNo);
    public void modify(Product product);
    public void remove(Long productNo);

}
