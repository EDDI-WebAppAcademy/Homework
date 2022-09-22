package kr.eddi.demo.service.jpa.productBoard;

import kr.eddi.demo.controller.jpa.productBoard.request.ProductBoardRequest;
import kr.eddi.demo.entity.jpa.productBoards.ProductBoard;
import kr.eddi.demo.repository.productBoard.ProductBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductBoardServiceImpl implements ProductBoardService {
    @Autowired
    ProductBoardRepository productBoardRepository;

    @Override
    public void register(ProductBoardRequest productBoardRequest) {
        ProductBoard productBoard = new ProductBoard();

        productBoard.setProductName(productBoardRequest.getProductName());
        productBoard.setPrice(productBoard.getPrice());
        productBoard.setSeller(productBoard.getSeller());
        productBoard.setContent(productBoard.getContent());

        productBoardRepository.save(productBoard);
    };
    @Override
    public List<ProductBoard> productList() {
        return null;
    }

    @Override
    public ProductBoard read(Long productNo) {
        return null;
    }

    @Override
    public void modify(ProductBoard productBoard) {

    }
    @Override
    public void remove(Long productNo) {

    }
}
