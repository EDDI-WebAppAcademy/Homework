package kr.eddi.demo.service.jpa.productBoard;

import kr.eddi.demo.entity.jpa.productBoard.ProductBoard;
import kr.eddi.demo.service.jpa.productBoard.requested.ProductBoardRequest;

import java.util.List;

public interface ProductBoardService {

    public void register(ProductBoardRequest productBoardRequest);

    public List<ProductBoard> list();

    public ProductBoard read(Long productNo);

    public void Delete(Long productNo);

    public void modify(ProductBoard productBoard);
}
