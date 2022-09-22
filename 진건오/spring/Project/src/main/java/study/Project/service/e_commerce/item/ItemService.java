package study.Project.service.e_commerce.item;

import study.Project.controller.e_commerce.request.item.EcommerceItemRequest;
import study.Project.entity.e_commerce.item.EcommerceItem;

import java.util.List;

public interface ItemService {

    public void ecommerceItemRegister(EcommerceItemRequest ecommerceItemRequest);
    public List<EcommerceItem> list();
    public EcommerceItem read(Long itemId);

    public void ecommerceItemModify(EcommerceItem ecommerceItem);

    public void remove(Long itemId);
}
