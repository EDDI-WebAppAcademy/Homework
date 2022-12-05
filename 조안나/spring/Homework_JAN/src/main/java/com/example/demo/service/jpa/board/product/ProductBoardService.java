package com.example.demo.service.jpa.board.product;

import com.example.demo.controller.jpa.request.product.ProductRequest;
import com.example.demo.entity.jpa.board.product.Product;

import java.util.List;

public interface ProductBoardService {
    public List<Product> list();
    public void register(ProductRequest productRequest);
    public Product read(Long boardNo);
    public void modify(Product productBoard);
    public void remove(Long boardNo);

}
