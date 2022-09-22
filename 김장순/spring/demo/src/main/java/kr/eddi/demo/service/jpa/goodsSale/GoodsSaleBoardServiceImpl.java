package kr.eddi.demo.service.jpa.goodsSale;

import kr.eddi.demo.entity.jpa.goodsSaleBoards.GoodsSaleBoard;
import kr.eddi.demo.entity.jpa.goodsSaleBoards.request.ProductRequest;
import kr.eddi.demo.repository.goodsSale.GoodsSaleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodsSaleBoardServiceImpl implements GoodsSaleBoardService {

    @Autowired
    GoodsSaleRepository goodsRepository;



    @Override
    public List<GoodsSaleBoard> list() {

        return goodsRepository.findAll(Sort.by(Sort.Direction.DESC,"boardNo"));
    }
    @Override
    public void register(ProductRequest productRequest){
        GoodsSaleBoard board = new GoodsSaleBoard();
        board.setTitle(productRequest.getTitle());
        board.setSeller(productRequest.getSeller());
        board.setPrice(productRequest.getPrice());
        board.setContent(productRequest.getContent());

        goodsRepository.save(board);
    }


}
