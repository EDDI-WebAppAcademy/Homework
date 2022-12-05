package lbk.homework.day0917.makeGame.controller;

import lbk.homework.day0917.makeGame.controller.request.RequestBuyItems;
import lbk.homework.day0917.makeGame.entity.item.ShopItem;
import lbk.homework.day0917.makeGame.manager.ShopManager;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Getter
@ToString
@RestController
@RequestMapping("/2nd")
@CrossOrigin(origins="http://localhost:8080", allowedHeaders = "*")
public class ItemController {

   ShopManager shopManager = new ShopManager();
   CharacterController characterController = new CharacterController();
   List<ShopItem> receiveInvoiceList;


   @PostMapping("/receive-invoice")
   public void receiveBuyItemsData(@RequestBody RequestBuyItems requestBuyItems) {
      log.info("결제요청이 날라왔습니다.");
      receiveInvoiceList = requestBuyItems.getShoppingCart();
   }

   @GetMapping("/response-availability-of-purchase")
   public boolean checkMoneyInPocket() {
      // 구매가능 여부 체크해서 프론트 단에 전달하는 메서드

      Integer moneyIHave = characterController.getCharacter().getCharacterStatus().getMoney();
      Integer sum = 0;
      int size = receiveInvoiceList.size();

      for (int i = 0; i < size; i++){
         sum += receiveInvoiceList.get(i).getPrice();
      }

        if (moneyIHave >= sum) {

            log.info("구매가능");
            return true;
        }
      log.info("구매 불가" + moneyIHave + " : " + sum);
      return false;
   }

   @GetMapping("/response-shop-items")
   public List<ShopItem> responseShopItems() {
      return shopManager.prepareToSellItems();
   }
}
