package kr.eddi.demo.service.jpa.productBoard;

import kr.eddi.demo.entity.jpa.productBoard.ProductBoard;
import kr.eddi.demo.repository.productBoard.ProductBoardRepository;
import kr.eddi.demo.service.jpa.productBoard.requested.ProductBoardRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductBoardServiceImpl implements ProductBoardService{

    @Autowired
    ProductBoardRepository pbRepository;

    @Override
    public void register(ProductBoardRequest productBoardRequest) {

        ProductBoard productBoard = new ProductBoard();

        productBoard.setProductName(productBoardRequest.getProductName());
        productBoard.setPrice(productBoardRequest.getPrice());
        productBoard.setContent(productBoardRequest.getContent());

        pbRepository.save(productBoard);

    }

    @Override
    public List<ProductBoard> list() {
        return pbRepository.findAll(Sort.by(Sort.Direction.DESC, "productNo"));
    }

    @Override
    public ProductBoard read(Long productNo) {

        Optional<ProductBoard> maybePB = pbRepository.findById(productNo);

        if(maybePB.isEmpty()) {
            log.info("Can't read this product!");
            return null;
        }
        else {
            return maybePB.get();
        }
    }

    @Override
    public void Delete(Long productNo) {
        pbRepository.deleteById(productNo);
    }

    @Override
    public void modify(ProductBoard productBoard) {
        pbRepository.save(productBoard);
    }
}
