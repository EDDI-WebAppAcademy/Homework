package study.Project.service.e_commerce.item;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import study.Project.controller.e_commerce.request.item.EcommerceItemRequest;
import study.Project.entity.e_commerce.item.EcommerceItem;
import study.Project.repository.e_commerce.item.EcommerceItemRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    EcommerceItemRepository ecommerceItemRepository;

    @Override
    public void ecommerceItemRegister(EcommerceItemRequest ecommerceItemRequest) {
        EcommerceItem ecommerceItem = new EcommerceItem();
        ecommerceItem.setItemName(ecommerceItemRequest.getItemName());
        ecommerceItem.setSeller(ecommerceItemRequest.getSeller());
        ecommerceItem.setItemPrice(ecommerceItemRequest.getItemPrice());
        ecommerceItem.setItemInformation(ecommerceItemRequest.getItemInformation());

        ecommerceItemRepository.save(ecommerceItem);
    }

    @Override
    public List<EcommerceItem> list() {
        return ecommerceItemRepository.findAll(Sort.by(Sort.Direction.DESC, "itemId"));
    }

    @Override
    public EcommerceItem read(Long itemId) {
        Optional<EcommerceItem> anyThingEcommerceItem = ecommerceItemRepository.findById(itemId);

        if (anyThingEcommerceItem.equals(Optional.empty())) {
            log.info("찾을 수 없습니다.");
            return null;
        }

        return anyThingEcommerceItem.get();
    }

    @Override
    public void ecommerceItemModify(EcommerceItem ecommerceItem) {
        ecommerceItemRepository.save(ecommerceItem);
    }

    @Override
    public void remove(Long itemId) {
        ecommerceItemRepository.deleteById(itemId);

    }
}
