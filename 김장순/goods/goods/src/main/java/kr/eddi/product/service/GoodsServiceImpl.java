package kr.eddi.product.service;

import kr.eddi.product.controller.request.GoodsRequest;
import kr.eddi.product.entity.Goods;
import kr.eddi.product.repository.GoodsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsRepository repository;

    @Override
    public List<Goods> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "goodsNo"));
    }

    @Override
    public void register(GoodsRequest goodsRequest) {
        Goods goods = new Goods();
        goods.setGoodsName(goodsRequest.getGoodsName());
        goods.setGoodsDescription(goodsRequest.getGoodsDescription());
        goods.setPrice(goodsRequest.getPrice());
        goods.setSeller(goodsRequest.getSeller());

        repository.save(goods);
    }

    @Override
    public Goods read(Long goodsNo) {
        Optional<Goods> maybeGoods = repository.findById(goodsNo);

        if (maybeGoods.equals(Optional.empty())) {
            log.info("Can't read goods!!!");
            return null;
        }
        return maybeGoods.get();
    }
}
