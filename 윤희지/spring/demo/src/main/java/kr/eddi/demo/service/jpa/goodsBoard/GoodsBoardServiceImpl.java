package kr.eddi.demo.service.jpa.goodsBoard;

import kr.eddi.demo.controller.goodsBoard.request.GoodsBoardRequest;
import kr.eddi.demo.entity.goodsBoard.GoodsBoard;
import kr.eddi.demo.repository.goodsBoard.GoodsBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class GoodsBoardServiceImpl implements GoodsBoardService {

    @Autowired
    GoodsBoardRepository repository;

    @Override
    public void register(GoodsBoardRequest goodsBoardRequest) {
        GoodsBoard goodsBoard = new GoodsBoard();
        goodsBoard.setGoodsName(goodsBoardRequest.getGoodsName());
        goodsBoard.setPrice(goodsBoardRequest.getPrice());
        goodsBoard.setSeller(goodsBoardRequest.getSeller());
        goodsBoard.setContent(goodsBoardRequest.getContent());

        repository.save(goodsBoard);
    }

    @Override
    public List<GoodsBoard> list() { return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));}

    @Override
    public GoodsBoard read(Long boardNo) {
        Optional<GoodsBoard> maybeGoodsBoard = repository.findById(boardNo);

        if(maybeGoodsBoard.equals(Optional.empty())) {
            log.info("상품 게시물을 읽을 수 없습니다.");
            return null;
        }
        return maybeGoodsBoard.get();
    }

    @Override
    public void modify(GoodsBoard goodsBoard) {
        repository.save(goodsBoard);
    }

    @Override
    public void remove(Long boardNo) { repository.deleteById(boardNo); }

}
