package kr.eddi.demo.service.jpa.productBoard;

import kr.eddi.demo.controller.jpa.productBoard.request.ProductBoardRequest;
import kr.eddi.demo.entity.jpa.productBoards.ProductBoard;

import java.util.List;

public interface ProductBoardService {
    public void register(ProductBoardRequest productBoardRequest);
    public List<ProductBoard> productList();
    public ProductBoard read(Long productNo);
    public void modify(ProductBoard productBoard);
    public void remove(Long productNo);
}
