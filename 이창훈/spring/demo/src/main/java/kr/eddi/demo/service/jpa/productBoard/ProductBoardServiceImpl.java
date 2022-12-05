package kr.eddi.demo.service.jpa.productBoard;

import kr.eddi.demo.controller.jpa.productBoard.request.ProductBoardRequest;
import kr.eddi.demo.entity.jpa.productBoards.ProductBoard;
import kr.eddi.demo.repository.productBoard.ProductBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductBoardServiceImpl implements ProductBoardService {
    @Autowired
    ProductBoardRepository productBoardRepository;

    @Override
    public void register(ProductBoardRequest productBoardRequest) {

        ProductBoard productBoard = new ProductBoard();

        productBoard.setProductName(productBoardRequest.getProductName());
        productBoard.setPrice(productBoardRequest.getPrice());
        productBoard.setSeller(productBoardRequest.getSeller());
        productBoard.setContent(productBoardRequest.getContent());

        productBoardRepository.save(productBoard);
    }
    @Override
    public List<ProductBoard> productList() {
        return productBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "productNo"));
    }

    @Override
    public ProductBoard read(Long productNo) {
        Optional<ProductBoard> maybeProductBoard = productBoardRepository.findById(Long.valueOf(productNo));

        if (maybeProductBoard.equals(Optional.empty())) {
            log.info("Can't read board!!!");
            return null;
        }

        return maybeProductBoard.get();
    }

    @Override
    public void modify(ProductBoard productBoard) {
        productBoardRepository.save(productBoard);
    }
    @Override
    public void remove(Long productNo) {
        productBoardRepository.deleteById(Long.valueOf(productNo));
    }
}
