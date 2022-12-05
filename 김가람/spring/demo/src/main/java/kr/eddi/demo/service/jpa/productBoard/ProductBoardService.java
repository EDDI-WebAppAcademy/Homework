package kr.eddi.demo.service.jpa.productBoard;

import kr.eddi.demo.controller.jpa.productBoard.request.ProductRequest;
import kr.eddi.demo.entity.jpa.productBoard.Product;

import java.util.List;

public interface ProductBoardService {

    public List<Product> list();
    public void register(ProductRequest productRequest);
}
