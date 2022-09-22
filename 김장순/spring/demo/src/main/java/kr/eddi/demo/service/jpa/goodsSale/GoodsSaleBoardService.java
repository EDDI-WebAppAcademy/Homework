package kr.eddi.demo.service.jpa.goodsSale;

import kr.eddi.demo.entity.jpa.goodsSaleBoards.GoodsSaleBoard;
import kr.eddi.demo.entity.jpa.goodsSaleBoards.request.ProductRequest;

import java.util.List;

public interface GoodsSaleBoardService {
    public List<GoodsSaleBoard> list();

    public void register(ProductRequest productRequest);

}
