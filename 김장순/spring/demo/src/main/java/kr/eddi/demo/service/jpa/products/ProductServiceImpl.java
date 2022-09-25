package kr.eddi.demo.service.jpa.products;

import kr.eddi.demo.entity.jpa.products.Product;
import kr.eddi.demo.entity.jpa.products.request.ProductRequest;
import kr.eddi.demo.repository.products.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductsRepository goodsRepository;



    @Override
    public List<Product> list() {

        return goodsRepository.findAll(Sort.by(Sort.Direction.DESC,"boardNo"));
    }
    @Override
    public void register(ProductRequest productRequest){
        Product board = new Product();
        board.setTitle(productRequest.getTitle());
        board.setSeller(productRequest.getSeller());
        board.setPrice(productRequest.getPrice());
        board.setContent(productRequest.getContent());

        goodsRepository.save(board);
    }


}
