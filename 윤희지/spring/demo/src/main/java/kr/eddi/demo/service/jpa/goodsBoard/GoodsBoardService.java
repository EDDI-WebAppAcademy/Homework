package kr.eddi.demo.service.jpa.goodsBoard;

import kr.eddi.demo.controller.goodsBoard.request.GoodsBoardRequest;
import kr.eddi.demo.entity.goodsBoard.GoodsBoard;

import java.util.List;

public interface GoodsBoardService {

    public void register(GoodsBoardRequest goodsBoardRequest);
    public List<GoodsBoard> list();
    public GoodsBoard read(Long boardNo);
    public void modify(GoodsBoard goodsBoard);
    public void remove(Long boardNo);


}
