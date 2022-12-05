package com.example.demo.service.jpa.board.product;

import com.example.demo.controller.jpa.request.product.ProductRequest;
import com.example.demo.entity.jpa.board.product.Product;
import com.example.demo.repository.board.product.ProductBoardRepository;
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
    ProductBoardRepository repository;

    /*
    상품 리스트 불러오기
     */
    @Override
    public List<Product> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "productNo"));
    }

    /*
   상품 등록
    */
    @Override
    public void register(ProductRequest productRequest) {
        Product product = new Product();
        product.setTitle(productRequest.getTitle());
        product.setContent(productRequest.getContent());
        product.setWriter(productRequest.getWriter());
        product.setImage(productRequest.getImage());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());

        repository.save(product);
    }

    /*
    등록된 상품 읽기
     */
    @Override
    public Product read(Long productNo) {
        Optional<Product> maybeProductBoard = repository.findById(Long.valueOf(productNo));

        if (maybeProductBoard.equals(Optional.empty())) {
            log.info("Can't read board!!!");
            return null;
        }
        return maybeProductBoard.get();
    }

    /*
    상품 게시글 수정
     */
    @Override
    public void modify(Product product) {
        repository.save(product);
    }

    /*
    등록된 상품 삭제
     */
    @Override
    public void remove(Long productNo) {
        repository.deleteById(Long.valueOf(productNo));
    }

}


