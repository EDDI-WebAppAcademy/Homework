package kr.eddi.product.service;

import kr.eddi.product.controller.request.GoodsRequest;
import kr.eddi.product.entity.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> list();

    public void register(GoodsRequest goodsRequest);

    public Goods read(Long goodsNo);
}
