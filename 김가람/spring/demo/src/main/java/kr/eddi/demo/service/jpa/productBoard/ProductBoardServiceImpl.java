package kr.eddi.demo.service.jpa.productBoard;

import kr.eddi.demo.controller.jpa.productBoard.request.ProductRequest;
import kr.eddi.demo.entity.jpa.productBoard.Product;
import kr.eddi.demo.repository.productBoard.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductBoardServiceImpl implements ProductBoardService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> list() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "productNo"));
    }

    @Override
    public void register(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setStock(productRequest.getStock());
        product.setDescription(product.getDescription());

        productRepository.save(product);
    }
}
