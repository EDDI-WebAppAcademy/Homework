package kr.eddi.demo.service.jpa.productBoard;

import kr.eddi.demo.controller.jpa.productBoard.requst.ProductBoardRequest;
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

    }

    @Override
    public List<ProductBoard> list() {
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
